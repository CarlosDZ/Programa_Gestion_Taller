package model;

public class Proveedor {
    private int id;
    private String nombre;
    private String mail;

    //Getters
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getMail() {
        return mail;
    }
    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    //Constructor
    public Proveedor(String nombre, String mail) {
        this.nombre = nombre;
        this.mail = mail;
    }
}
