package aprendendotestetdd;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

class Leilao {

    private String nome;
    private List<Lance> lances;

    public Leilao(String nome) {
        this.nome = nome;
        lances = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Lance> getLances() {
        return lances;
    }

    public void propoe(Lance lance) {

        if (lances.isEmpty() || podeDarLance(lance)) {
            
            lances.add(lance);
        }
    }

    private boolean podeDarLance(Lance lance) {

        return !ultimoLanceDado().getUser().equals(lance.getUser()) && quantidadeLanceUser(lance.getUser()) < 5;
    }

    private int quantidadeLanceUser(Usuario user) {
        int total = 0;
        for (Lance l : lances) {
            if (l.getUser().equals(user)) {
                total++;
            }
        }
        return total;
    }

    private Lance ultimoLanceDado() {
        return lances.get(lances.size() - 1);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + Objects.hashCode(this.lances);
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
        final Leilao other = (Leilao) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.lances, other.lances)) {
            return false;
        }
        return true;
    }
     
    public void dobraLance(Usuario usuario){
        int i = 1;
        
        while( i <= lances.size()){
            Lance lance = lances.get(lances.size()- i);           
            if(lance.getUser().equals(usuario)){
                this.propoe(new Lance(usuario, lance.getValor()*2));
                return;
            }else{
                i++;    
            }
        }        
    }

}
