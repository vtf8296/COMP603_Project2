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
public class ElementTest {
    /**
     * Test of getRandomElement method, of class Element.
     */
    @Test
    public void testGetRandomElement() {
        System.out.println("getRandomElement");
        List<Element> possibleElements = Arrays.asList(Element.values());
        Element actualElement = Element.getRandomElement();
        assertThat(possibleElements, hasItem(actualElement));
    }

    /**
     * Test of compareWith method, of class Element.
     */
    @Test
    public void testCompareWith() {
        System.out.println("compareWith");
        Element element = null;
        Element opponentElement = null;
        int compareFireFire = element.FIRE.compareWith(opponentElement.FIRE);
        int compareWaterWater = element.WATER.compareWith(opponentElement.WATER);
        int compareIceIce = element.ICE.compareWith(opponentElement.ICE);
        int compareFireWater = element.FIRE.compareWith(opponentElement.WATER);
        int compareFireIce = element.FIRE.compareWith(opponentElement.ICE);
        int compareWaterFire = element.WATER.compareWith(opponentElement.FIRE);
        int compareWaterIce = element.WATER.compareWith(opponentElement.ICE);
        int compareIceFire = element.ICE.compareWith(opponentElement.FIRE);
        int compareIceWater = element.ICE.compareWith(opponentElement.WATER);
        assertEquals(compareFireFire, 0);
        assertEquals(compareWaterWater, 0);
        assertEquals(compareIceIce, 0);
        assertEquals(compareFireWater, -1);
        assertEquals(compareFireIce, 1);
        assertEquals(compareWaterFire, 1);
        assertEquals(compareWaterIce, -1);
        assertEquals(compareIceFire, -1);
        assertEquals(compareIceWater, 1);
    }
    
}
