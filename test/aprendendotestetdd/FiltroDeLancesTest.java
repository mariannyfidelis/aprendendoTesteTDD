package aprendendotestetdd;

import java.util.List;
import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class FiltroDeLancesTest {

    @Test
    public void deveSelecionarLancesEntre1000E3000() {

        Usuario joao = new Usuario("Joao");

        FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(joao, 2000),
                new Lance(joao, 1000),
                new Lance(joao, 3000),
                new Lance(joao, 800)));

        assertEquals(1, resultado.size());
        assertEquals(2000, resultado.get(0).getValor(), 0.00001);
    }

    @Test
    public void deveSelecionarLancesEntre500E700() {
        Usuario joao = new Usuario("Joao");

        FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(joao, 600),
                new Lance(joao, 500),
                new Lance(joao, 700),
                new Lance(joao, 800)));

        assertEquals(1, resultado.size());
        assertEquals(600, resultado.get(0).getValor(), 0.00001);
    }

    @Test
    public void deveSelecionarLancesAcimaDe5000() {
    
        Usuario joao = new Usuario("João");
        FiltroDeLances filtro = new FiltroDeLances();
        
        List<Lance> resultado = filtro.filtra(Arrays.asList(new Lance(joao, 5500),
                                              new Lance(joao, 100), new Lance(joao, 5001)));
    
        assertEquals(2, resultado.size());
        assertEquals(5500, resultado.get(0).getValor(), 0.00001);
        assertEquals(5001, resultado.get(1).getValor(), 0.00001);        
    }
    
    @Test
    public void testSemElemento() {
        
        System.out.println("testSemElemento");
        Usuario joao = new Usuario("João");
        FiltroDeLances filtro = new FiltroDeLances();
        
        List<Lance> resultado = filtro.filtra(Arrays.asList(new Lance(joao, 10),
                                              new Lance(joao, 20), new Lance(joao, 4000)));
        assertTrue(resultado.isEmpty());
    }
    
    @Test
    public void testFiltraSemElemento() {
        System.out.println("filtra");
        List<Lance> lances = null;
        FiltroDeLances instance = new FiltroDeLances();
        
        List<Lance> result = instance.filtra(lances);
        assertNull(result);
        
    }
}
