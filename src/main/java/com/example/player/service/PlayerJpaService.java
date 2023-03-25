/*
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 * 
 */

// Write your code here
package com.example.player.service;

import com.example.player.repository.*;
import com.example.player.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

@Service

public class PlayerJpaService implements PlayerRepository{

    @Autowired 

    private PlayerJpaRepository playerJPArepository;

    @Override 

    public ArrayList<Player> getAllPlayers(){
        List<Player> allPlayersList = playerJPArepository.findAll();
        ArrayList<Player> allplayers = new ArrayList<>(allPlayersList);

        return allplayers;
    }


    @Override 

    public Player addNewPlayer(Player newPlayer){

        playerJPArepository.save(newPlayer);
        return newPlayer;
    }

    @Override

    public Player getPlayerById(int playerId){

        try{
            Player  playerDetails = playerJPArepository.findById(playerId).get();
            return playerDetails;
        }catch(Exception e){
           throw new  ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override 

    public Player  modifyPlayerById(int playerId, Player newPlayer){

        try{
             Player  playerDetails = playerJPArepository.findById(playerId).get();
             if (newPlayer.getPlayerName()!=null){
                playerDetails.setPlayerName(newPlayer.getPlayerName());
             }
             if (newPlayer.getJerseyNumber()!=0){
                playerDetails.setJerseyNumber(newPlayer.getJerseyNumber());
             }
             if (newPlayer.getRole()!=null){
                playerDetails.setRole(newPlayer.getRole());
             }

             playerJPArepository.save(playerDetails);

             return playerDetails;

        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override

    public void deletePlayerById(int playerId){

        try{
            playerJPArepository.deleteById(playerId);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    

    
}