/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2.pdc;

import java.util.Optional;
import java.util.Random;

/**
 *
 * @author abdulh
 */
public class Round {
    private ConsoleIO consoleIo;
    private Player player;
    private Player robot;
    
    public Round(ConsoleIO consoleIo, Player player, Player robot) {
        this.consoleIo = consoleIo;
        this.player = player;
        this.robot = robot;
    }
    
    // method starts the round.
    public Optional<Player> play(int roundNumber) {
        this.consoleIo.printRoundStart(roundNumber, this.robot);
        Card playerCard = this.player.playCard(this.consoleIo.selectCard(this.player));
        
        //robot plays card
        Random rand = new Random();
        int pickRobotCard = rand.nextInt(Player.HAND_SIZE);
        Card robotCard = this.robot.playCard(pickRobotCard);
        
        // Pick up cards
        this.player.pickupCard(Card.getRandomCard());
        this.robot.pickupCard(Card.getRandomCard());
        
        // Determine winner
        Optional<Player> winner = Optional.empty();
        if (playerCard.compareTo(robotCard) > 0) {
            this.player.addWinningCard(playerCard);
            winner = Optional.of(this.player);
        } else if (playerCard.compareTo(robotCard) < 0) {
            this.robot.addWinningCard(robotCard);
            winner = Optional.of(this.robot);
        }
        
        this.consoleIo.printRoundWinner(this.player.getName(), this.robot.getName(), playerCard, robotCard, winner);
        return winner;
    }
}
