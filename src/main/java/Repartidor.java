public class Repartidor {
    public int Cedula;
    public String Nombre;
    public int Edad;
    public int Num_Celular;
    public String Tipo_Licencia;


    public Repartidor(int cedula, String nombre, int edad, int num_Celular, String tipo_Licencia) {
        Cedula = cedula;
        Nombre = nombre;
        Edad = edad;
        Num_Celular = num_Celular;
        Tipo_Licencia = tipo_Licencia;
    }

    @Override
    public String toString() {
        return "Repartidor" +"\n" +
                "\t Cedula: " + Cedula + "\n" +
                "\t Nombre: " + Nombre + "\n" +
                "\t Edad: " + Edad + "\n" +
                "\t Numero de celular: " + Num_Celular + "\n" +
                "\t Tipo de licencia: " + Tipo_Licencia + "\n" +
                "\t ";
    }
}
