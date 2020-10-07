public class Sucursal {
    public int Codigo;
    public String Ciudad;
    public String Direccion;
    public int Cant_Empleados;

    public Sucursal(int codigo, String ciudad, String direccion, int cant_Empleados) {
        Codigo = codigo;
        Ciudad = ciudad;
        Direccion = direccion;
        Cant_Empleados = cant_Empleados;
    }
    @Override
    public String toString() {
        return "Sucursal " + "\n" +
                "\t Codigo: " + Codigo + "\n" +
                "\t Ciudad: " + Ciudad + "\n" +
                "\t Direccion: " + Direccion + "\n" +
                "\t Cantidad de empleados: " + Cant_Empleados + "\n" +
                "\t ";
    }
}
