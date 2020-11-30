package app;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.TreeMap;

public class Sucursal {
    public String codigoScursal;
    public String ciudad;
    public int cantEmpleados;


    public static Hashtable<String, Sucursal> sucursales = new Hashtable<>();
    public static TreeMap<String, LinkedList<Sucursal>> ciudad_busqueda = new TreeMap<>();
    public static TreeMap<Integer, LinkedList<Sucursal>> cantEmpleados_busqueda = new TreeMap<>();

    // Constructr
    public Sucursal(String codigoScursal, String ciudad, int cantEmpleados, Empresa empresa) {
        this.codigoScursal = codigoScursal;
        this.ciudad = ciudad;
        this.cantEmpleados = cantEmpleados;

        sucursales.put(codigoScursal, this);

        // vertice (creando el nodo)
        App.graph.addVertex(this);

        // Arista (creando la arista de este objeto con empresa)
        App.graph.addEdge(this, empresa);

        // Agregando ciudad *********************
        if(ciudad_busqueda.containsKey(ciudad.toLowerCase())){  // si esta en el treemap simplemete lo traigo y agrego
            ciudad_busqueda.get(ciudad.toLowerCase()).add(this); // retorno lista y agrego objeto
        }else{ // si no esta creo la lista, lo agrego
            LinkedList<Sucursal> listanueva = new LinkedList<>();
            listanueva.add(this);
            // añadiendo el nuevo valor en la bolsa con la respectiva lista al tree map
            ciudad_busqueda.put(ciudad.toLowerCase(), listanueva);
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

    public boolean editarcodigosucursal(String codigosucurslanuevo){
        if (sucursales.containsKey(codigosucurslanuevo)){
            return false;
        }else{
            sucursales.remove(this.codigoScursal);
            sucursales.put(codigosucurslanuevo, this);
            this.codigoScursal = codigosucurslanuevo; // actualizar
            return true;
        }

    }

    public boolean editarciudad(String nuevaciudadd){

        String nuevaciudad = nuevaciudadd.toLowerCase();
        ciudad_busqueda.get(this.ciudad).remove(this);

        if(ciudad_busqueda.containsKey(nuevaciudad)){
            ciudad_busqueda.get(nuevaciudad).add(this);
        }else{
            LinkedList<Sucursal> listanueva = new LinkedList<>();
            listanueva.add(this);
            ciudad_busqueda.put(nuevaciudad, listanueva);
        }
        this.ciudad = nuevaciudad;
        return true;
    }


    public boolean editarcantempleados(Integer nuevovacantempleados){
        cantEmpleados_busqueda.get(this.cantEmpleados).remove(this); // romover este elemto de la lista

        if(cantEmpleados_busqueda.containsKey(nuevovacantempleados)){
            cantEmpleados_busqueda.get(nuevovacantempleados).add(this);
        }else{
            LinkedList<Sucursal> listanueva = new LinkedList<>();
            listanueva.add(this);
            cantEmpleados_busqueda.put(nuevovacantempleados, listanueva);
        }
        this.cantEmpleados = nuevovacantempleados;
        return true;
    }


    public boolean eliminarsucursal(){
        // eliminar del tablhas
        sucursales.remove(this);
        // eliminar de los arboles
        ciudad_busqueda.get(this.ciudad.toLowerCase()).remove(this); // lista --> removelista --> objeto
        cantEmpleados_busqueda.get(this.cantEmpleados).remove(this);
        // grafo
        App.graph.removeVertex(this);
        return true;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) { // apuntan al mismo?
            return true;
        }
        if (!(obj instanceof Sucursal)) {
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
