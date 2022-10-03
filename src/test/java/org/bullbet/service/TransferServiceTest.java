package org.bullbet.service;

import org.bullbet.entity.Player;
import org.bullbet.entity.Team;
import org.bullbet.repository.PlayerRepository;
import org.bullbet.repository.TeamRepository;
import org.bullbet.repository.TransferHistoryRepository;
import org.bullbet.service.impl.TeamServiceImpl;
import org.bullbet.service.impl.TransferServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.util.collections.ListUtil;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class TransferServiceTest {

    @Mock
    TransferHistoryRepository transferHistoryRepository;

    @Mock
    PlayerRepository playerRepository;

    @Mock
    TeamRepository teamRepository;

    @Mock
    TeamService teamService;

    @Mock
    PlayerService playerService;

    @InjectMocks
    TransferServiceImpl transferService;

    @Test
    public void after_transfer_should_return_player_with_new_Team() {
        Team testTeam1 = new Team(1l, "testteam1", null);
        Team testTeam2 = new Team(2l, "testteam2", null);
        Player testPlayer = new Player(1l, "test,test", "202101", 30, 1l, testTeam1);
        when(playerRepository.findById(any())).thenReturn(Optional.of(testPlayer));
        when(teamRepository.findById(2l)).thenReturn(Optional.of(testTeam2));
        when(playerService.calculatePlayerValue(anyLong())).thenReturn(1000l);
        when(playerRepository.save(any())).thenReturn(any());
        Player transferredPlayer = transferService.fullfillTransfer(1, 2);
        assertAll(
                () -> assertEquals(transferredPlayer.getTeamId(), 2l)
        );
    }

}
