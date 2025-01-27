package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();

        return dto;
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        // Atualização em memória da posição
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        // A origem e destino (primeira e última posições) não são alterados
        // Determina os valores mínimo e máximo entre os índices sourceIndex e destinationIndex
        // Garante que min sempre terá o menor valor e max sempre terá o maior valor entre os dois índices fornecidos
        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        // Atualiza a posição dos elementos no intervalo [min, max] na lista no banco de dados
        // Parâmetros do metodo updateBelongingPosition:
        // listId: O ID da lista que está sendo atualizada
        // list.get(i).getId(): O ID do jogo na posição i da lista
        // i: A nova posição do jogo na lista
        for (int i = min; i <= max; i++){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }

}
