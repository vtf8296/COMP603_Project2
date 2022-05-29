/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1.pdc;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.hasItem;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class ColourTest {

    /**
     * Test of appendColourCode method, of class Colour.
     */
    @Test
    public void appendColourCodeReturnsAppendedMessage() {
        Colour colour = Colour.BLUE;
        String message = "hello";
        String expResult = colour.consoleColour + message + Colour.RESET;
        String result = colour.appendColourCode(message);
        assertEquals(expResult, result);
    }

    /**
     * Test of getRandomColour method, of class Colour.
     */
    @Test
    public void getRandomColourReturnsCorrectColour() {
        List<Colour> possibleColours = Arrays.asList(Colour.values());
        Colour actualColour = Colour.getRandomColour();
        assertThat(possibleColours, hasItem(actualColour));
    }
    
}
