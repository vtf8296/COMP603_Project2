/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2.pdc.model;

import java.util.Random;

/**
 *
 * @author abdulh
 */
public enum Element {
    FIRE,
    ICE,
    WATER;
    
    // method randomly retrieves an element
    public static Element getRandomElement() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
    
    // method to compare and check the win conditions for the elements.
    public int compareWith(Element opponent) {
        if (this == opponent) {
            return 0;
        } else if ((this == FIRE && opponent == WATER) || (this == WATER && opponent == ICE) || (this == ICE && opponent == FIRE)) {
            return -1;
        } else if ((this == FIRE && opponent == ICE) || (this == WATER && opponent == FIRE) || (this == ICE && opponent == WATER)) {
            return 1;
        } else {
            throw new IllegalStateException("Element.compareWith failed comparing '" + this + "' with '" + opponent + "'");
        }
    }
}
