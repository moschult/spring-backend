package com.example.restservice.game;

import com.example.restservice.Game;
import com.example.restservice.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api")
public class GameController {

    private static final String path = "/game";

    @Autowired
    private GameRepository gameRepository;

    @GetMapping(path = path)
    public @ResponseBody Iterable<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @PostMapping(path = path)
    public ResponseEntity<Game> addGame(@RequestBody Game game) {
        Game gameDb = new Game();
        gameDb.setName(game.getName());
        gameRepository.save(gameDb);
        return ResponseEntity.ok(gameDb);
    }

    @PutMapping(path)
    public ResponseEntity<Game> putGame(@RequestBody Game game) {
        gameRepository.save(game);
        return ResponseEntity.ok(game);
    }
}
