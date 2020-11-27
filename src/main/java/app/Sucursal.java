package app;

public class Sucursal {
    public int codigoScursal;
    public String ciudad;
    public String direccion;
    public int cantEmpleados;
    // public Empresa empresa; Una sucursarl tiene que tener una empresa

    public Sucursal(int codigoScursal, String ciudad, String direccion, int cantEmpleados, Empresa empresa) {
        this.codigoScursal = codigoScursal;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.cantEmpleados = cantEmpleados;
       // this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Sucursal" +"\n"+
                "\t Codigo: " + codigoScursal +"\n"+
                "\t Ciudad: " + ciudad + "\n" +
                "\t Direccion: " + direccion + "\n" +
                "\t Cantidad de empleados: " + cantEmpleados +"\n"+
               // "\t Empresa: " + empresa.Nit +"\n"+
                "\t ";
    }
}
