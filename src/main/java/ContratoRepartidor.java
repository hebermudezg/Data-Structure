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
<<<<<<< HEAD
        return "Contrato de repartidor" +"\n"+
                "\t Numerocontrato: " + numerocontrato +"\n"+
                "\t Salario: " + salario +"\n"+
                "\t Fecha de inicio: " + fechainicio + "\n"+
                "\t Fecha de fin: " + fechafin + "\n" +
                "\t Repartidor: " + repartidor.Nombre+"\n"+
                "\t ";
=======
        return "ContratoRepartidor{" +
                "numerocontrato=" + numerocontrato +
                ", salario=" + salario +
                ", fechainicio='" + fechainicio + '\'' +
                ", fechafin='" + fechafin + '\'' +
                ", repartidor=" + repartidor +
                '}';
>>>>>>> ba688a478a63a3a378a9d89d17a60b3c16d4e538
    }
}
