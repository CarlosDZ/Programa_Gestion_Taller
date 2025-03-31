package model;

public class Servicio {
    private int id;
    private String name;
    private Double price;

    //Getters
    public int getId() { return this.id; }
    public String getName() { return this.name; }
    public Double getPrice() { return this.price; }
    //Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPrice(Double price) { this.price = price; }
    //Constructor
    public Servicio(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    
}
