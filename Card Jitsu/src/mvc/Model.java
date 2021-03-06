
package mvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Optional;
import java.util.Random;
import java.util.Set;


public class Model extends Observable {
    
    public final static int ROUNDS_NEEDED = 3;

    public Database db;
    public Data data;
    public String username; // To store the user name for later use.
    
    /**
     * Step 2:
     * Initialize the instance of Database in the constructor,
     * and build the connection between the program and the database.
     * 
     * Go to Database.java for Step 3.
     */
    public Model() {
        this.db = new Database();
        this.db.dbsetup();
    }
    
    /**
     * Step 6:
     * 
     * @param username
     * @param password 
     */
    //Method used to check the name and password for user profile.
    public void checkName(String username, String password) {
        this.username = username;
        this.data = this.db.checkName(username, password);
        this.setChanged();
        this.notifyObservers(this.data); 
    }

    public void quitGame() {
        this.data.quitFlag = true; // Mark quitFlag as false.
        this.setChanged();
        this.notifyObservers(this.data);
    }
    
    public void playRound(int index) {
        this.data.battleStartedFlag = true;
        
        // Play cards
        Card playerSelectedCard = this.data.player.playCard(index);
        Random rand = new Random();
        Card robotSelectedCard = this.data.robot.playCard(rand.nextInt(Player.HAND_SIZE));
        
        // Pick up cards
        this.data.player.pickupCard(Card.getRandomCard());
        this.data.robot.pickupCard(Card.getRandomCard());
        
        // Determine round winner
        Optional<Player> winner = Optional.empty();
        if (playerSelectedCard.compareTo(robotSelectedCard) > 0) {
            this.data.player.addWinningCard(playerSelectedCard);
            winner = Optional.of(this.data.player);
        } else if (playerSelectedCard.compareTo(robotSelectedCard) < 0) {
            this.data.robot.addWinningCard(robotSelectedCard);
            winner = Optional.of(this.data.robot);
        }
        
        // Add round information to data
        this.data.rounds.add(new Round(playerSelectedCard, robotSelectedCard, winner));
        
        this.data.battleWonFlag = isBattleWinner(winner);
        
        this.setChanged();
        this.notifyObservers(this.data);
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
                if(winningMap.get(card.getElement()).size() >= ROUNDS_NEEDED) {
                    printBattleWinnerSameElement(player.get().getName(), winningMap, card.getElement());
                    if(player.get().equals(data.player)) {
                        this.data.wins++;
                        this.data.winningTitle = "You win! Wins: " + this.data.wins + " Losses: " + this.data.losses;
                    } else if(player.get().equals(data.robot)) {
                        this.data.losses++;
                        this.data.winningTitle = "You lose! Wins: " + this.data.wins + " Losses: " + this.data.losses;
                    }
                    this.db.saveStats(this.data.wins, this.data.losses, this.username);
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
                            printBattleWinnerEveryElement(player.get().getName(), fireColour, iceColour, waterColour);
                            if(player.get().equals(data.player)) {
                                this.data.wins++;
                                this.data.winningTitle = "You win! Wins: " + this.data.wins + " Losses: " + this.data.losses;
                            } else if(player.get().equals(data.robot)) {
                                this.data.losses++;
                                this.data.winningTitle = "You lose! Wins: " + this.data.wins + " Losses: " + this.data.losses;
                            }
                            this.db.saveStats(this.data.wins, this.data.losses, this.username);
                            return true;
                        }
                    }
                }
            }
        }
        
        return false;
    }
    
    // method shows that the player won the game with the condition of winning with the same element and unique colours
    public void printBattleWinnerSameElement(String winnerName, Map<Element, Set<Colour>> winningMap, Element winningElement) {
        this.data.winningSet = winnerName + " wins with ";
        List<String> winningList = new ArrayList<>();
        for(Colour colour : winningMap.get(winningElement)) {
            winningList.add(colour.name()+" "+winningElement.name());
        }
        this.data.winningSet = this.data.winningSet + winningList;
    }
    
    // method shows that the player won the game with the condition of winning with all elements and unique colours
    public void printBattleWinnerEveryElement(String winnerName, Colour fireColour, Colour iceColour, Colour waterColour) {
        this.data.winningSet = winnerName + " wins with ";
        List<String> winningList = new ArrayList<>();
        winningList.add(fireColour.name()+" "+Element.FIRE.name());
        winningList.add(iceColour.name()+" "+Element.ICE.name());
        winningList.add(waterColour.name()+" "+Element.WATER.name());
        this.data.winningSet = this.data.winningSet + winningList;
    }
}
