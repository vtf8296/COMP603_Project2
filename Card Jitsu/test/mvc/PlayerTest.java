/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.hasItem;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class PlayerTest {
    
    @Test
    public void testPickupCard() {
        System.out.println("pickupCard");
        Card addedCard = new Card(Element.FIRE, Colour.CYAN, 10);
        List<Card> hand = new ArrayList<Card>();
        hand.add(addedCard);
        assertThat(hand, hasItem(addedCard));
    }
}
