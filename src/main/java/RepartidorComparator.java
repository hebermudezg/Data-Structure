
import java.util.Comparator;

public class RepartidorComparator implements Comparator<Repartidor> {
    public String criterio;
    public String ordendir;

    public RepartidorComparator(String criterio, String ordendir) {
        this.criterio = criterio;
        this.ordendir = ordendir;
    }

    @Override
    public int compare(Repartidor o1, Repartidor o2) {
        int resul = 0;
        if (criterio.equals("1") && ordendir.equals("1")) {  // codigo sucursal
            resul = o1.Cedula - o2.Cedula;     // acendente
        } else if (criterio.equals("1") && ordendir.equals("2")) {// codigo sucursal
            resul = o2.Cedula - o1.Cedula;     // descendente

        } else if (criterio.equals("2") && ordendir.equals("1")){// cant empleados
            resul = o1.Edad - o2.Edad;     // acendente
        } else if (criterio.equals("2") && ordendir.equals("2")) { //cant empleados
            resul = o2.Edad - o1.Edad;     // descendente
        }
        return resul;
    }
}