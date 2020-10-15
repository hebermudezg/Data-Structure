import java.util.Comparator;

public class SucursalComparator implements Comparator<Sucursal> {
    public String criterio;
    public String ordendir;

    public SucursalComparator(String criterio, String ordendir) {
        this.criterio = criterio;
        this.ordendir = ordendir;
    }

    @Override
    public int compare(Sucursal o1, Sucursal o2) {
        int resul = 0;
        if (criterio.equals("1") && ordendir.equals("1")) {  // codigo sucursal
            resul = o1.codigoScursal - o2.codigoScursal;     // acendente

        } else if (criterio.equals("1") && ordendir.equals("2")) {// codigo sucursal
            resul = o2.codigoScursal - o1.codigoScursal;     // descendente

        } else if (criterio.equals("2") && ordendir.equals("1")){// cant empleados
            resul = o1.cantEmpleados - o2.cantEmpleados;     // acendente
        } else if (criterio.equals("2") && ordendir.equals("2")) { //cant empleados
            resul = o2.cantEmpleados - o1.cantEmpleados;     // descendente

        }
        return resul;
    }
}