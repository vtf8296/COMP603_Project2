/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import java.util.Random;

/**
 *
 * @author abdulh 
 */
public class Card implements Comparable<Card> {
    public static final int MAX_LEVEL = 12;
    private Element element;
    private int level;
    private Colour colour;
    
    public Card(Element element, Colour colour, int level) {
        this.level = level;
        this.element = element;
        this.colour = colour;
    }
    
    public Element getElement() {
        return this.element;
    }
    
    public int getLevel() {
        return this.level;
    }
    
    public Colour getColour() {
        return this.colour;
    }
    
    // method to compare and check the win conditions for the cards elements and levels.
    @Override
    public int compareTo(Card opponent) {
        int elementComparison = this.getElement().compareWith(opponent.getElement());
        if (elementComparison == 0) {
            if(this.getLevel() > opponent.getLevel()) {
                return 1;
            } else if (this.getLevel() < opponent.getLevel()) {
                return -1;
            } else if (this.getLevel() == opponent.getLevel()) {
                return 0;
            } else {
                throw new IllegalStateException("Card.compareTo failed comparing '" + this + "' with '" + opponent + "'");
            }
        } else if(elementComparison < 0) {
            return -1;
        } else if(elementComparison > 0) {
            return 1;
        } else {
            throw new IllegalStateException("Card.compareTo failed comparing '" + this + "' with '" + opponent + "'");
        }
    }
    
    // method generates random card and returns it
    public static Card getRandomCard() {
        Random random = new Random();
        int randomLevel = random.nextInt(MAX_LEVEL) + 1;
        return new Card(Element.getRandomElement(), Colour.getRandomColour(), randomLevel);
    }

    @Override
    public String toString() {
        return this.colour.name() + " " + this.element.name() + "[" + this.level + "]";
    }
}
