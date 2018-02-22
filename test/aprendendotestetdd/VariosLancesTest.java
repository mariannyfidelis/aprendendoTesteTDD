package aprendendotestetdd;

import org.junit.Test;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class VariosLancesTest {

    @Test
    public void main() {

        Usuario maria = new Usuario("maria");
        Usuario joao = new Usuario("joão");

        Leilao leilao = new Leilao("PS4");
        List<Integer> listaValoresGerados = new ArrayList<>();
        
        int valorGerado = new Random().nextInt(1000);
        
        listaValoresGerados.add(valorGerado);
        leilao.propoe(new Lance(maria,valorGerado));
        
        valorGerado = new Random().nextInt(1000);
        
        listaValoresGerados.add(valorGerado);
        leilao.propoe(new Lance(joao, valorGerado));
        
        valorGerado = new Random().nextInt(1000);
        
        listaValoresGerados.add(valorGerado);
        leilao.propoe(new Lance(maria, valorGerado));
        
        valorGerado = new Random().nextInt(1000);
        
        listaValoresGerados.add(valorGerado);
        leilao.propoe(new Lance(joao, valorGerado));

        Avaliador leiloeiro = new Avaliador();

        leiloeiro.avalia(leilao);

        //Assert.assertEquals(leilao.getLances().stream().mapToDouble(l -> l.getValor()).sorted().max().getAsDouble(), leiloeiro.getMaiorLance(), 0.0001);
        //Assert.assertEquals(leilao.getLances().stream().mapToDouble(l -> l.getValor()).sorted().min().getAsDouble(), leiloeiro.getMenorLance(), 0.0001);
    }

}
