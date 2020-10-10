public class Especialidad {
    public int codigoEspecialidad;
    public String encargado;
    public String enfoque;
    public int lineaAtencion;
    public Sucursal sucursal;

    public Especialidad(int codigo, String encargado, String enfoque, int lineaAtencion, Sucursal sucursal) {
        this.codigoEspecialidad = codigo;
        this.encargado = encargado;
        this.enfoque = enfoque;
        this.lineaAtencion = lineaAtencion;
        this.sucursal = sucursal;
    }

    @Override
    public String toString() {
        return "Especialidad" +"\n"+
                "\t Codigo: " + codigoEspecialidad +"\n"+
                "\t Encargado: " + encargado + "\n" +
                "\t Enfoque: " + enfoque + "\n"+
                "\t Linea de atencion: " + lineaAtencion +"\n"+
                "\t Sucursal: " + sucursal.codigoScursal +"\n"+
                "\t ";
    }
}
