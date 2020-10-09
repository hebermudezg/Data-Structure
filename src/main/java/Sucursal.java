
public class Sucursal {
    public int codigo;
    public String ciudad;
    public String direccion;
    public int cantEmpleados;
    public Empresa empresa; // Una surucrsal pertenece a una sola empresa

    public Sucursal(int codigo, String ciudad, String direccion, int cantEmpleados, Empresa empresa) {
        this.codigo = codigo;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.cantEmpleados = cantEmpleados;
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Sucursal{" +
                "codigo=" + codigo +
                ", ciudad='" + ciudad + '\'' +
                ", direccion='" + direccion + '\'' +
                ", cantEmpleados=" + cantEmpleados +
                ", empresa=" + empresa +
                '}';
    }
}
