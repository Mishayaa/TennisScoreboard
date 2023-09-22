package org.example.match.services;

import org.example.player.Player;

import java.util.UUID;

public class MatchService {
    public void createNewMatch(UUID uuid, Player firstPlayer, Player secondPlayer, int setsInMatch) {
        CurrentMatch currentMatch = new CurrentMatch(uuid, firstPlayer, secondPlayer, setsInMatch);
        currentMatches.put(uuid, currentMatch);
    }
}
