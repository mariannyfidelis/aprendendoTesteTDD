package aprendendotestetdd;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class OrdemCrescenteTest {
    
    public OrdemCrescenteTest() {
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
    public void testMain() {
        System.out.println("Ordem Crescente Testando .......");
        String[] args = null;
        OrdemCrescente.main();
        //fail("The test case is a prototype.");
    }
    
}
