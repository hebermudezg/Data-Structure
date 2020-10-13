public class Empresa {
    public String Nit;
    public String RazonSocial;
    public String Presidente;


    public Empresa(String nit, String razonSocial, String presidente) {
        this.Nit = nit;
        this.RazonSocial = razonSocial;
        this.Presidente = presidente;
    }

    @Override
    public String toString() {
        return "Empresa" + "\n"+
                "\t Nit:" + Nit + "\n" +
                "\t Razon social:" + RazonSocial +"\n" +
                "\t Presidente:" + Presidente + "\n"+
                "\t ";
    }



}
