/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1.pdc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 *
 * @author abdulh
 */
public class Battle {
    public static final int ROUNDS_NEEDED = 3;
    
    private ConsoleIO consoleIo;
    private Player player1;
    private Player player2;
    private List<Round> rounds;
    
    public void Battle(String playerName1, String playerName2) {
        String battleName = "battle-" +  new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
        this.consoleIo = new ConsoleIO(battleName);
        this.player1 = new Player(playerName1);
        this.player2 = new Player(playerName2);
        this.rounds = new ArrayList<Round>();
    }
    
    // method to start game.
    public void play() {
        Optional<Player> roundWinner = Optional.empty();
        do {
            Round round = new Round(this.consoleIo, this.player1, this.player2);
            this.rounds.add(round);
            roundWinner = round.play(this.rounds.size());
        } while(!isBattleWinner(roundWinner));
    }
    
    // method to check if player is game winner.
    private boolean isBattleWinner(Optional<Player> player) {
        if (player.isPresent()) {
            Map<Element, Set<Colour>> winningMap = new HashMap<Element, Set<Colour>>();
            for(Element element : Element.values()) {
                winningMap.put(element, new HashSet<Colour>());
            }
            
            // first win condition: same element, unique colours 
            for (Card card : player.get().getWinningCards()) {
                winningMap.get(card.getElement()).add(card.getColour());
                if(winningMap.get(card.getElement()).size() >= ROUNDS_NEEDED) {
                    this.consoleIo.printBattleWinnerSameElement(player.get().getName(), winningMap, card.getElement());
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
                            this.consoleIo.printBattleWinnerEveryElement(player.get().getName(), fireColour, iceColour, waterColour);
                            return true;
                        }
                    }
                }
            }
        }
        
        return false;
    }
}
