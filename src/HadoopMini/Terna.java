package HadoopMini;

public class Terna extends Tupla {

    private Object valor1;
    private Object valor2;

    public Terna(Object clave) {
        super();
    }

    public Terna(Object clave, Object valor1) {
        super(clave, valor1);
        this.valor2 = valor1;
    }

    public Terna(Object clave, Object valor1, Object valor2) {
        super();
        this.valor1 = valor1;
        this.valor2 = valor2;
    }

    public Object getValor1() {
        return valor1;
    }

    public void setValor1(Object valor1) {
        this.valor1 = valor1;
    }

    public Object getValor2() {
        return valor2;
    }

    public void setValor2(Object valor2) {
        this.valor2 = valor2;
    }

    @Override
    public String toString() {
        return "(" + clave + ", " + valor1 + ", " + valor2 + ")";
    }

}

