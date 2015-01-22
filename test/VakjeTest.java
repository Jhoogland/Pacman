/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Graphics;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author denzyl
 */
public class VakjeTest {
    
    public VakjeTest() {
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
     * Test of setY method, of class Vakje.
     */
    @Test
    public void testSetY() {
        System.out.println("setY");
        int y = 0;
        Vakje instance = new Vakje(null);
        instance.setY(y);
        assertEquals(0,instance.getY());
    }

    /**
     * Test of setX method, of class Vakje.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");
        int x = 0;
        Vakje instance = new Vakje(null);
        instance.setX(x);
   
        Assert.assertEquals(instance.getX(),0);
    }

    /**
     * Test of getX method, of class Vakje.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Vakje instance = new Vakje(null);
        int expResult = 0;
        instance.setX(expResult);
        int result = instance.getX();
        assertEquals(expResult, result);
    
    }

    /**
     * Test of getY method, of class Vakje.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Vakje instance = new Vakje(null);
        int expResult = 0;
        instance.setY(expResult);
        int result = instance.getY();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getWidth method, of class Vakje.
     */
    @Test
    public void testGetWidth() {
        System.out.println("getWidth");
        Vakje instance = new Vakje(null);
        int expResult = 50;
        
        int result = instance.getWidth();
        assertEquals(expResult, result);
     
    }

    /**
     * Test of getHeight method, of class Vakje.
     */
    @Test
    public void testGetHeight() {
        System.out.println("getHeight");
        Vakje instance = new Vakje(null);
        int expResult = 50;
        int result = instance.getHeight();
        assertEquals(expResult, result);
 
    }

    /**
     * Test of isPacman method, of class Vakje.
     */
    @Test
    public void testIsPacman() {
        System.out.println("isPacman");
        Vakje instance = new Vakje(null);
        Pacman pacman = new Pacman();
        pacman.startVakje(instance);
        boolean expResult = true;
        boolean result = instance.isPacman();
        assertEquals(expResult, result);
     }

    /**
     * Test of setPacman method, of class Vakje.
     */
    @Test
    public void testSetPacman() {
        System.out.println("setPacman");
        Pacman pacman = new Pacman();
        Vakje instance = new Vakje(null);
        instance.setPacman(pacman);
        assertEquals(true,instance.isPacman());
    }

    /**
     * Test of setSpookje method, of class Vakje.
     */
    @Test
    public void testSetSpookje() {
        System.out.println("setSpookje");
        Spookje spookje = new Spookje();
        Vakje instance = new Vakje(null);
        instance.setSpookje(spookje);
        Assert.assertEquals(instance.bevat,spookje);
    }

    /**
     * Test of isSpookje method, of class Vakje.
     */
    @Test
    public void testIsSpookje() {
        System.out.println("isSpookje");
        Vakje instance = new Vakje(null);
        instance.setSpookje(new Spookje());
        Boolean expResult = true;
        Boolean result = instance.isSpookje();
        assertEquals(expResult, result);
     
    }

    /**
     * Test of isMuur method, of class Vakje.
     */
    @Test
    public void testIsMuur() {
        System.out.println("isMuur");
        Vakje instance = new Vakje(new Muur());
        boolean expResult = true;
        boolean result = instance.isMuur();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of isNormaalBolletje method, of class Vakje.
     */
    @Test
    public void testIsNormaalBolletje() {
        System.out.println("isNormaalBolletje");
        Vakje instance = new Vakje(new NormaalBolletje());
        boolean expResult = true;
        boolean result = instance.isNormaalBolletje();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of isSuperBolletje method, of class Vakje.
     */
    @Test
    public void testIsSuperBolletje() {
        System.out.println("isSuperBolletje");
        Vakje instance = new Vakje(new SuperBolletje());
        boolean expResult = true;
        boolean result = instance.isSuperBolletje();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of isKers method, of class Vakje.
     */
    @Test
    public void testIsKers() {
        System.out.println("isKers");
        Vakje instance = new Vakje(null);
        instance.kers();
        boolean expResult =true;
        boolean result = instance.isKers();
        assertEquals(expResult, result);
    
    }

    /**
     * Test of getKers method, of class Vakje.
     */
    @Test
    public void testGetKers() {
        System.out.println("getKers");
        Vakje instance = new Vakje(null);
        Kers expResult = null;
         
        assertEquals(expResult, instance.getKers());
        // TODO review the generated test code and remove the default call to fail.
 
    }

   
    /**
     * Test of kersVerwijderen method, of class Vakje.
     */
    @Test
    public void testKersVerwijderen() {
        System.out.println("kersVerwijderen");
        Vakje instance = new Vakje(null);
        instance.kers();
        instance.kersVerwijderen();
        assertEquals(null,instance.bevat);
    }

    /**
     * Test of bolletjeVerwijderen method, of class Vakje.
     */
    @Test
    public void testBolletjeVerwijderen() {
        System.out.println("bolletjeVerwijderen");
        Vakje instance = new Vakje(null);
        instance.setPacman(new Pacman());
        instance.setBevat(new Bolletje());
        instance.bolletjeVerwijderen();
        assertEquals(null,instance.pacman);
    }

    /**
     * Test of setBevat method, of class Vakje.
     */
    @Test
    public void testSetBevat() {
        System.out.println("setBevat");
        Muur object = new Muur();
        Vakje instance = new Vakje(object);
        instance.setBevat(object);
        assertEquals(object,instance.bevat);
    }

    /**
     * Test of kers method, of class Vakje.
     */
    @Test
    public void testKers() {
        System.out.println("kers");
        Vakje instance = new Vakje(null);
        instance.kers();
        assertEquals(null,new Kers());
    }
    
}
