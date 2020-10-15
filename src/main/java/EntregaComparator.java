import java.util.Comparator;

public class EntregaComparator implements Comparator<Entrega> {
    public String criterio;
    public String ordendir;

    public EntregaComparator(String criterio, String ordendir) {
        this.criterio = criterio;
        this.ordendir = ordendir;
    }

    @Override
    public int compare(Entrega o1, Entrega o2) {
        int resul = 0;
        if (criterio.equals("1") && ordendir.equals("1")) {  // codigo sucursal
            resul = o1.codEntrega - o2.codEntrega;     // acendente
        } else if (criterio.equals("1") && ordendir.equals("2")) {// codigo sucursal
            resul = o2.codEntrega - o1.codEntrega;     // descendente

        } else if (criterio.equals("2") && ordendir.equals("1")){// cant empleados
            resul = o1.dimenciones - o2.dimenciones;     // acendente
        } else if (criterio.equals("2") && ordendir.equals("2")) { //cant empleados
            resul = o2.dimenciones - o1.dimenciones;     // descendente

        } else if (criterio.equals("3") && ordendir.equals("1")){// cant empleados
            resul = (int) (o1.costo - o2.costo);     // acendente
        } else if (criterio.equals("3") && ordendir.equals("2")) { //cant empleados
            resul = (int) (o2.costo - o1.costo);     // descendente
        }

        return resul;
    }
}