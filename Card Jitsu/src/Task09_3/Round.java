/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task09_3;

import java.util.Optional;
import java.util.Random;

/**
 *
 * @author abdulh
 */
public class Round {
    private Player player;
    private Player robot;
    private Optional<Player> winner;
    private Card playerSelectedCard;
    private Card robotSelectedCard;
    
    public Round(Player player) {
        this.player = player;
        this.robot = new Player("Robot");
    }
    
    public Player getPlayer() {
        return this.player;
    }
    
    public Player getRobot() {
        return this.robot;
    }
    
    public Optional<Player> getWinner() {
        return this.winner;
    }
    
    public Card getPlayerSelectedCard() {
        return this.playerSelectedCard;
    }
    
    public Card getRobotSelectedCard() {
        return this.robotSelectedCard;
    }
    
    // method starts the round.
    public Optional<Player> play(int index) {
        this.playerSelectedCard = this.player.playCard(index);
        
        //robot plays card
        Random rand = new Random();
        this.robotSelectedCard = this.robot.playCard(rand.nextInt(Player.HAND_SIZE));
        
        // Pick up cards
        this.player.pickupCard(Card.getRandomCard());
        this.robot.pickupCard(Card.getRandomCard());
        
        // Determine winner
        this.winner = Optional.empty();
        if (this.playerSelectedCard.compareTo(this.robotSelectedCard) > 0) {
            this.player.addWinningCard(this.playerSelectedCard);
            this.winner = Optional.of(this.player);
        } else if (this.playerSelectedCard.compareTo(this.robotSelectedCard) < 0) {
            this.robot.addWinningCard(this.robotSelectedCard);
            this.winner = Optional.of(this.robot);
        }
        
        return this.winner;
    }
}
