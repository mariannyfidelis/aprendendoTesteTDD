package aprendendotestetdd;

import java.util.ArrayList;
import java.util.List;

public class FiltroDeLances {

    public List<Lance> filtra(List<Lance> lances) {

        ArrayList<Lance> resultado = new ArrayList<>();

        try {
            for (Lance lance : lances) {
                if (lance.getValor() > 1000 && lance.getValor() < 3000) {
                    resultado.add(lance);
                } else if (lance.getValor() > 500 && lance.getValor() < 700) {
                    resultado.add(lance);
                } else if (lance.getValor() > 5000) {
                    resultado.add(lance);
                }
            }
        } catch (Exception n) {
            resultado = null;
            return resultado;
        }
        return resultado;
    }
}
