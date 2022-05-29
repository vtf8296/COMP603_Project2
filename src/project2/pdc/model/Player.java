/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2.pdc.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abdulh
 */
public class Player {
    public static final int HAND_SIZE = 5;
    private final String name;
    private final List<Card> hand = new ArrayList<>();
    private final List<Card> winningCards = new ArrayList<>();
    
    public Player(String name) {
        this.name = name;
        this.populateHand();
    }
    
    // method to add 5 new cards to the hand
    public void populateHand() {
        this.hand.clear();
        for (int i = 0; i < HAND_SIZE; i++) {
            drawCard(Card.getRandomCard());
        }
    }
    
    public String getName() {
        return this.name;
    }
    
    public List<Card> getHand() {
        return this.hand;
    }
    
    // method removes card from hand
    public Card useCard(int index) {
        return this.hand.remove(index);
    }
    
    // method adds card to hand
    public void drawCard(Card card) {
        this.hand.add(card);
    }
    
    public List<Card> getWinningCards() {
        return this.winningCards;
    }
    
    // method adds the winning card to the winning card list
    public void addWinningCard(Card winningCard) {
        this.winningCards.add(winningCard);
    }
    
    public void resetWinningCards() {
        this.winningCards.clear();
    }
    
    @Override
    public String toString() {
        String playerString = this.name + " WINNING CARDS: " + this.winningCards;
        playerString = playerString + "\nHAND: ";
        for (int i = 0; i < this.hand.size(); i++) {
            playerString = playerString + " [" + (i + 1) + "]" + this.hand.get(i);
        }
        return playerString;
    }
}
