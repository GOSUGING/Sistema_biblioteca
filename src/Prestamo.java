
import java.util.Date;
import java.util.concurrent.TimeUnit;


/**
 *
 * @author vina
 */
public class Prestamo {
    private Material material;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    public Prestamo() {
    }

    public Prestamo(Material material, Date fechaPrestamo, Date fechaDevolucion) {
        this.material = material;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "material=" + material + ", fechaPrestamo=" + fechaPrestamo + ", fechaDevolucion=" + fechaDevolucion + '}';
    }
    
    public double calcularMulta() {
    if (fechaDevolucion == null) {
        System.out.println("No se ha devuelto el material. No se puede calcular la multa.");
        return 0.0; 
    }
    
    long diferenciaEnMilisegundos = fechaDevolucion.getTime() - fechaPrestamo.getTime();
    long diasDePrestamo = diferenciaEnMilisegundos / (1000 * 60 * 60 * 24);

    
    int diasPermitidos = 14; 

    if (diasDePrestamo > diasPermitidos) {
        double multaPorDia = 550.0; 
        long diasRetraso = diasDePrestamo - diasPermitidos;
        return diasRetraso * multaPorDia;
    } else {
        return 0.0; 
    }
}
    
    
    
}
