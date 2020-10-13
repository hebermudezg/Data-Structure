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
        return "Cliente ----------- " + '\n' +
                "Documento: " + Documento + '\n' +
                "Nombre: " + Nombre + '\n' +
                "Direccion: " + Direccion + '\n' +
                "Telefono: " + Telefono + '\n' +
                "CodigoPostal: " + CodigoPostal + '\n' ;
    }
}
