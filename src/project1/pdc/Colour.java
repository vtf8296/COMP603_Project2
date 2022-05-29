/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1.pdc;

import java.util.Random;

/**
 *
 * @author abdulh
 */
public enum Colour {
    RED("\033[0;31m"),
    GREEN("\033[0;32m"),
    YELLOW("\033[0;33m"),
    BLUE("\033[0;34m"),
    PURPLE("\033[0;35m"),
    CYAN("\033[0;36m");
    
    // Constant for colour reset in order to fill in other colours for future texts.
    public static final String RESET = "\033[0m";
    public final String consoleColour;
    
    private Colour(String consoleColour) {
        this.consoleColour = consoleColour;
    }
    
    // appends the colour codes to the message
    public String appendColourCode(String message) {
        return this.consoleColour + message + RESET;
    }
    
    public static Colour getRandomColour() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
