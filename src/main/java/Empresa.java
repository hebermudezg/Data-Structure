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
<<<<<<< HEAD
        return "Empresa" + "\n"+
                "\t Nit:" + Nit + "\n" +
                "\t Razon social:" + RazonSocial +"\n" +
                "\t Presidente:" + Presidente + "\n"+
                "\t ";
=======
        return "Empresa. --------------------" + '\n' +
                "Nit='" + Nit + '\n' +
                "RazonSocial='" + RazonSocial + '\n' +
                "Presidente='" + Presidente + '\n';
>>>>>>> ba688a478a63a3a378a9d89d17a60b3c16d4e538
    }



}
