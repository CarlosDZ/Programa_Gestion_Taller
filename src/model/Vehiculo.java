package model;

import Main.Taller;
import dao.ClienteDAO;
import java.util.ArrayList;
import java.util.Scanner;

public class Vehiculo {
    Scanner sc = new Scanner(System.in);

    private int id;
    private String model;
    private int year;
    private String license_plate;
    private int id_brand;
    private int id_owner;
    private int vehicle_type;
    
    //Getters
    public int getId() { return id; }
    public String getModel() { return model; }
    public int getId_brand() { return id_brand; }
    public int getId_owner() { return id_owner; }
    public int getVehicle_type() { return vehicle_type; }
    public int getYear() { return year; }
    public String getLicense_plate() { return license_plate; }
    
    //Setters
    public void setId(int id) { this.id = id; }
    public void setModel(String model) { this.model = model; }
    public void setId_brand(int id_brand) { this.id_brand = id_brand; }
    public void setId_owner(int id_owner) { this.id_owner = id_owner; }
    public void setVehicle_type(int vehicle_type) { this.vehicle_type = vehicle_type; }
    public void setLicense_plate(String license_plate) { this.license_plate = license_plate; }
    public void setYear(int year) { this.year = year; }
    
    //Constructor
    public Vehiculo(String model, int year, String license_plate, int id_brand, int vehicle_type) {
        this.model = model;
        this.year = year;
        this.license_plate = license_plate;
        this.id_brand = id_brand;
        this.vehicle_type = vehicle_type;
    }

    //Metodos
    public void linkToCliente(){
        ArrayList<Cliente> lista_clientes = ClienteDAO.getAll();
        if(!lista_clientes.isEmpty()){
            System.out.println("Estos son los clientes disponibles: ");
            Taller.showAllClientes();
            Cliente owner;
            do{
                System.out.println("Introduce el ID del dueño de este vehiculo.");
                owner = Taller.idToCliente(sc.nextInt());
                if(owner == null){
                    System.out.println("El ID introducido no es correcto, prueba de nuevo.");
                }
                else{
                    setId_owner(owner.getID());
                    System.out.println("El vehiculo ha sido vinculado al cliente " + owner.getName());
                }
            }while(owner == null);
        }
    }

    public void details(){
        String nombre_tipo = Taller.idToTipoVehiculo(this.vehicle_type).getName();
        String nombre_marca = Taller.idToMarca(this.id_brand).getName();
        String nombre_cliente = Taller.idToCliente(this.id_owner).getName();
        System.out.println("ID: " + this.id + "\nModelo: " + this.model + "\nAño: " + this.year + "\nPlaca: " + this.license_plate + "\n\nMarca: " + nombre_marca + "\nTipo de vehiculo: " + nombre_tipo + "\n\nID dueño: "+this.id_owner+"\nNombre dueño: " + nombre_cliente);
    }


}
