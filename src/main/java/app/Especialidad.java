package app;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.TreeMap;

public class Especialidad {
    public int codigoEspecialidad;
    public String encargado;
    public int numero_entregas;

    // para la clave principal HasTable
    public static Hashtable<Integer, Especialidad> especialidades = new Hashtable<>();
    // para los otros atributos TreeMap
    public static TreeMap<String, LinkedList<Especialidad>> encargados_buscar = new TreeMap<>();
    public static TreeMap<Integer, LinkedList<Especialidad>> numero_entregas_buscar = new TreeMap<>();


    public Especialidad(int codigo, String encargado, int numero_entregas, Sucursal sucursal) {
        this.codigoEspecialidad = codigo;
        this.encargado = encargado;
        this.numero_entregas = numero_entregas;

        // vertice (creando el nodo)
        App.graph.addVertex(this);

        // Arista (creando la arista de este objeto con empresa)
        App.graph.addEdge(this, sucursal);

        // Agregando encargado el tree*************
        if (encargados_buscar.containsKey(encargado)){
            encargados_buscar.get(encargado).add(this); // agregar esta
        }else {
            LinkedList<Especialidad> listanueva = new LinkedList<>();
            listanueva.add(this);
            encargados_buscar.put(encargado, listanueva);
        }

        // Agregando numero de entregas ************
        if (numero_entregas_buscar.containsKey(numero_entregas)){
            numero_entregas_buscar.get(numero_entregas).add(this); // agregar esta
        }else {
            LinkedList<Especialidad> listanueva = new LinkedList<>();
            listanueva.add(this);
            numero_entregas_buscar.put(numero_entregas, listanueva);
        }

    }



    public boolean editarcodigoespcialidad(Integer codigoespecialiadanuevo){
        if (especialidades.containsKey(codigoespecialiadanuevo)){
            return false;
        }else{
            especialidades.remove(this.codigoEspecialidad);
            especialidades.put(codigoespecialiadanuevo, this);
            this.codigoEspecialidad = codigoespecialiadanuevo; // actualizar
            return true;
        }
    }


    public boolean editarencargado(String nuevoencargado){
        encargados_buscar.get(this.encargado).remove(this);
        if(encargados_buscar.containsKey(nuevoencargado)){
            encargados_buscar.get(nuevoencargado).add(this);
        }else{
            LinkedList<Especialidad> listanueva = new LinkedList<>();
            listanueva.add(this);
            encargados_buscar.put(nuevoencargado, listanueva);
        }
        this.encargado = nuevoencargado;
        return true;
    }

    public boolean editarnumeroentregas(Integer nuevovanumempleados){
        numero_entregas_buscar.get(this.numero_entregas).remove(this); // romover este elemto de la lista

        if(numero_entregas_buscar.containsKey(nuevovanumempleados)){
            numero_entregas_buscar.get(nuevovanumempleados).add(this);
        }else{
            LinkedList<Especialidad> listanueva = new LinkedList<>();
            listanueva.add(this);
            numero_entregas_buscar.put(nuevovanumempleados, listanueva);
        }
        this.numero_entregas = nuevovanumempleados;
        return true;
    }


    
    public boolean eliminarespecialidad(){
        // eliminar del tablhas
        especialidades.remove(this);
        // eliminar de los arboles
        encargados_buscar.get(this.encargado).remove(this); // lista --> removelista --> objeto
        numero_entregas_buscar.get(this.numero_entregas).remove(this);
        // grafo
        App.graph.removeVertex(this);
        return true;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) { // apuntan al mismo?
            return true;
        }
        if (!(obj instanceof Especialidad)) {
            return false; // es intancia de empresa?
        }
        Especialidad especialidad = (Especialidad) obj;
        return especialidad.codigoEspecialidad == this.codigoEspecialidad;
    }


    @Override
    public String toString() {
        return "Especialidad" +"\n"+
                "\t Codigo: " + codigoEspecialidad +"\n"+
                "\t Encargado: " + encargado + "\n" +
               "\t numero_entregas: " + numero_entregas +"\n"+
                "\t ";
    }
}
