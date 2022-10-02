package org.bullbet.service.impl;

import org.bullbet.entity.Player;
import org.bullbet.repository.PlayerRepository;
import org.bullbet.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component(value = "playerService")
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public long calculatePlayerValue(long playerId) {
        Optional<Player> player = playerRepository.findById(playerId);
        long value = 0;
        if (player.isPresent()) {
            Date beginDate = new Date(Integer.valueOf(player.get().getLicenseDate().substring(0, 3)), Integer.valueOf(player.get().getLicenseDate().substring(4, 6)), 1);
            Date today = new Date();
            long expInMonth = (today.getTime() - beginDate.getTime()) / (1000 * 60 * 60 * 24 * 30);
            value = (expInMonth * 100000) / player.get().getAge();
        }
        return value;
    }

    @Override
    public String updatePlayer(Long id, Player player) {
        Player playerOld = playerRepository.findById(id).get();
        playerOld.setTeamId(player.getTeamId());
        playerOld.setAge(player.getAge());
        playerOld.setName(player.getName());
        playerOld.setLicenseDate(player.getLicenseDate());
        playerRepository.save(playerOld);
        return "{ \"success\" : true }";
    }

    @Override
    public String updatePlayer(Player player) {
        playerRepository.save(player);
        return "{ \"success\" : true }";
    }

    @Override
    public Player getPlayer(Long id) {
        return playerRepository.findById(id).get();
    }

    @Override
    public String removePlayer(Long id) {
        playerRepository.deleteById(id);
        return "{ \"success\" : true }";
    }
}
