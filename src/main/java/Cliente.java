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
<<<<<<< HEAD
        return "Cliente" + "\n" +
                "\t Documento: " + Documento + "\n" +
                "\t Nombre: " + Nombre + "\n" +
                "\t Direccion: " + Direccion + "\n" +
                "\t Telefono: " + Telefono + "\n" +
                "\t Codigo postal: " + CodigoPostal +"\n" +
                "\t ";
=======
        return "Cliente ----------- " + '\n' +
                "Documento: " + Documento + '\n' +
                "Nombre: " + Nombre + '\n' +
                "Direccion: " + Direccion + '\n' +
                "Telefono: " + Telefono + '\n' +
                "CodigoPostal: " + CodigoPostal + '\n' ;
>>>>>>> ba688a478a63a3a378a9d89d17a60b3c16d4e538
    }
}
