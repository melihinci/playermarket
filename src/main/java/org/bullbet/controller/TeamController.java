package org.bullbet.controller;

import org.bullbet.entity.Team;
import org.bullbet.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class TeamController {

    @Autowired
    TeamService teamService;

    @GetMapping(path = "/team/{id}")
    public Team getTeam(@PathVariable Long id) {
        return teamService.getTeam(id);
    }

    @PutMapping(path = "/team/{id}")
    public String setTeam(@PathVariable Long id, @RequestBody Team team) {
        return teamService.updateTeam(id, team);
    }

    @PostMapping(path = "/team")
    public String newTeam(@RequestBody Team team) {
        return teamService.updateTeam(team);
    }

    @DeleteMapping(path = "/team/{id}")
    public String removeTeam(@PathVariable Long id) {
        return teamService.removeTeam(id);
    }
}
