import java.util.Comparator;

public class TipoDeEntregaComparator implements Comparator<TipoDeEntrega> {
    public String criterio;
    public String ordendir;

    public TipoDeEntregaComparator(String criterio, String ordendir) {
        this.criterio = criterio;
        this.ordendir = ordendir;
    }

    @Override
    public int compare(TipoDeEntrega o1, TipoDeEntrega o2) {
        int resul = 0;
        if (criterio.equals("1") && ordendir.equals("1")) {  // codigo sucursal
            resul = o1.Codigo - o2.Codigo;     // acendente

        } else if (criterio.equals("1") && ordendir.equals("2")) {// codigo sucursal
            resul = o2.Codigo - o1.Codigo;     // descendente

        } else if (criterio.equals("2") && ordendir.equals("1")){// cant empleados
            resul = o1.Tiempo_Estimado - o2.Tiempo_Estimado;     // acendente
        } else if (criterio.equals("2") && ordendir.equals("2")) { //cant empleados
            resul = o2.Tiempo_Estimado - o1.Tiempo_Estimado;     // descendente

        }
        return resul;
    }
}