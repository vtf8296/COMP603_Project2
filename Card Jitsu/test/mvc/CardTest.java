/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.hasItem;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class CardTest {
    
    /**
     * Test of compareTo method, of class Card.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Element element = null;
        Colour colour = null;
        Card cardFire = new Card(element.FIRE, colour.GREEN, 12);
        Card cardFireWeak = new Card(element.FIRE, colour.GREEN, 11);
        Card cardWater = new Card(element.WATER, colour.GREEN, 12);
        Card cardWaterWeak = new Card(element.WATER, colour.GREEN, 11);
        Card cardIce = new Card(element.ICE, colour.GREEN, 12);
        int compareSameElementSameLevel = cardFire.compareTo(cardFire);
        int compareSameElementDiffLevel = cardFire.compareTo(cardFireWeak);
        int compareDiffElementSameLevel = cardWater.compareTo(cardIce);
        int compareDiffElementDiffLevel = cardWaterWeak.compareTo(cardFire);
        assertEquals(compareSameElementSameLevel, 0);
        assertEquals(compareSameElementDiffLevel, 1);
        assertEquals(compareDiffElementSameLevel, -1);
        assertEquals(compareDiffElementDiffLevel, 1);
    }

    /**
     * Test of getRandomCard method, of class Card.
     */
    @Test
    public void testGetRandomCard() {
        System.out.println("getRandomCard");
        Card card = Card.getRandomCard();
        List<Card> possibleCard = Arrays.asList(card);
        assertThat(possibleCard, hasItem(card));
    }
}
