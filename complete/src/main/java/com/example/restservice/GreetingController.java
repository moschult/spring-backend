package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@RestController
@Controller
@RequestMapping(path="/api")
public class GreetingController {

    @Autowired
    private GameRepository gameRepository;
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @PostMapping("/create")
//    public Game createGame() {
//        return new Game(counter.incrementAndGet(), "Test");
//    }
    public @ResponseBody String addNewGame(@RequestParam String name) {
        Game game = new Game();
        game.setName(name);
        gameRepository.save(game);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Game> getAllGames() {
        return gameRepository.findAll();
    }
}
