package aprendendotestetdd;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class OrdemCrescente {

    @Test
    public static void main() {

        Usuario maria = new Usuario("maria");
        Usuario joao = new Usuario("joão");

        Leilao leilao = new Leilao("PS4");
        List<Integer> listaValoresGerados = new ArrayList<>();

        leilao.propoe(new Lance(maria, 100));
        leilao.propoe(new Lance(joao, 200));
        leilao.propoe(new Lance(maria, 400));
        leilao.propoe(new Lance(joao, 600));
        
        Avaliador leiloeiro = new Avaliador();

        leiloeiro.avalia(leilao);
        
        Assert.assertEquals(600, leiloeiro.getMaiorLance(), 0.0001);
        Assert.assertEquals(100, leiloeiro.getMenorLance(), 0.0001);
        
    }
}
