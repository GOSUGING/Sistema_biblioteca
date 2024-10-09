
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vina
 */
public class Revista extends Material {
    private String editorial;
    private int numeroEdicion;
    private ArrayList<Revista> listaRevistas;

    public Revista() {
    }

    public Revista(String editorial, int numeroEdicion, ArrayList<Revista> listaRevistas, String idMaterial, String titulo, boolean prestado) {
        super(idMaterial, titulo, prestado);
        this.editorial = editorial;
        this.numeroEdicion = numeroEdicion;
        this.listaRevistas = listaRevistas;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    public void setNumeroEdicion(int numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }

    public ArrayList<Revista> getListaRevistas() {
        return listaRevistas;
    }

    public void setListaRevistas(ArrayList<Revista> listaRevistas) {
        this.listaRevistas = listaRevistas;
    }
    
    
    

    @Override
    public String toString() {
        return super.toString()+ "" + " Revista{" + "editorial=" + editorial + ", numeroEdicion=" + numeroEdicion + ", listaRevistas=" + listaRevistas + '}';
    }

    public void verArticulosDestacados() {
        System.out.println("Revistas destacadas");
        
        for (Revista revista : listaRevistas) {
            if(revista.getNumeroEdicion() > 10) {
                System.out.println("Titulo: " + revista.getTitulo() + ", Edicion: " + revista.getNumeroEdicion());
            }
        }
    }
    
    
    
    
    
    
}
