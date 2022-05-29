/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2.pdc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author abdulh
 */
public class Battle {
    public static final int TARGET_ROUNDS = 3;
    
    private final Player player, robot;
    private Optional<Player> battleWinningPlayer;
    private final List<Round> rounds;
    private final Date date; // String battleName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
    
    public Battle(final String player1Name) {
        this.player = new Player(player1Name);
        this.robot = new Player("Robot");
        this.rounds = new ArrayList<>();
        this.date = new Date();
    }
    
    public Player getPlayer() {
        return this.player;
    }
    
    public Player getRobot() {
        return this.robot;
    }
    
    public List<Round> getRounds() {
        return this.rounds;
    }
    
    public Round getLatestRound() {
        return this.rounds.get(this.getRoundNumber() - 1);
    }
    
    public int getRoundNumber() {
        return this.rounds.size();
    }
    
    public Date getDate() {
        return this.date;
    }
    
    public void drawCards() {
        this.player.drawCard(Card.getRandomCard());
        this.robot.drawCard(Card.getRandomCard());
    }
    
    public Optional<Player> playRound(final int cardIndex) {
        final Card playerCard = this.player.useCard(cardIndex);
        
        final Random random = new Random();
        final Card robotCard = this.robot.useCard(random.nextInt(Player.HAND_SIZE));
        
        final Round round = new Round(this.player, playerCard, this.robot, robotCard);
        this.rounds.add(round);
        
        if (this.isBattleWinner(round.getRoundWinningPlayer())) {
            this.battleWinningPlayer = round.getRoundWinningPlayer();
        }
        return this.battleWinningPlayer;
    }
    
    private boolean isBattleWinner(Optional<Player> player) {
        if (player.isPresent()) {
            Map<Element, Set<Colour>> winningMap = new HashMap<Element, Set<Colour>>();
            for(Element element : Element.values()) {
                winningMap.put(element, new HashSet<Colour>());
            }
            
            // first win condition: same element, unique colours 
            for (Card card : player.get().getWinningCards()) {
                winningMap.get(card.getElement()).add(card.getColour());
                if(winningMap.get(card.getElement()).size() >= TARGET_ROUNDS) {
                    return true;
                }
            }
            
            // second win condition: every element, unique colours
            for(Colour fireColour : Colour.values()) {
                for(Colour iceColour : Colour.values()) {
                    for(Colour waterColour : Colour.values()) {
                        if(fireColour == iceColour || iceColour == waterColour || waterColour == fireColour) {
                            continue;
                        }
                        if(winningMap.get(Element.FIRE).contains(fireColour)
                                && winningMap.get(Element.ICE).contains(iceColour)
                                && winningMap.get(Element.WATER).contains(waterColour)) {
                            return true;
                        }
                    }
                }
            }
        }
        
        return false;
    }
    
}
