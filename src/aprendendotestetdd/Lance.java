package aprendendotestetdd;

import java.util.Objects;

public class Lance {

    private Usuario user;
    private double valor;

    public Lance(Usuario user, double valor){
        this.user = user;
        this.valor = valor;
        
        if(valor <= 0) 
            throw new IllegalArgumentException();
        
    }
    
    public double getValor() {
        return valor;
    }

    public Usuario getUser() {
        return user;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.user);
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.valor) ^ (Double.doubleToLongBits(this.valor) >>> 32));
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
        final Lance other = (Lance) obj;
        if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(other.valor)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        return true;
    }
    
}
