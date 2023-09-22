package org.example.match.services;

import org.example.match.CurrentMatch;
import org.example.player.Player;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class MatchService {
    private static final MatchService INSTANCE = new MatchService();
    private final Map<UUID, CurrentMatch> currentMatches = new ConcurrentHashMap<>();

    private MatchService() {
    }

    public static MatchService getOngoingMatchesService() {
        return INSTANCE;
    }


    public void createNewMatch(UUID uuid, Player firstPlayer, Player secondPlayer, int setsInMatch) {
        CurrentMatch currentMatch = new CurrentMatch(uuid, firstPlayer, secondPlayer, setsInMatch);
        currentMatches.put(uuid, currentMatch);
    }



    public void remove(UUID uuid) {
        currentMatches.remove(uuid);
    }

    public CurrentMatch getCurrentMatch(UUID uuid) {
        return currentMatches.get(uuid);
    }

}
