public class ContratoArriendo {
    public int Numcontrato;
    public int FechaDeInicio;
    public int FechaDeFin;
    public String Canon;

    public ContratoArriendo(int numcontrato, int fechaDeInicio, int fechaDeFin, String canon) {
        Numcontrato = numcontrato;
        FechaDeInicio = fechaDeInicio;
        FechaDeFin = fechaDeFin;
        Canon = canon;
    }
    @Override
    public String toString() {
        return "Contrato de arriendo " + "\n" +
                "\t Numero de contrato: " + Numcontrato + "\n" +
                "\t Fecha de inicio: " + FechaDeInicio + "\n" +
                "\t Fecha de fin: " + FechaDeFin + "\n" +
                "\t ";
    }
}
