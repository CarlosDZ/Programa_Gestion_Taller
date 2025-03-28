package model;

import dao.ClienteDAO;
import java.sql.Date;
import java.util.Scanner;

public class Cliente {
    Scanner sc = new Scanner(System.in);
    private int id;
    private String name;
    private String phone_num;
    private String shipping_location;
    private Date registration_date;
    private int entity_type; // 1 - Person  // 2 - Enterprise
    

    //Constructor
    public Cliente(String name,String phone,String location,int entity_type){
        this.name = name;
        this.phone_num = phone;
        this.shipping_location = location;
        this.entity_type = entity_type;
    }

    //Getters
    public int getID(){ return this.id; }
    public String getName(){ return this.name; }
    public String getPhone(){ return this.phone_num; }
    public String getLocation(){ return this.shipping_location; }
    public Date getDate(){ return this.registration_date; }
    public int getType(){ return this.entity_type; }

    //Setters
    public void setRegistrationDate(Date date){ this.registration_date = date; }
    public void setID(int id){ this.id = id; }

    //Metodos
    public void actualizarDatos(){
        
        System.out.println("Que quieres editar?\n1 - Nombre\n2 - Telefono\n3 - Direccion de envio\n4 - Tipo de cliente\n5 - Cancelar");
        int option;
        do { 
            option = sc.nextInt();
            if(option<1||option>5) System.out.println("El numero no entra en el rango, prueba de nuevo.");
        } while (option<1||option>5);

        switch (option) {
            case 1-> {
                System.out.println("Introduce el nuevo nombre.");
                sc.nextLine();
                String newName = sc.nextLine();
                ClienteDAO.actualizarNombre(this, newName);
            }
            case 2-> {
                System.out.println("Introduce el nuevo telefono.");
                String newTlfNumber = sc.next();
                ClienteDAO.actualizarTelefono(this, newTlfNumber);
            }
            case 3-> {
                System.out.println("Introduce la nueva direccion de envio.");
                sc.nextLine();
                String newLocation = sc.nextLine();
                ClienteDAO.actualizarDireccion(this, newLocation);
            }
            case 4-> {
                System.out.println("Introduce el nuevo tipo de cliente. (1 - Persona fisica // 2 - Empresa o grupo de personas // 3 - Otro)");
                int newTipe;
                do { 
                    newTipe = sc.nextInt();
                    if(newTipe<1||newTipe>3) System.out.println("El numero no entra en el rango, prueba de nuevo.");
                } while (newTipe<1||newTipe>3);
                ClienteDAO.actualizarTipoEntidad(this, newTipe);
            }
            case 5-> {
                System.out.println("OK. Volviendo al menu de clientes...");
            }
        }
    }

    public void details(){
        String tipo;
        switch (getType()) {
            case 1 -> tipo = "Persona";
            case 2 -> tipo = "Empresa";
            default -> tipo = "Otros";
        }
        System.out.println(getName()+"\n(ID: "+getID()+")\n\nNum TLF: "+getPhone()+"\nDireccion: "+getLocation());
        System.out.println("\nCliente de tipo "+tipo+" registrado el "+getDate());

        //añadir lista de vehiculos vinculados
    }
}
