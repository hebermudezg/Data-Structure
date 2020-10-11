public class Entrega {
    public int codEntrega;
    public double peso;
    public int dimenciones;
    public boolean fragil;
    public double costo;
    public String estadoEntrega;
    public Especialidad especialidad; // tiene que venir de una especialidad
    public TipoDeEntrega tipoDeEntrega; // tiene que tener un tipo de entrega
    public Cliente cliente; //  tiene que tener un cliente
    public Repartidor repartidor; // tiene que tener un repartidor

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
        return "Entrega" +"\n"+
                "\t Codigo entrega: " + codEntrega +"\n"+
                "\t Peso: " + peso +"\n"+
                "\t Dimenciones: " + dimenciones +"\n"+
                "\t Fragil: " + fragil +"\n"+
                "\t Costo: " + costo +"\n"+
                "\t Estado de entrega: '" + estadoEntrega + "\n" +
                "\t Especialidad: " + especialidad.codigoEspecialidad +"\n"+
                "\t Tipo de entrega: " + tipoDeEntrega.Codigo+"\n"+
                "\t Cliente: " + cliente.Documento +"\n"+
                "\t Repartidor: " + repartidor.Cedula +"\n"+
                "\t ";
    }
}
