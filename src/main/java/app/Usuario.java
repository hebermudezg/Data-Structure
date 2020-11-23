package app;

public class Usuario {
    public int documento;
    public String nombre;
    public String apellido;
    public String correo;
    public String contraseña;

    public Usuario(int documento, String nombre, String apellido, String correo, String contraseña) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contraseña = contraseña;
    }
    @Override
    public String toString() {
        return "Usuario " + "\n" +
                "\t Documento: " + documento + "\n" +
                "\t Nombre: " + nombre + "\n" +
                "\t Apellido: " + apellido + "\n" +
                "\t Correo: " + correo + "\n" +
                "\t Contraseña: " + contraseña + "\n" +
                "\t ";
    }
}
