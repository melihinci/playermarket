package org.bullbet.service.impl;

import org.bullbet.entity.Player;
import org.bullbet.entity.Team;
import org.bullbet.entity.TransferHistory;
import org.bullbet.repository.PlayerRepository;
import org.bullbet.repository.TeamRepository;
import org.bullbet.repository.TransferHistoryRepository;
import org.bullbet.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Component(value = "transferService")
public class TransferServiceImpl implements TransferService {


    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    TransferHistoryRepository transferHistoryRepository;

    @Autowired
    PlayerServiceImpl playerService;

    @Value("${config.transfer.feeRate}")
    int feeRate;

    @Transactional
    public String fullfillTransfer(long playerId, long teamTo) {
        Optional<Player> player = playerRepository.findById(playerId);
        Optional<Team> targetTeam = teamRepository.findById(teamTo);
        TransferHistory history = new TransferHistory();
        long transferFee = playerService.calculatePlayerValue(playerId);
        long commissionFee = calculateCommissionFee(transferFee);
        history.setTransferDate(new Date());
        history.setPrice(transferFee+commissionFee);
        history.setFromTeamId(player.get().getTeam().getId());
        history.setToTeamId(targetTeam.get().getId());
        transferHistoryRepository.save(history);
        player.get().setTeamId(targetTeam.get().getId());
        playerRepository.save(player.get());
        return "{ \"success\" : true }";
    }

    private long calculateCommissionFee(long transferFee) {
        return transferFee * (feeRate / 100);
    }
}
