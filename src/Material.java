

/**
 *
 * @author vina
 */
public class Material {
    protected String idMaterial;
    protected String titulo;
    protected boolean prestado;

    public Material() {
    }

    public Material(String idMaterial, String titulo, boolean prestado) {
        this.idMaterial = idMaterial;
        this.titulo = titulo;
        this.prestado = prestado;
    }

    public String getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(String idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    @Override
    public String toString() {
        return "Material{" + "idMaterial=" + idMaterial + 
                ", titulo=" + titulo + 
                ", prestado=" + prestado +
                '}';
    }

  
    
    
    
    
    public boolean verificarDisponibilidad() {
        return !prestado;
    }
}
