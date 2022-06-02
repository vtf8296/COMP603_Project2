/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abdulh
 */
public class Player {
    public static final int HAND_SIZE = 5;
    private String name;
    private List<Card> hand;
    private List<Card> winningCards;
    
    public Player(String name) {
        this.name = name;
        populateHand();
        this.winningCards = new ArrayList<Card>();
    }
    
    // method to add 5 cards to the hand
    private void populateHand() {
        this.hand = new ArrayList<Card>();
        for (int i = 0; i < HAND_SIZE; i++) {
            pickupCard(Card.getRandomCard());
        }
    }
    
    public String getName() {
        return this.name;
    }
    
    public List<Card> getHand() {
        return this.hand;
    }
    
    // method removes card from hand
    public Card playCard(int index) {
        return this.hand.remove(index);
    }
    
    // method adds card to hand
    public void pickupCard(Card card) {
        this.hand.add(card);
    }
    
    public List<Card> getWinningCards() {
        return this.winningCards;
    }
    
    // method adds the winning card to a winning card list
    public void addWinningCard(Card winningCard) {
        this.winningCards.add(winningCard);
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
