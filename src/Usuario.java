
import java.util.ArrayList;


/**
 *
 * @author vina
 */
public class Usuario {
    private int idUsuario;
    private String nombre;
    private ArrayList<Prestamo> listaPrestamos;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombre) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.listaPrestamos = new ArrayList<>();
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }

    public void setListaPrestamos(ArrayList<Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombre=" + nombre + ", listaPrestamos=" + listaPrestamos + '}';
    }
    
    public void agregarPrestamo(Prestamo prestamo) {
        listaPrestamos.add(prestamo);
    }
    
    public void devolverPrestamo(Prestamo prestamo) {
         listaPrestamos.remove(prestamo);
    }
}
