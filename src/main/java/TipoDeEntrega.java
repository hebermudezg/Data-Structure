public class TipoDeEntrega {
    public int Codigo;
    public int Tiempo_Estimado;
    public String MedioDeTransporte;

    public TipoDeEntrega(int codigo, int tiempo_Estimado, String medioDeTransporte) {
        Codigo = codigo;
        Tiempo_Estimado = tiempo_Estimado;
        MedioDeTransporte = medioDeTransporte;
    }
    @Override
    public String toString() {
        return "Tipo de entrega " + "\n" +
                "\t Codigo: " + Codigo + "\n" +
                "\t Tiempo estimado: " + Tiempo_Estimado + "\n" +
                "\t Medio de transporte: " + MedioDeTransporte + "\n" +
                "\t ";
    }
}
