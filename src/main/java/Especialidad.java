public class Especialidad {
    public int Codigo;
    public String Encargado;
    public String Enfoque;
    public int Linea_Atencion;

    public Especialidad(int codigo, String encargado, String enfoque, int linea_Atencion) {
        Codigo = codigo;
        Encargado = encargado;
        Enfoque = enfoque;
        Linea_Atencion = linea_Atencion;
    }
    @Override
    public String toString() {
        return "Entrega " + "\n" +
                "\t Codigo: " + Codigo + "\n" +
                "\t Encargado: " + Encargado + "\n" +
                "\t Enfoque: " + Enfoque + "\n" +
                "\t Linea de atencion: " + Linea_Atencion + "\n" +
                "\t ";
    }
}
