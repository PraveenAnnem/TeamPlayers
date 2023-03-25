/*
 * 
 * You can use the following import statemets
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * import org.springframework.beans.factory.annotation.Autowired;
 * 
 */

// Write your code here


package com.example.player.controller;

import com.example.player.model.*;
import com.example.player.service.*;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;


@RestController

public class PlayerController{

    @Autowired

    private PlayerJpaService  playerService;


    @GetMapping("/players")
    public ArrayList<Player> getAllPlayers(){
        return playerService.getAllPlayers();
    }

    @PostMapping("/players")

    public Player addNewPlayer(@RequestBody Player newPlayer){

        return playerService.addNewPlayer(newPlayer);
    }


    @GetMapping("/players/{playerId}")

    public Player getPlayerById(@PathVariable("playerId")int playerId){
        return playerService.getPlayerById(playerId);
    }

    @PutMapping("/players/{playerId}")

    public Player modifyPlayerById(@PathVariable("playerId")int playerId,@RequestBody Player newPlayer){
        return playerService.modifyPlayerById(playerId, newPlayer);
    }


    @DeleteMapping("/players{playerId}")

    public void deletePlayerById(int playerId){

         playerService.deletePlayerById(playerId);
    }
}