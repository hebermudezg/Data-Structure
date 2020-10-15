import java.util.Comparator;

public class ClienteComparator implements Comparator<Cliente> {
    public String criterio;
    public String ordendir;

    public ClienteComparator(String criterio, String ordendir) {
        this.criterio = criterio;
        this.ordendir = ordendir;
    }

    @Override
    public int compare(Cliente o1, Cliente o2) {
        int resul = 0;

        if (criterio.equals("1") && ordendir.equals("1")) {  // codigo sucursal
            resul = o1.Documento - o2.Documento;     // acendente

        } else if (criterio.equals("1") && ordendir.equals("2")) {// codigo sucursal
            resul = o2.Documento - o1.Documento;     // descendente

        } else if (criterio.equals("2") && ordendir.equals("1")) {// cant empleados
            resul = o1.Telefono - o2.Telefono;     // acendente
        } else if (criterio.equals("2") && ordendir.equals("2")) { //cant empleados
            resul = o2.Telefono - o1.Telefono;     // descendente

        } else if (criterio.equals("3") && ordendir.equals("1")) {// cant empleados
            resul = o1.CodigoPostal - o2.CodigoPostal;     // acendente
        } else if (criterio.equals("3") && ordendir.equals("2")) { //cant empleados
            resul = o2.CodigoPostal - o1.CodigoPostal;     // descendente
        }
        return resul;
    }
}
