public class Usuario {
    public int Documento;
    public String Nombre;
    public String Apellido;
    public String Correo;
    public String Contraseña;

    public Usuario(int documento, String nombre, String apellido, String correo, String contraseña) {
        Documento = documento;
        Nombre = nombre;
        Apellido = apellido;
        Correo = correo;
        Contraseña = contraseña;
    }
    @Override
    public String toString() {
        return "Usuario " + "\n" +
                "\t Documento: " + Documento + "\n" +
                "\t Nombre: " + Nombre + "\n" +
                "\t Apellido: " + Apellido + "\n" +
                "\t Correo: " + Correo + "\n" +
                "\t Contraseña: " + Contraseña + "\n" +
                "\t ";
    }
}
