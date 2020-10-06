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
    @Override
    public String toString() {
        return "Entrega " + "\n" +
                "\t Codigo de entrega: " + Cod_Entrega + "\n" +
                "\t Peso: " + Peso + "\n" +
                "\t Dimenciones: " + Dimenciones + "\n" +
                "\t Fragil: " + Fragil + "\n" +
                "\t Costo: " + Costo + "\n" +
                "\t Estado de entrega: " + Estado_Entrega + "\n" +
                "\t ";
    }
}
