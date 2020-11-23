package app;
import java.util.ArrayList;
import java.util.Hashtable;

public class Autor {
    public static Hashtable<String, Autor> autores = new Hashtable<>();

    public String cedula;
    public String nombre;
    public int edad;
    public String codigoUnicoAutor;
    public ArrayList<Libro> libros;

    public Autor(String cedula, String nombre, int edad, String codigoUnicoAutor) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.codigoUnicoAutor = codigoUnicoAutor;
        this.libros = new ArrayList<>();
        autores.put(cedula,this);
    }
    @Override
    public String toString() {
        return  "\n\t-Cedula : " + cedula + '\n' +
                "\t-Nombre : " + nombre + '\n' +
                "\t-Edad : " + edad + '\n' +
                "\t-Codigo unico autor : " + codigoUnicoAutor;
    }
    public void asociarLibro(Libro libro){
        this.libros.add(libro);
    }
}
