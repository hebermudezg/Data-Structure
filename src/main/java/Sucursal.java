import java.util.LinkedList;

public class Sucursal {
    public int Codigo;
    public String Ciudad;
    public String Direccion;
    public int Cant_Empleados;
    public Empresa Empresa;

    public Sucursal(int codigo, String ciudad, String direccion, int cant_Empleados, Empresa empresa) {
        this.Codigo = codigo;
        this.Ciudad = ciudad;
        this.Direccion = direccion;
        this.Cant_Empleados = cant_Empleados;
        this.Empresa = empresa;



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
