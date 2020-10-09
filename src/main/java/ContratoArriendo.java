public class ContratoArriendo {
    public int numContrato;
    public int fechadeInicio;
    public int dechadeFin;
    public double canon;
    public Sucursal sucursal;

    public ContratoArriendo(int numContrato, int fechadeInicio, int dechadeFin, double canon, Sucursal sucursal) {
        this.numContrato = numContrato;
        this.fechadeInicio = fechadeInicio;
        this.dechadeFin = dechadeFin;
        this.canon = canon;
        this.sucursal = sucursal;
    }

    @Override
    public String toString() {
        return "ContratoArriendo{" +
                "numContrato=" + numContrato +
                ", fechadeInicio=" + fechadeInicio +
                ", dechadeFin=" + dechadeFin +
                ", canon=" + canon +
                ", sucursal=" + sucursal +
                '}';
    }
}
