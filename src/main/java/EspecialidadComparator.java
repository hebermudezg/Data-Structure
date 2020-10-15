import java.util.Comparator;

public class EspecialidadComparator implements Comparator<Especialidad> {
    public String criterio;
    public String ordendir;

    public EspecialidadComparator(String criterio, String ordendir) {
        this.criterio = criterio;
        this.ordendir = ordendir;
    }

    @Override
    public int compare(Especialidad o1, Especialidad o2) {
        int resul = 0;
        if (criterio.equals("1") && ordendir.equals("1")) {
            resul = o1.codigoEspecialidad - o2.codigoEspecialidad;

        } else if (criterio.equals("1") && ordendir.equals("2")) {
            resul = o2.codigoEspecialidad - o1.codigoEspecialidad;

        } else if (criterio.equals("2") && ordendir.equals("1")){
            resul = o1.lineaAtencion - o2.lineaAtencion;
        } else if (criterio.equals("2") && ordendir.equals("2")) {
            resul = o2.lineaAtencion - o1.lineaAtencion;

        }
        return resul;
    }



}