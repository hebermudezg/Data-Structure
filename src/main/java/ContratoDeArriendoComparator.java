
import java.util.Comparator;

public class ContratoDeArriendoComparator implements Comparator<ContratoArriendo> {
    public String criterio;
    public String ordendir;

    public ContratoDeArriendoComparator(String criterio, String ordendir) {
        this.criterio = criterio;
        this.ordendir = ordendir;
    }

    @Override
    public int compare(ContratoArriendo o1, ContratoArriendo o2) {
        int resul = 0;
        if (criterio.equals("1") && ordendir.equals("1")) {  // codigo sucursal
            resul = o1.numContrato - o2.numContrato;     // acendente

        } else if (criterio.equals("1") && ordendir.equals("2")) {// codigo sucursal
            resul = o2.numContrato - o1.numContrato;     // descendente

        } else if (criterio.equals("2") && ordendir.equals("1")){// cant empleados
            resul = o1.canon - o2.canon;     // acendente
        } else if (criterio.equals("2") && ordendir.equals("2")) { //cant empleados
            resul = o2.canon - o1.canon;     // descendente

        }
        return resul;
    }
}