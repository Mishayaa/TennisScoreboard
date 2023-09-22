package org.example.match.services;


import org.example.match.CurrentMatch;
import org.example.match.Match;
import org.example.match.MatchDao;
import org.example.player.Player;
import org.example.player.PlayerDao;

import java.util.Optional;

public class FinishedMatchService {
    private final MatchService ongoingMatchesService = MatchService.getOngoingMatchesService();
    private final MatchDao matchesDao = new MatchDao();
    private final PlayerDao playerDao = new PlayerDao();

    public void persist(CurrentMatch currentMatch) {
        Player firstPlayer = null;
        try {
            firstPlayer = playerDao.create(currentMatch.getFirstPlayer());
        } catch (Exception e) {
            Optional<Player> player = playerDao.getByName(currentMatch.getFirstPlayer().getName());
            if (player.isPresent()) {
                firstPlayer = player.get();
            }
        }

        Player secondPlayer = null;
        try {
            secondPlayer = playerDao.create(currentMatch.getSecondPlayer());
        } catch (Exception e) {
            Optional<Player> player = playerDao.getByName(currentMatch.getSecondPlayer().getName());
            if (player.isPresent()) {
                secondPlayer = player.get();
            }
        }


        Player winner;
        if (currentMatch.getWinner().getName().equalsIgnoreCase(firstPlayer.getName())) {
            winner = firstPlayer;
        } else {
            winner = secondPlayer;
        }

        matchesDao.create(new Match(firstPlayer, secondPlayer, winner));
    }
}