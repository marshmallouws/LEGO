/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionlayertest;

import functionlayer.Calculator;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Annika
 */
public class CalculatorTest {
    
    public CalculatorTest() {
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
    
    @Test
    public void testCalculate() {
        int height = 7;
        int length = 8;
        int width = 5;
        
        Calculator c = new Calculator();
        HashMap<String, HashMap<String, Integer>> h = c.calculate(height, length, width);
        
        assertEquals(12, (int)h.get("side3").get("2x2"));
        assertEquals(2, (int)h.get("side3").get("2x4"));
        
        
        assertEquals(6, (int)h.get("side1").get("2x4"));
        assertEquals(8, (int)h.get("side1").get("2x2"));
        assertEquals(1, (int)h.get("side1").get("window"));
        
        assertEquals(7, (int)h.get("side2").get("2x4"));
        assertEquals(7, (int)h.get("side2").get("2x1"));
        
        assertEquals(7, (int)h.get("side4").get("2x4"));
        assertEquals(7, (int)h.get("side4").get("2x1"));
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
