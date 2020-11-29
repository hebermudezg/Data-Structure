package app;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.TreeMap;

public class Empresa {
    public static String Nit;
    public int valor_en_bolsa;
    public String RazonSocial;

    //Tabla Hash Empresas (Nits)
    public static Hashtable<String, Empresa> empresas = new Hashtable<>();
    //los treemap para implementar las busquedas (hay que ordenar)
    public static TreeMap<Integer, LinkedList<Empresa>> valores_en_bolsa_busqueda = new TreeMap<>();
    public static TreeMap<String, LinkedList<Empresa>> RazonSocial_busqueda = new TreeMap<>();

    //Constuctor de empresa***
    public Empresa(String Nit, int valor_en_bolsa, String RazonSocial) {
        this.Nit = Nit;
        this.valor_en_bolsa = valor_en_bolsa;
        this.RazonSocial = RazonSocial.toLowerCase(); // convertir a minusculas
        // crenado vertice
        App.graph.addVertex(this);

        // agregand en el hash
        empresas.put(Nit, this);

        // Agregando en los treemaps
        if(valores_en_bolsa_busqueda.containsKey(valor_en_bolsa)){
            valores_en_bolsa_busqueda.get(valor_en_bolsa).add(this);
        }else{
            LinkedList<Empresa> listanueva = new LinkedList<>();
            listanueva.add(this);
            // añadiendo el nuevo valor en la bolsa con la respectiva lista al tree map
            valores_en_bolsa_busqueda.put(valor_en_bolsa, listanueva);
        }

        if(RazonSocial_busqueda.containsKey(RazonSocial)){
            RazonSocial_busqueda.get(valor_en_bolsa).add(this);
        }else{
            LinkedList<Empresa> listanueva = new LinkedList<>();
            listanueva.add(this);
            RazonSocial_busqueda.put(RazonSocial, listanueva);
        }


    }

    // Metodo para editar Nit*******
    public boolean editarNit(String nitnew){
        if (empresas.containsKey(nitnew)){
            return false;
        }else{
            empresas.remove(this.Nit);
            empresas.put(nitnew, this);
            this.Nit = nitnew; // actualizar
            return true;
        }
    }

    // Metodo editar valor en la bolsa ******
    public boolean editarvalorenbolsa(Integer nuevovalorenbolsa){
        valores_en_bolsa_busqueda.get(this.valor_en_bolsa).remove(this); // romover actual

        if(valores_en_bolsa_busqueda.containsKey(nuevovalorenbolsa)){
            valores_en_bolsa_busqueda.get(nuevovalorenbolsa).add(this);
        }else{
            LinkedList<Empresa> listanueva = new LinkedList<>();
            listanueva.add(this);
            valores_en_bolsa_busqueda.put(nuevovalorenbolsa, listanueva);
        }
        return true;
    }

    /*public void eliminarempresa(String niteliminar){
        empresas.get(niteliminar);
    }*/


    /*public boolean editarrazonsocial(String nitnew){
        if (empresas.containsKey(nitnew)){
            return false;
        }else{
            empresas.remove(this.Nit);
            empresas.put(nitnew, this);
            this.Nit = nitnew; // actualizar
            return true;
        }
    }*/


    @Override
    public boolean equals(Object obj) {
        if (obj == this) { // apuntan al mismo?
            return true;
        }
        if (!(obj instanceof Empresa)) {
            return false; // es intancia de empresa?
        }
        Empresa empresa = (Empresa) obj;
        return empresa.Nit == this.Nit;
    }


    @Override
    public String toString() {
        return "Empresa" + "\n"+
                "\t Nit:" + Nit + "\n" +
                "\t Valor en la bolsa:" + valor_en_bolsa +"\n" +
                "\t Razon social:" + RazonSocial +"\n" +
                "\t ";
    }



}
