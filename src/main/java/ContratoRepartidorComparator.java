
import java.util.Comparator;

public class ContratoRepartidorComparator implements Comparator<ContratoRepartidor> {
    public String criterio;
    public String ordendir;

    public ContratoRepartidorComparator(String criterio, String ordendir) {
        this.criterio = criterio;
        this.ordendir = ordendir;
    }

    @Override
    public int compare(ContratoRepartidor o1, ContratoRepartidor o2) {
        int resul = 0;
        if (criterio.equals("1") && ordendir.equals("1")) {  // codigo sucursal
            resul = o1.numerocontrato - o2.numerocontrato;     // acendente

        } else if (criterio.equals("1") && ordendir.equals("2")) {// codigo sucursal
            resul = o2.numerocontrato - o1.numerocontrato;     // descendente

        } else if (criterio.equals("2") && ordendir.equals("1")){// cant empleados
            resul = o1.salario - o2.salario;     // acendente
        } else if (criterio.equals("2") && ordendir.equals("2")) { //cant empleados
            resul = o2.salario - o1.salario;     // descendente
        }
        return resul;
    }
}