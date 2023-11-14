package HadoopMini;

public class Tupla {
    Object clave;
    private Object valor;
    
    public Tupla(){
        this.clave = null;
        this.valor = null;
    }
    
    public Tupla (Object clave, Object valor) {
        this.clave = clave;
        this.valor = valor;
    }

    public Object getClave() {
        return clave;
    }

    public void setClave(Object clave) {
        this.clave = clave;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }
    
    
    @Override
    public String toString() {
        return "(" + this.getClave() + " , " + this.getValor() + ")";
    }
    
}
