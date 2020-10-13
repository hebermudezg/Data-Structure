public class ContratoRepartidor {
    public int numerocontrato;
    public int salario;
    public String fechainicio;
    public String fechafin;
    public Repartidor repartidor;

    public ContratoRepartidor(int numerocontrato, int salario, String fechainicio, String fechafin, Repartidor repartidor) {
        this.numerocontrato = numerocontrato;
        this.salario = salario;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.repartidor = repartidor;
    }

    @Override
    public String toString() {
        return "Contrato de repartidor" +"\n"+
                "\t Numerocontrato: " + numerocontrato +"\n"+
                "\t Salario: " + salario +"\n"+
                "\t Fecha de inicio: " + fechainicio + "\n"+
                "\t Fecha de fin: " + fechafin + "\n" +
                "\t Repartidor: " + repartidor.Nombre+"\n"+
                "\t ";
    }
}
