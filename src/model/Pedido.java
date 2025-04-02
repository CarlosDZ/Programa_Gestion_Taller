package model;

import Main.Taller;
import java.util.ArrayList;

public class Pedido {
    private int id;
    private int id_proveedor;
    private boolean compleated;
    private ArrayList<Inventario> contenido;

    //Getters
    public int getId() {
        return id;
    }
    public int getId_proveedor() {
        return id_proveedor;
    }
    public boolean isCompleated() {
        return compleated;
    }
    public ArrayList<Inventario> getContenido() {
        return contenido;
    }
    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }
    public void changeState() {
        this.compleated = !this.compleated;
    }

    public void setContenido(ArrayList<Inventario> contenido) {
        this.contenido = contenido;
    }
    
    //Constructor
    public Pedido(int id_proveedor, ArrayList<Inventario> contenido) {
        this.id_proveedor = id_proveedor;
        this.compleated = false;
        this.contenido = contenido;
    }
    public Pedido(int id, int id_proveedor, boolean compleated, ArrayList<Inventario> contenido) {
        this.id = id;
        this.id_proveedor = id_proveedor;
        this.compleated = compleated;
        this.contenido = contenido;
    }

    //Metodos
    public void details(){
        System.out.println("Detalles del pedido");
        System.out.print("ID: " + this.id);
        System.out.print("        ID Proveedor: " + this.id_proveedor);
        System.out.println("        Estado: " + (compleated ? "Completado" : "Pendiente"));
        System.out.println("Nombre Proveedor: " + Taller.idToProveedor(id_proveedor).getNombre());
        System.out.println("Contenido: ");
        for(Inventario item : contenido){
            System.out.println("    "+item.getId_objeto() + " - " + Taller.idToObjeto(item.getId_objeto()).getNombre() + " - " + item.getCantidad());
        }
    }
}
