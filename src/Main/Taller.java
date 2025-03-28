package Main;
import dao.*;
import java.util.ArrayList;
import java.util.Scanner;
import model.*;
import view.*;

public class Taller {
    private static final String NAME = "Nombre_Taller";
    static Scanner scanner = new Scanner(System.in);

    //Variables
    private static Double current_money;

    public static String getName(){ return Taller.NAME; }
    public static Double getCurMoney(){ return Taller.current_money; }


    //Creacion de objetos
    public static void newCliente(){
        System.out.println("Introduce el nombre que quieres darle a tu nuevo cliente.");
        String name = scanner.nextLine();

        System.out.println("Introduce su numero de telefono (Sin espacios, solo numeros)");
        String phone = scanner.next();

        System.out.println("Introduce su direccion (de cara a envios)");

        scanner.nextLine();
        String location = scanner.nextLine();

        int type;
        do{
            System.out.println("Elige el tipo de tu cliente: \n1 - Persona fisica\n2 - Empresa o grupo de personas\n3 - Otro");
            type = scanner.nextInt();
            if(type<1||type>3) System.out.println("El numero no esta en el rango, prueba de nuevo con un numero en el rango establecido.");
        }while(type<1||type>3);

        ClienteDAO.insert(new Cliente(name, phone, location, type));
    }

    public static void showAllClientes(){
        ArrayList<Cliente> lista_clientes = ClienteDAO.getAll();
        if(!lista_clientes.isEmpty()){
            System.out.println("-------------------------------------");
            ClienteView.quickGeneralView(lista_clientes);
            System.out.println("-------------------------------------");
        }
        else
            System.out.println("La lista de clientes de la base de datos esta vacia.");
    }

    public static Cliente idToCliente(int id){
        for(Cliente cliente : ClienteDAO.getAll()){
            if(cliente.getID() == id) return cliente;
        }
        return null;
    }

    public static void delCliente(){
        System.out.println("Introduce el ID del cliente que quieres eliminar.");
        int id = scanner.nextInt();

        Cliente toDelete = idToCliente(id);
        if(toDelete != null) ClienteDAO.delete(toDelete);
        else
            System.out.println("No hay ningun cliente con ese ID en la base de datos.");
    }

    public static void editCliente(){
        System.out.println("Introduce el ID del cliente que quieres editar.");
        int id = scanner.nextInt();

        if(idToCliente(id) != null)
            idToCliente(id).actualizarDatos();
        else
            System.out.println("El ID introducido no corresponde a ningun cliente. Volviendo al menu de clientes...");
    }

    public static void describeCliente(){
        System.out.println("Introduce el ID del cliente cuya informacion quieres ver.");
        int id = scanner.nextInt();

        if(idToCliente(id) != null)
            idToCliente(id).details();
        else
            System.out.println("El ID introducido no corresponde a ningun cliente. Volviendo al menu de clientes...");
    }
}
