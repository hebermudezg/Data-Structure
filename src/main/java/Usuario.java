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
    public String toString() {
        return "Hola"+Nombre+"\n"+
                "Bienvenido al sistema Empresa de entregas"+"\n";

    }
}
