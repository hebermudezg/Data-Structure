package app;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.TreeMap;

public class Sucursal {
    public int codigoScursal;
    public String ciudad;
    public int cantEmpleados;

    public static Hashtable<Integer, Sucursal> sucursales = new Hashtable<>();
    public static TreeMap<String, LinkedList<Sucursal>> ciudad_busqueda = new TreeMap<>();
    public static TreeMap<Integer, LinkedList<Sucursal>> cantEmpleados_busqueda = new TreeMap<>();


    public Sucursal(int codigoScursal, String ciudad, int cantEmpleados, Empresa empresa) {
        this.codigoScursal = codigoScursal;
        this.ciudad = ciudad;
        this.cantEmpleados = cantEmpleados;

        // vertice (creando el nodo)
        App.graph.addVertex(this);

        // Arista (creando la arista de este objeto con empresa)
        App.graph.addEdge(this, empresa);

        // Agregando ciudad *********************
        if(ciudad_busqueda.containsKey(ciudad)){  // si esta en el treemap simplemete lo traigo y agrego
            ciudad_busqueda.get(ciudad).add(this); // retorno lista y agrego objeto
        }else{ // si no esta creo la lista, lo agrego
            LinkedList<Sucursal> listanueva = new LinkedList<>();
            listanueva.add(this);
            // añadiendo el nuevo valor en la bolsa con la respectiva lista al tree map
            ciudad_busqueda.put(ciudad, listanueva);
        }

        // Agregando Cantidad de empleados **************
        if(cantEmpleados_busqueda.containsKey(cantEmpleados)){
            cantEmpleados_busqueda.get(cantEmpleados).add(this); // traigo la lista y agrego (si esta)
        }else{ // si no pues creo la lista
            LinkedList<Sucursal> listanueva = new LinkedList<>();
            listanueva.add(this);
            cantEmpleados_busqueda.put(cantEmpleados, listanueva);
        }

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) { // apuntan al mismo?
            return true;
        }
        if (!(obj instanceof Empresa)) {
            return false; // es intancia de empresa?
        }
        Sucursal sucursal = (Sucursal) obj;
        return sucursal.codigoScursal == this.codigoScursal;
    }

    @Override
    public String toString() {
        return "Sucursal" +"\n"+
                "\t Codigo: " + codigoScursal +"\n"+
                "\t Ciudad: " + ciudad + "\n" +
                "\t Cantidad de empleados: " + cantEmpleados +"\n"+
                "\t ";
    }
}
