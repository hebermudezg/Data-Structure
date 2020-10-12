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
        return "ContratoRepartidor{" +
                "numerocontrato=" + numerocontrato +
                ", salario=" + salario +
                ", fechainicio='" + fechainicio + '\'' +
                ", fechafin='" + fechafin + '\'' +
                ", repartidor=" + repartidor +
                '}';
    }
}
