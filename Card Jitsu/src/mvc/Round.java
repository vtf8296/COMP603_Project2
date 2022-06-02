/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import java.util.Optional;

/**
 *
 * @author abdulh
 */
public class Round {
    private final Optional<Player> winner;
    private final Card playerSelectedCard;
    private final Card robotSelectedCard;
    
    public Round(final Card playerSelectedCard, final Card robotSelectedCard, final Optional<Player> winner) {
        this.playerSelectedCard = playerSelectedCard;
        this.robotSelectedCard = robotSelectedCard;
        this.winner = winner;
    }
    
    public Card getPlayerSelectedCard() {
        return this.playerSelectedCard;
    }
    
    public Card getRobotSelectedCard() {
        return this.robotSelectedCard;
    }
    
    public Optional<Player> getWinner() {
        return this.winner;
    }
    
    public boolean isTied() {
        return !this.winner.isPresent();
    }
    
}
