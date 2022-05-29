/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2.pdc.model;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author abdulh
 */
public enum Colour {
    BLUE(Color.CYAN),
    GREEN(Color.GREEN),
    MAGENTA(Color.MAGENTA),
    ORANGE(Color.ORANGE),
    PINK(Color.PINK),
    RED(Color.RED);
    
    public final Color value;
    
    private Colour(Color value) {
        this.value = value;
    }
    
    public static Colour getRandomColour() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
