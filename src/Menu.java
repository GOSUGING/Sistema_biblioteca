
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


/**
 *
 * @author Aron
 */
public class Menu {
    private final ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private final ArrayList<Material> listaMateriales = new ArrayList<>();

     public void ejecutarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("\nMenú Principal:");
            System.out.println("1. Agregar Usuario");
            System.out.println("2. Agregar Libro");
            System.out.println("3. Agregar Revista");
            System.out.println("4. Registrar Préstamo");
            System.out.println("5. Devolver Material y Calcular Multa");
            System.out.println("6. Mostrar Usuarios");
            System.out.println("7. Mostrar Materiales con Resumen");
            System.out.println("8. Verificar Disponibilidad de Material");
            System.out.println("9. Salir");
            System.out.print("Selecciona una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1 -> agregarUsuario(scanner);
                case 2 -> agregarLibro(scanner);
                case 3 -> agregarRevista(scanner);
                case 4 -> registrarPrestamo(scanner);
                case 5 -> devolverMaterialYCalcularMulta(scanner);
                case 6 -> mostrarUsuarios();
                case 7 -> mostrarMaterialesConResumen();
                case 8 -> verificarDisponibilidadMaterial(scanner);
                case 9 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 9);
    }

    private void agregarUsuario(Scanner scanner) {
        System.out.print("Ingresa el ID del usuario: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingresa el nombre del usuario: ");
        String nombre = scanner.nextLine();
        
        Usuario usuario = new Usuario(idUsuario, nombre);
        listaUsuarios.add(usuario);
        
        System.out.println("Usuario agregado exitosamente.");
    }

    private void agregarLibro(Scanner scanner) {
        System.out.print("Ingresa el ID del libro: ");
        String idMaterial = scanner.nextLine();
        System.out.print("Ingresa el título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingresa el autor del libro: ");
        String autor = scanner.nextLine();
        System.out.print("Ingresa el género del libro: ");
        String genero = scanner.nextLine();
        
        Libro libro = new Libro(autor, genero, idMaterial, titulo, false);
        listaMateriales.add(libro);
        
        System.out.println("Libro agregado exitosamente.");
    }

    private void agregarRevista(Scanner scanner) {
        System.out.print("Ingresa el ID de la revista: ");
        String idMaterial = scanner.nextLine();
        System.out.print("Ingresa el título de la revista: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingresa la editorial de la revista: ");
        String editorial = scanner.nextLine();
        System.out.print("Ingresa el número de edición de la revista: ");
        int numeroEdicion = scanner.nextInt();
        
        Revista revista = new Revista(editorial, numeroEdicion, new ArrayList<>(), idMaterial, titulo, false);
        listaMateriales.add(revista);
        
        System.out.println("Revista agregada exitosamente.");
    }

    private void registrarPrestamo(Scanner scanner) {
        System.out.print("Ingresa el ID del usuario: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine(); 
        Usuario usuario = buscarUsuario(idUsuario);
        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        System.out.print("Ingresa el ID del material (libro o revista): ");
        String idMaterial = scanner.nextLine();
        
        Material material = buscarMaterial(idMaterial);
        if (material == null) {
            System.out.println("Material no encontrado.");
            return;
        }
        
        if (!material.verificarDisponibilidad()) {
            System.out.println("El material no está disponible.");
            return;
        }
        
        Prestamo prestamo = new Prestamo(material, new Date(), null);
        usuario.agregarPrestamo(prestamo);
        material.setPrestado(true);
        
        System.out.println("Préstamo registrado exitosamente.");
    }
    
    private void devolverMaterialYCalcularMulta(Scanner scanner) {
        System.out.print("Ingresa el ID del usuario: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine(); 

        Usuario usuario = buscarUsuario(idUsuario);
        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        System.out.print("Ingresa el ID del material a devolver: ");
        String idMaterial = scanner.nextLine();

        Material material = buscarMaterial(idMaterial);
        if (material == null || !material.isPrestado()) {
            System.out.println("Material no encontrado o no está prestado.");
            return;
        }

        
        Prestamo prestamoADevolver = null;
        for (Prestamo prestamo : usuario.getListaPrestamos()) {
            if (prestamo.getMaterial().getIdMaterial().equals(idMaterial)) {
                prestamoADevolver = prestamo;
                break;
            }
        }

        if (prestamoADevolver != null) {
           
            prestamoADevolver.setFechaDevolucion(new Date());

            
            double multa = prestamoADevolver.calcularMulta();

            
            material.setPrestado(false);
            usuario.devolverPrestamo(prestamoADevolver);

            System.out.println("Material devuelto exitosamente. Multa: $" + multa);
        } else {
            System.out.println("El usuario no tiene este material en préstamo.");
        }
    }

    private void mostrarUsuarios() {
        if (listaUsuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            for (Usuario usuario : listaUsuarios) {
                System.out.println(usuario);
            }
        }
    }

    private void mostrarMaterialesConResumen() {
        if (listaMateriales.isEmpty()) {
            System.out.println("No hay materiales registrados.");
        } else {
            for (Material material : listaMateriales) {
                System.out.println(material);
                if (material instanceof Libro libro) {
                    System.out.println("Resumen del libro: " + libro.obtenerResumen());
                }
            }
        }
    }

    private void verificarDisponibilidadMaterial(Scanner scanner) {
        System.out.print("Ingresa el ID del material a verificar: ");
        String idMaterial = scanner.nextLine();
        
        Material material = buscarMaterial(idMaterial);
        if (material == null) {
            System.out.println("Material no encontrado.");
        } else {
            if (material.verificarDisponibilidad()) {
                System.out.println("El material está disponible.");
            } else {
                System.out.println("El material no está disponible.");
            }
        }
    }

    private Usuario buscarUsuario(int idUsuario) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getIdUsuario() == idUsuario) {
                return usuario;
            }
        }
        return null;
    }

    private Material buscarMaterial(String idMaterial) {
        for (Material material : listaMateriales) {
            if (material.getIdMaterial().equals(idMaterial)) {
                return material;
            }
        }
        return null;
    }
}
