public class ContratoArriendo {
    public int numContrato;
    public String fechadeInicio;
    public String FechadeFin;
    public int canon;
    public Sucursal sucursal;

    public ContratoArriendo(int numContrato, String fechadeInicio, String dechadeFin, int canon, Sucursal sucursal) {
        this.numContrato = numContrato;
        this.fechadeInicio = fechadeInicio;
        this.FechadeFin = dechadeFin;
        this.canon = canon;
        this.sucursal = sucursal;
    }

    @Override
    public String toString() {
        return "Contrato de a rriendo" +"\n"+
                "\t Numero de contrato:" + numContrato +"\n"+
                "\t Fecha de inicio:" + fechadeInicio +"\n"+
                "\t Fecha de fin: " + FechadeFin +"\n"+
                "\t Canon: " + canon +"\n"+
                "\t Sucursal: " + sucursal.codigoScursal + "\n"+
                "\t ";
    }
}
