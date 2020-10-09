public class Entrega {
    public int codEntrega;
    public double peso;
    public int dimenciones;
    public boolean fragil;
    public double costo;
    public String estadoEntrega;
    public Especialidad especialidad;
    public TipoDeEntrega tipoDeEntrega;
    public Cliente cliente;
    public Repartidor repartidor;

    public Entrega(int codEntrega, double peso, int dimenciones, boolean fragil, double costo,
                   String estadoEntrega, Especialidad especialidad, TipoDeEntrega tipoDeEntrega,
                   Cliente cliente, Repartidor repartidor) {
        this.codEntrega = codEntrega;
        this.peso = peso;
        this.dimenciones = dimenciones;
        this.fragil = fragil;
        this.costo = costo;
        this.estadoEntrega = estadoEntrega;
        this.especialidad = especialidad;
        this.tipoDeEntrega = tipoDeEntrega;
        this.cliente = cliente;
        this.repartidor = repartidor;
    }

    @Override
    public String toString() {
        return "Entrega{" +
                "codEntrega=" + codEntrega +
                ", peso=" + peso +
                ", dimenciones=" + dimenciones +
                ", fragil=" + fragil +
                ", costo=" + costo +
                ", estadoEntrega='" + estadoEntrega + '\'' +
                ", especialidad=" + especialidad +
                ", tipoDeEntrega=" + tipoDeEntrega +
                ", cliente=" + cliente +
                ", repartidor=" + repartidor +
                '}';
    }
}
