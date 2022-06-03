/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author abdulh
 */
public enum Colour {
    CYAN(Color.CYAN),
    GREEN(Color.GREEN),
    MAGENTA(Color.MAGENTA),
    ORANGE(Color.ORANGE),
    PINK(Color.PINK);
    
    public Color value;
    
    private Colour(Color value) {
        this.value = value;
    }
    
    //Get random colour for cards.
    public static Colour getRandomColour() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
