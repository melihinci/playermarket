package org.bullbet.service;

import org.bullbet.entity.Player;

public interface TransferService {

    public Player fullfillTransfer(long playerId, long teamTo);
}
