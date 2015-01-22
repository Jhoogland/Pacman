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
public class PacmanTest {
    
    public PacmanTest() {
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
     * Test of startVakje method, of class Pacman.
     */
    @Test
    public void testStartVakje() {
        System.out.println("startVakje");
        Pacman instance = new Pacman();
        Vakje vakje = new Vakje(null);
        instance.startVakje(vakje);
        instance.dood();
        Assert.assertEquals(vakje,instance.vakje);
    }

    /**
     * Test of gaNaarVakje method, of class Pacman.
     */
    @Test
    public void testGaNaarVakje() {
        System.out.println("gaNaarVakje");
              
        Pacman instance = new Pacman();
        Vakje vakje = new Vakje(null);
        instance.startVakje(vakje);
        instance.gaNaarVakje(vakje);
        instance.dood();
        Assert.assertEquals(vakje,instance.vakje);
    }

    /**
     * Test of dood method, of class Pacman.
     */
    @Test
    public void testDood() {
        System.out.println("dood");
        Pacman instance = new Pacman();
        Vakje vakje = new Vakje(null);
        instance.startVakje(vakje);
        instance.dood();
        Assert.assertEquals(instance.isLevend,true);
    }
    
}
