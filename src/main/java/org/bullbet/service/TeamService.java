package org.bullbet.service;

import org.bullbet.entity.Team;


public interface TeamService {

    String updateTeam(Long id, Team Team);

    Team updateTeam(Team Team);

    Team getTeam(Long id);

    String removeTeam(Long id);
}
