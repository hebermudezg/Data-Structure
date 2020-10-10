public class ContratoArriendo {
    public int numContrato;
    public String fechadeInicio;
    public String dechadeFin;
    public int canon;
    public Sucursal sucursal;

    public ContratoArriendo(int numContrato, String fechadeInicio, String dechadeFin, int canon, Sucursal sucursal) {
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
                ", sucursal=" + sucursal.codigoScursal + // no necesito mostrar todo el objeto solo el id
                '}';
    }
}
