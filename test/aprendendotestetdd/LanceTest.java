package aprendendotestetdd;

import org.junit.Test;

public class LanceTest {

    @Test(expected = IllegalArgumentException.class)
    public void deveRecusarLancesComValorDeZero() {
        Lance lance = new Lance(new Usuario("John Doe"), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveRecusarLancesComValorNegativo() {
        Lance lance = new Lance(new Usuario("John Doe"), -10);
    }

}
