package model;

public class Inventario {
    private int id_objeto;
    private int cantidad;

    //setters
    public void setId_objeto(int id_objeto) {
        this.id_objeto = id_objeto;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    //getters
    public int getId_objeto() {
        return id_objeto;
    }
    public int getCantidad() {
        return cantidad;
    }
    //constructor
    public Inventario(int id_objeto, int cantidad) {
        this.id_objeto = id_objeto;
        this.cantidad = cantidad;
    }

}  
