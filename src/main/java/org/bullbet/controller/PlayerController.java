package org.bullbet.controller;

import org.bullbet.entity.Player;
import org.bullbet.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class PlayerController {

    @Autowired
    PlayerService playerService;


    @GetMapping(path = "/player/{id}")
    public Player getPlayer(@PathVariable Long id) {
        return playerService.getPlayer(id);
    }

    @PutMapping(path = "/player/{id}")
    public String setPlayer(@PathVariable Long id, @RequestBody Player player) {
        return playerService.updatePlayer(id, player);
    }

    @PostMapping(path = "/player")
    public String newPlayer(@RequestBody Player player) {
        return playerService.updatePlayer(player);
    }

    @DeleteMapping(path = "/player/{id}")
    public String removePlayer(@PathVariable Long id) {
        return playerService.removePlayer(id);
    }
}
