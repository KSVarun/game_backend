package com.sundarland.game.services;

import com.sundarland.game.bean.Game;
import com.sundarland.game.exceptions.GameException;
import com.sundarland.game.repository.GameRepository;
import org.aspectj.weaver.IEclipseSourceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    public Page<Game> findAllGameData(Pageable pageable) {
        return gameRepository.findAll(pageable);
    }

    public Iterable<Game> findGamesByName(String title){
        return gameRepository.findByTitle(title);
    }

    public Game addNewGame(Game game) {
        return gameRepository.save(game);
    }

    public void deleteGame(Long id) {

        try{
            gameRepository.deleteById(id);
        }catch (Exception e){
            throw new GameException("ID does not exists");
        }
    }

    public Game updateGame(Long id, Game game) {
        return gameRepository.save(game);
    }

//    public void deleteAllGamesByTitle(String title) {
//        gameRepository.deleteByTitle(title);
//    }
}
