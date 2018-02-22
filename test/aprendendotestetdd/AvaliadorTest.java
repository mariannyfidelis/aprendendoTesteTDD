package aprendendotestetdd;

import org.junit.Test;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;

public class AvaliadorTest {

    private Avaliador leiloeiro;
    private Usuario joao;
    private Usuario jose;
    private Usuario maria;

    @Before
    public void setUp() {
        this.leiloeiro = new Avaliador();
        System.out.println("inicializando teste!");
    }

    @Before
    public void criaAvaliador() {

        //this.leiloeiro = new Avaliador();
        joao = new Usuario("João");
        jose = new Usuario("José");
        maria = new Usuario("Maria");
    }

    @Test(expected = RuntimeException.class)
    public void naoDeveAvaliarLeiloesSemNenhumLanceDado() {
        Leilao leilao = new CriadorDeLeilao()
                .para("Playstation 3 Novo")
                .constroi();

        leiloeiro.avalia(leilao);

        // como fazer o assert?
    }

    @Test
    public void deveEntenderLancesEmOrdemCrescente() {

        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao, 250.0));
        leilao.propoe(new Lance(jose, 300.0));
        leilao.propoe(new Lance(maria, 400.0));

        // parte 2: acao
        leiloeiro.avalia(leilao);

        // parte 3: validacao
        assertEquals(400.0, leiloeiro.getMaiorLance(), 0.00001);
        assertEquals(250.0, leiloeiro.getMenorLance(), 0.00001);
        assertThat(leiloeiro.getMenorLance(), equalTo(250.0));
        assertThat(leiloeiro.getMaiorLance(), equalTo(400.0));
    }

    @Test
    public void deveEntenderLeilaoComApenasUmLance() {

        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao, 1000.0));

        leiloeiro.avalia(leilao);

        assertEquals(1000.0, leiloeiro.getMaiorLance(), 0.00001);
        assertEquals(1000.0, leiloeiro.getMenorLance(), 0.00001);
    }

    @Test
    public void deveEncontrarTresMaioresLances() {

        Leilao leilao = new CriadorDeLeilao().para("Playstation 4")
                .lance(joao, 100.0)
                .lance(maria, 200.0)
                .lance(joao, 300.0)
                .lance(maria, 400.0)
                .constroi();

        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();

        assertEquals(3, maiores.size());
        assertEquals(400, maiores.get(0).getValor(), 0.00001);
        assertEquals(300, maiores.get(1).getValor(), 0.00001);
        assertEquals(200, maiores.get(2).getValor(), 0.00001);
        
        assertThat(maiores, hasItems(
                new Lance(maria, 400), 
                new Lance(joao, 300),
                new Lance(maria, 200)
        ));
        
    }

    @Test
    public void main() {

        Leilao leilao = new Leilao("Playstation 4");
        leilao.propoe(new Lance(maria, 500.0));
        leilao.propoe(new Lance(joao, 300.0));
        leilao.propoe(new Lance(jose, 400.0));

        leiloeiro.avalia(leilao);

        double maiorEsperado = 500.0;
        double menorEsperado = 300.0;
        String usuarioVencedorr = "Maria";
        String usuarioPerdedorr = "João";

        Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
        Assert.assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
        Assert.assertEquals(usuarioVencedorr, leiloeiro.getUsuarioVencedor().getUsuario());
        Assert.assertEquals(usuarioPerdedorr, leiloeiro.getUsuarioPerdedor().getUsuario());

        Assert.assertEquals(400, leiloeiro.getValorMedioLances(leilao), 0.00001);
    }

    @After
    public void finaliza() {
        System.out.println("finalizando os testes .....\n");
    }

    @BeforeClass
    public static void testandoBeforeClass() {
        System.out.println("before class .... \n");
    }

    @AfterClass
    public static void testandoAfterClass() {
        System.out.println("after class");
    }
}
