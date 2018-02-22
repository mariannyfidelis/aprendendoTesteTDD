package aprendendotestetdd;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MatematicaMalucaTest {

    public MatematicaMalucaTest() {
    }

    @Test
    public void testContaMalucaMaiorCasoIf() {
        System.out.println("contaMaluca caso if maior ...");
        int numero = 31;
        MatematicaMaluca instance = new MatematicaMaluca();
        int expResult = 124;
        int result = instance.contaMaluca(numero);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testContaMalucaCasoElseIfMenor() {
        System.out.println("contaMaluca caso else if testando ......");
        int numero = 11;
        MatematicaMaluca instance = new MatematicaMaluca();
        int expResult = 33;
        int result = instance.contaMaluca(numero);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testContaMalucaCasoElse() {
        System.out.println("contaMaluca caso Else .....");
        int numero = 0;
        MatematicaMaluca instance = new MatematicaMaluca();
        int expResult = 0;
        int result = instance.contaMaluca(numero);
        assertEquals(expResult, result);
    }
}
