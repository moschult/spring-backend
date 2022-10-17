package com.example.restservice.game;

import com.example.restservice.Game;
import com.example.restservice.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping(path + "/{id}")
    public @ResponseBody Optional<Game> getGameById(@PathVariable Integer id) {
        return gameRepository.findById(id);
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

    /**
     * Todo: Add check, if variable exists after deletion. Otherwise deletion
     * was not successfull and a notfound should be returned
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = path + "/{id}")
    public ResponseEntity<HttpStatus> deleteGame(@PathVariable Integer id) {
        gameRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
