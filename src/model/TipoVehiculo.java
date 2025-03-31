package model;

public class TipoVehiculo {
    private int id;
    private String name;

    //Getters
    public int getId() { return this.id; }
    public String getName() { return this.name; }

    //Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    
    //Constructor
    public TipoVehiculo(String name) {
        this.name = name;
    }
}
