package app;

import java.util.Hashtable;

public class Libro {

    public static Hashtable<String, Libro> libros = new Hashtable<>();

    public String UNSBN;
    public String nombre;
    public String genero;
    public int numeroDePaginas;
    public Autor autor;

    public Libro(String UNSBN, String nombre, String genero, int numeroDePaginas, Autor autor) {
        this.UNSBN = UNSBN;
        this.nombre = nombre;
        this.genero = genero;
        this.numeroDePaginas = numeroDePaginas;
        this.autor = autor;
        autor.libros.add(this);
        libros.put(UNSBN,this);
    }

    @Override
    public String toString() {
        return "UNSBN : " + UNSBN + '\n' +
                "Nombre : " + nombre + '\n' +
                "Genero : " + genero + '\n' +
                "Numero de paginas : " + numeroDePaginas + '\n' +
                "Autor : " + autor;
    }
}
