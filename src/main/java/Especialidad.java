public class Especialidad {
    public int codigo;
    public String encargado;
    public String enfoque;
    public int lineaAtencion;
    public Sucursal sucursal;

    public Especialidad(int codigo, String encargado, String enfoque, int lineaAtencion, Sucursal sucursal) {
        this.codigo = codigo;
        this.encargado = encargado;
        this.enfoque = enfoque;
        this.lineaAtencion = lineaAtencion;
        this.sucursal = sucursal;
    }

    @Override
    public String toString() {
        return "Especialidad{" +
                "codigo=" + codigo +
                ", encargado='" + encargado + '\'' +
                ", enfoque='" + enfoque + '\'' +
                ", lineaAtencion=" + lineaAtencion +
                ", sucursal=" + sucursal +
                '}';
    }
}
