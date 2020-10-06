public class Empresa {
    public int Nit;
    public int RazonSocial;
    public String Presidente;

    public Empresa(int nit, int razonSocial, String presidente) {
        Nit = nit;
        RazonSocial = razonSocial;
        Presidente = presidente;
    }
    @Override
    public String toString() {
        return "Empresa " + "\n" +
                "\t Nit: " + Nit + "\n" +
                "\t Razon social: " + RazonSocial + "\n" +
                "\t Presidente: " + Presidente + "\n" +
                "\t ";
    }
}
