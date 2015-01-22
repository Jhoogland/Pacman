/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author denzyl
 */
public class SpookjeTest {
    
    public SpookjeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of isStop method, of class Spookje.
     */
    @Test
    public void testIsStop() {
        System.out.println("isStop");
        Spookje instance = new Spookje();
        boolean expResult = true;
        boolean result = instance.isStop();

        Assert.assertEquals(expResult, result);
    }

    /**
     * Test of randomBewegen method, of class Spookje.
     */
    @Test
    public void testRandomBewegen() {
        System.out.println("randomBewegen");
        Spookje instance = new Spookje();
        instance.setSpeelVeld(new Speelveld());
        instance.beweeg(Richting.SOUTH);
        instance.vakje = new Vakje(null);
        instance.randomBewegen();
        boolean expected = true;
        boolean result = instance.lopend;
        Assert.assertEquals(expected,result);
    }
    
}
