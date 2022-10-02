package org.bullbet.service;

import org.bullbet.entity.Player;


public interface PlayerService {

    public long calculatePlayerValue(long playerId);

    String updatePlayer(Long id, Player player);

    String updatePlayer(Player player);

    Player getPlayer(Long id);

    String removePlayer(Long id);
}
