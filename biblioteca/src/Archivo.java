import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class Archivo {
    private String fileName;

    public Archivo(String name) {

        this.fileName = "src/docs/" + name + ".txt";
        File archivo = new File(fileName);

        try{
            if (!archivo.exists()){
                archivo.createNewFile();
                System.out.println("Archivo creado: " + archivo.getAbsolutePath());
            }
        } catch(IOException e){
            System.out.println("Error al crear el archivo " + e.getMessage());
        }  
    }

    public void saveDataLibros(List<Libro> libros) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/docs/libros.txt", true))) {
            for (Libro libro : libros) {
                writer.write(libro.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar los datos de los libros: " + e.getMessage());
        }
    }

    public void saveDataPersonas(List<Persona> personas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/docs/personas.txt", true))) {
            for (Persona persona : personas) {
                writer.write(persona.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar los datos de las personas: " + e.getMessage());
        }
    }

    public void clearData(String fileName){
        try(BufferedWriter write = new BufferedWriter(new FileWriter(fileName))){
            
        }catch(IOException e ){
            System.out.println("Error al borrar los datos del archivo: " + e.getMessage());
        }
    }
    public void showData(String fileName){
        String ruta = "src/docs/" + fileName;
        try(BufferedReader reader = new BufferedReader(new FileReader(ruta))){
            String line;

            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException e) {
            System.err.println("Error al mostrar los datos del archivo: " + e.getMessage());
        }
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
