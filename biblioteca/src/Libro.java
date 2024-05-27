public class Libro{

    private String title;
    private String author;
    private int year;
    private int unidades;


    public Libro(String title, String author, int year, int unidades) {
        
        this.title = title;
        this.author = author;
        this.year = year;
        this.unidades = unidades;


    }

    @Override
    public String toString(){
        return "Titulo: " + getTitle() + ", Autor: " + getAuthor() + ", Año: " + getYear() + ", Unidades: " + getUnidades();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

}