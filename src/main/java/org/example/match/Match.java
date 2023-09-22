package org.example.match;

import jakarta.persistence.*;
import lombok.*;
import org.example.player.Player;

@Entity
@Table(name = "matches")
@Data
public class Match {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "player1", nullable = false)
    private Player player1;
    @ManyToOne
    private Player player2;
    @ManyToOne
    private Player winner;

    public Match(Player player1, Player player2, Player winner) {
        this.player1 = player1;
        this.player2 = player2;
        this.winner = winner;
    }


    public Match() {

    }
}
