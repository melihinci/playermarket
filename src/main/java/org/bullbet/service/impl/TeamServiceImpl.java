package org.bullbet.service.impl;

import org.bullbet.entity.Team;
import org.bullbet.repository.TeamRepository;
import org.bullbet.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "teamService")
public class TeamServiceImpl implements TeamService {

    @Autowired
    TeamRepository teamRepository;

    @Override
    public String updateTeam(Long id, Team team) {
        Team teamOld = teamRepository.findById(id).get();
        teamOld.setName(team.getName());
        teamRepository.save(teamOld);
        return "{ \"success\" : true }";
    }

    @Override
    public String updateTeam(Team team) {
        teamRepository.save(team);
        return "{ \"success\" : true }";
    }

    @Override
    public Team getTeam(Long id) {
        return teamRepository.findById(id).get();
    }

    @Override
    public String removeTeam(Long id) {
        teamRepository.deleteById(id);
        return "{ \"success\" : true }";
    }
}
