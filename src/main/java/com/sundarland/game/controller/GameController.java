package com.sundarland.game.controller;

import com.sundarland.game.bean.Game;
import com.sundarland.game.services.ApiService;
import com.sundarland.game.services.GameService;
import com.sundarland.game.services.ValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController

public class GameController {

    @Autowired
    GameService gameService;

    @Autowired
    ValidationErrorService validationErrorService;

    @Autowired
    ApiService apiService;



    @GetMapping("/")
    public ResponseEntity<?> findAllGame(@PageableDefault Pageable pageable,@RequestHeader(value="X-API-Key") String key){
        if(apiService.validateApiKey(key)) {
            return new ResponseEntity<Iterable<Game>>(gameService.findAllGameData(pageable), HttpStatus.OK);
        }
        return new ResponseEntity<String>("BAD_REQUEST",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{title}")
    public ResponseEntity<?> findAllGamesByName(@PageableDefault Pageable pageable, @PathVariable String title,@RequestHeader(value="X-API-Key") String key){
        if(apiService.validateApiKey(key)) {
            return new ResponseEntity<Iterable<Game>>(gameService.findGamesByName(title),HttpStatus.OK);
        }
        return new ResponseEntity<String>("BAD_REQUEST",HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/new")
    public ResponseEntity<?> addNewGame(@Valid @RequestBody Game game, BindingResult result){
        ResponseEntity<?> errorMap = validationErrorService.ValidationService(result);
        if(errorMap!=null) return errorMap;
        Game newGame=gameService.addNewGame(game);
    return new ResponseEntity<Game>(newGame,HttpStatus.CREATED);}

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteGame(@PathVariable Long id){gameService.deleteGame(id);
    return new ResponseEntity<String>("Game Deleted",HttpStatus.OK);}

    @PutMapping("{id}")
    public void updateGame(@PathVariable Long id, @RequestBody Game game){gameService.updateGame(id, game);}

//    @DeleteMapping("/title/{title}")
//    public void deleteAllGamesByTitle(@PathVariable String title){gameService.deleteAllGamesByTitle(title);}
}
