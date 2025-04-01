package model;

public class Objeto {
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
    public Objeto(String nombre) {
        this.nombre = nombre;
    }
}
