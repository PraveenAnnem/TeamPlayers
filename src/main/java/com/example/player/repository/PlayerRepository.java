// Write your code here

package com.example.player.repository;

import com.example.player.model.*;
import java.util.*;


public interface PlayerRepository{

    ArrayList<Player> getAllPlayers();

    Player addNewPlayer(Player newPlayer);

    Player getPlayerById(int playerId);

    Player modifyPlayerById(int playerId, Player newPlayer);

    void deletePlayerById(int playerId);
}