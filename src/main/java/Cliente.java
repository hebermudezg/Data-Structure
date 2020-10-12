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
        return "Cliente{" +
                "Documento=" + Documento +
                ", Nombre='" + Nombre + '\'' +
                ", Direccion='" + Direccion + '\'' +
                ", Telefono=" + Telefono +
                ", CodigoPostal=" + CodigoPostal +
                '}';
    }
}
