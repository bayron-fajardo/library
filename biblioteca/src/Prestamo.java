import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class Prestamo {
    private Libro libro;
    private Persona persona;
    private LocalDate fechaPrestamo;

    public Prestamo(Libro libro, Persona persona) {
        this.libro = libro;
        this.persona = persona;
        this.fechaPrestamo = LocalDate.now();
    }

    public void makeLoan() {
        persona.setActiveLoan(true);
        persona.setLoanDate(fechaPrestamo);
        libro.setUnidades(libro.getUnidades() - 1); // Decrementar el número de unidades disponibles
        System.out.println("Préstamo realizado con éxito.");
    }

    public void saveLoan() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/docs/prestamos.txt", true))) {
            writer.write("Libro prestado: " + libro.getTitle() + ", Persona: " + persona.getName() + ", Fecha de préstamo: " + fechaPrestamo);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar el préstamo: " + e.getMessage());
        }
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

}
