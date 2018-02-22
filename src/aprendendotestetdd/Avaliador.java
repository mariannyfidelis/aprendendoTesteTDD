package aprendendotestetdd;

import java.util.List;
import java.util.Comparator;
import java.util.Collections;
import java.util.Objects;

public class Avaliador {

    private double maiorDeTodos = Double.NEGATIVE_INFINITY;
    private double menorDeTodos = Double.POSITIVE_INFINITY;
    private Usuario usuariovencedor, usuarioperdedor;
    private List<Lance> maiores;

    public void avalia(Leilao leilao) {

        if (leilao.getLances().size() == 0) {
            throw new RuntimeException("Não é possível avaliar um leilão sem lances");
        }

        for (Lance lance : leilao.getLances()) {
            if (lance.getValor() > maiorDeTodos) {
                maiorDeTodos = lance.getValor();
                usuariovencedor = lance.getUser();
            }
            if (lance.getValor() < menorDeTodos) {
                menorDeTodos = lance.getValor();
                usuarioperdedor = lance.getUser();
            }
        }

        pegaOs3MaioresLances(leilao);
    }

    public List<Lance> getTresMaiores() {

        Collections.sort(maiores, new Comparator<Lance>() {
            @Override
            public int compare(Lance l1, Lance l2) {
                if (l1.getValor() > l2.getValor()) {
                    return -1;
                } else if (l1.getValor() < l2.getValor()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        maiores = maiores.subList(0, maiores.size() > 3 ? 3 : maiores.size());

        return maiores;
    }

    public double getMaiorLance() {
        return maiorDeTodos;
    }

    public double getMenorLance() {
        return menorDeTodos;
    }

    public double getValorMedioLances(Leilao leilao) {

        List<Lance> lances = leilao.getLances();

        return lances.stream().mapToDouble(leilao1 -> leilao1.getValor()).average().getAsDouble();
    }

    public Usuario getUsuarioVencedor() {
        return usuariovencedor;
    }

    public Usuario getUsuarioPerdedor() {
        return usuarioperdedor;
    }

    private void pegaOs3MaioresLances(Leilao leilao) {
        maiores = leilao.getLances();

        Collections.sort(maiores, new Comparator<Lance>() {
            @Override
            public int compare(Lance l1, Lance l2) {
                if (l1.getValor() > l2.getValor()) {
                    return -1;
                } else if (l1.getValor() < l2.getValor()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        maiores = maiores.subList(0, maiores.size() > 3 ? 3 : maiores.size());

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.maiorDeTodos) ^ (Double.doubleToLongBits(this.maiorDeTodos) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.menorDeTodos) ^ (Double.doubleToLongBits(this.menorDeTodos) >>> 32));
        hash = 29 * hash + Objects.hashCode(this.usuariovencedor);
        hash = 29 * hash + Objects.hashCode(this.usuarioperdedor);
        hash = 29 * hash + Objects.hashCode(this.maiores);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Avaliador other = (Avaliador) obj;
        if (Double.doubleToLongBits(this.maiorDeTodos) != Double.doubleToLongBits(other.maiorDeTodos)) {
            return false;
        }
        if (Double.doubleToLongBits(this.menorDeTodos) != Double.doubleToLongBits(other.menorDeTodos)) {
            return false;
        }
        
        if (!Objects.equals(this.maiores, other.maiores)) {
            return false;
        }
        return true;
    }
    
    
}
