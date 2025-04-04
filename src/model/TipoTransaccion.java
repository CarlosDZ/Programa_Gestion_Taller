package model;

public class TipoTransaccion {
    private int id;
    private String nombre;

    //Getters
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //Constructor
    public TipoTransaccion(String nombre) {
        this.nombre = nombre;
    }
    public TipoTransaccion(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    
}
