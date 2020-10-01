public class Entrega {
    public int Cod_Entrega;
    public int Peso;
    public int Dimenciones;
    public boolean Fragil;
    public double Costo;
    public String Estado_Entrega;

    public Entrega(int cod_Entrega, int peso, int dimenciones, boolean fragil, double costo, String estado_Entrega) {
        Cod_Entrega = cod_Entrega;
        Peso = peso;
        Dimenciones = dimenciones;
        Fragil = fragil;
        Costo = costo;
        Estado_Entrega = estado_Entrega;
    }
}
