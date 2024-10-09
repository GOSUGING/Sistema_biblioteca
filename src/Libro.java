
/**
 *
 * @author vina
 */
public class Libro extends Material {
    private String autor;
    private String genero;

    public Libro() {
    }

    public Libro(String autor, String genero, String idMaterial, String titulo, boolean prestado) {
        super(idMaterial, titulo, prestado);
        this.autor = autor;
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    

    @Override
    public String toString() {
        return super.toString()+ "" + "Libro{" + "autor=" + autor + ", genero=" + genero + '}';
    }
    
    public String obtenerResumen() {
        
        String disponibilidad = (isPrestado()) ? "No disponible (prestado)" : "Disponible";
        
        return "Título: " + this.getTitulo() + "\n" +
                "Autor: " + autor + "\n" +
                "Genero: " + genero + "\n" +
                "ID: " + this.getIdMaterial() + "\n" +
                "Estado: " + disponibilidad;
    }
    
}
