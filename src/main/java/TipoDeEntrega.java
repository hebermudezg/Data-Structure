public class TipoDeEntrega {
    public int Codigo;
    public int Tiempo_Estimado;
    public String MedioDeTransporte;

    public TipoDeEntrega(int codigo, int tiempo_Estimado, String medioDeTransporte) {
        Codigo = codigo;
        Tiempo_Estimado = tiempo_Estimado;
        MedioDeTransporte = medioDeTransporte;
    }
}
