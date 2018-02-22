package aprendendotestetdd;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PalindromoTest {
    
    public PalindromoTest() {
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
    public void testEhPalindromo() {
        System.out.println("ehPalindromo");
        String frase = "Socorram-me subi no onibus em Marrocos";
        Palindromo instance = new Palindromo();
        boolean expResult = true;
        boolean result = instance.ehPalindromo(frase);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }
    
}
