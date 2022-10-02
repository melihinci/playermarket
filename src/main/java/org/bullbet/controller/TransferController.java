package org.bullbet.controller;

import org.bullbet.service.impl.TransferServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class TransferController {

    @Autowired
    TransferServiceImpl transferService;


    @PostMapping("/transfer")
    public String transfer(@RequestParam long playerId, @RequestParam long teamTo) {
        return transferService.fullfillTransfer(playerId,teamTo);
    }

}
