import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    
    private String name;
    private List<Libro> libros;
    private List<Persona> personas;

    public Biblioteca(String name) {
        this.name = name;
        this.libros = new ArrayList<>();
        this.personas = new ArrayList<>();
    }

    public void addBook(Libro libro){
        libros.add(libro);
    }
    public void addPerson(Persona persona){
        personas.add(persona);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Libro> getLibros() {
        return libros;
    }


    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }


    public List<Persona> getPersonas() {
        return personas;
    }


    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
}
