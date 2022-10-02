package org.bullbet.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

import javax.annotation.PostConstruct;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Player operations Api documentation")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping(path = "/player/{id}")
    @ApiOperation(value = "Player info viewing method")
    public Player getPlayer(@PathVariable Long id) {
        return playerService.getPlayer(id);
    }

    @PutMapping(path = "/player/{id}")
    @ApiOperation(value = "Player will be updated by player's id")
    public String setPlayer(@PathVariable Long id, @RequestBody Player player) {
        return playerService.updatePlayer(id, player);
    }

    @PostMapping(path = "/player")
    @ApiOperation(value = "New Player adding method")
    public String newPlayer(@RequestBody Player player) {
        return playerService.updatePlayer(player);
    }

    @DeleteMapping(path = "/player/{id}")
    @ApiOperation(value = "Player will remove by its id")
    public String removePlayer(@PathVariable Long id) {
        return playerService.removePlayer(id);
    }
}
