public class Cliente {
    public int Documento;
    public String Nombre;
    public String Direccion;
    public int Telefono;
    public int CodigoPostal;

    public Cliente(int documento, String nombre, String direccion, int telefono, int codigoPostal) {
        Documento = documento;
        Nombre = nombre;
        Direccion = direccion;
        Telefono = telefono;
        CodigoPostal = codigoPostal;
    }
    @Override
    public String toString() {
        return "Cliente " + "\n" +
                "\t Nombre: " + Nombre + "\n" +
                "\t Direccion: " + Direccion + "\n" +
                "\t Telefono: " + Telefono + "\n" +
                "\t Codigo postal: " + CodigoPostal + "\n" +
                "\t ";
    }
}
