package org.bullbet.controller;

import io.swagger.annotations.Api;
import org.bullbet.entity.Player;
import org.bullbet.service.impl.TransferServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Transfer operations Api documentation")
public class TransferController {

    @Autowired
    TransferServiceImpl transferService;


    @PostMapping("/transfer")
    public Player transfer(@RequestParam long playerId, @RequestParam long teamTo) {
        return transferService.fullfillTransfer(playerId,teamTo);
    }

}
