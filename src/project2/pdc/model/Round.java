/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2.pdc.model;

import java.util.Optional;

/**
 *
 * @author abdulh
 */
public class Round {
    
    private final Player player1, player2;
    private final Card player1Card, player2Card;
    private final Optional<Player> roundWinningPlayer;
    private final Optional<Card> roundWinningCard;
    
    public Round(final Player player1, final Card player1Card, final Player player2, final Card player2Card) {
        this.player1 = player1;
        this.player1Card = player1Card;
        this.player2 = player2;
        this.player2Card = player2Card;
        
        if (player1Card.compareTo(player2Card) > 0) {
            this.player1.addWinningCard(player1Card);
            this.roundWinningPlayer = Optional.of(this.player1);
            this.roundWinningCard = Optional.of(this.player1Card);
        } else if (player1Card.compareTo(player2Card) < 0) {
            this.player2.addWinningCard(player2Card);
            this.roundWinningPlayer = Optional.of(this.player2);
            this.roundWinningCard = Optional.of(this.player2Card);
        } else {
            this.roundWinningPlayer = Optional.empty();
            this.roundWinningCard = Optional.empty();
        }
    }
    
    public Player getPlayer1() {
        return this.player1;
    }
    
    public Player getPlayer2() {
        return this.player2;
    }
    
    public Card getPlayer1Card() {
        return this.player1Card;
    }
    
    public Card getPlayer2Card() {
        return this.player2Card;
    }
    
    public Optional<Player> getRoundWinningPlayer() {
        return this.roundWinningPlayer;
    }
    
    public Optional<Card> getRoundWinningCard() {
        return this.roundWinningCard;
    }
    
}
