public class Cliente {
    public String Nombre;
    public String Direccion;
    public int telefono;
    public int CodigoPostal;

    public Cliente(String nombre, String direccion, int telefono, int codigoPostal) {
        Nombre = nombre;
        Direccion = direccion;
        this.telefono = telefono;
        CodigoPostal = codigoPostal;
    }
    @Override
    public String toString() {
        return "Cliente " + "\n" +
                "\t Nombre: " + Nombre + "\n" +
                "\t Direccion: " + Direccion + "\n" +
                "\t Telefono: " + telefono + "\n" +
                "\t Codigo postal: " + CodigoPostal + "\n" +
                "\t ";
    }
}
