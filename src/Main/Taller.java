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

    public static void showAllMarcas(){
        ArrayList<Marca> lista_marca = MarcaDAO.getAll();
        if(!lista_marca.isEmpty()){
            System.out.println("-------------------------------------");
            MarcaView.quickGeneralView(lista_marca);
            System.out.println("-------------------------------------");
        }
        else
            System.out.println("La lista de marcas de la base de datos esta vacia.");
    }
    public static void newMarca(){
        System.out.println("Introduce el nombre que quieres darle a tu nueva marca.");
        String name = scanner.nextLine();

        MarcaDAO.insert(new Marca(name));
    }
    public static void delMarca(){
        System.out.println("Introduce el ID de la marca que quieres eliminar.");
        int id = scanner.nextInt();

        Marca toDelete = idToMarca(id);
        if(toDelete != null) MarcaDAO.delete(toDelete);
        else
            System.out.println("No hay ninguna marca con ese ID en la base de datos.");
    }
    public static Marca idToMarca(int id){
        for(Marca marca : MarcaDAO.getAll()){
            if(marca.getId() == id) return marca;
        }
        return null;
    }

    public static TipoVehiculo idToTipoVehiculo(int id){
        for(TipoVehiculo tipoVehiculo : TipoVehiculoDAO.getAll()){
            if(tipoVehiculo.getId() == id) return tipoVehiculo;
        }
        return null;
    }

    public static void showAllTiposVehiculos(){
        ArrayList<TipoVehiculo> lista_tipoVehiculo = TipoVehiculoDAO.getAll();
        if(!lista_tipoVehiculo.isEmpty()){
            System.out.println("-------------------------------------");
            TipoVehiculoView.quickGeneralView(lista_tipoVehiculo);
            System.out.println("-------------------------------------");
        }
        else
            System.out.println("La lista de tipos de vehiculos de la base de datos esta vacia.");
    }
    public static void newTipoVehiculo(){
        System.out.println("Introduce el nombre que quieres darle a tu nuevo tipo de vehiculo.");
        String name = scanner.nextLine();

        TipoVehiculoDAO.insert(new TipoVehiculo(name));
    }
    public static void delTipoVehiculo(){
        System.out.println("Introduce el ID del tipo de vehiculo que quieres eliminar.");
        int id = scanner.nextInt();

        TipoVehiculo toDelete = idToTipoVehiculo(id);
        if(toDelete != null) TipoVehiculoDAO.delete(toDelete);
        else
            System.out.println("No hay ningun tipo de vehiculo con ese ID en la base de datos.");
    }

    public static void showAllVehiculos(){
        ArrayList<Vehiculo> lista_vehiculos = VehiculoDAO.getAll();
        if(!lista_vehiculos.isEmpty()){
            System.out.println("-------------------------------------");
            VehiculoView.quickGeneralView(lista_vehiculos);
            System.out.println("-------------------------------------");
        }
        else
            System.out.println("La lista de vehiculos de la base de datos esta vacia.");
    }

    public static void newVehiculo(){
        System.out.println("Introduce el modelo del vehiculo.");
        String model = scanner.nextLine();

        System.out.println("Introduce el año del vehiculo.");
        int year = scanner.nextInt();

        System.out.println("Introduce la matricula del vehiculo.");
        String license_plate = scanner.next();

        System.out.println("Estas son las marcas disponibles: ");
        showAllMarcas();
        Marca marca;
        do { 
            System.out.println("Introduce el ID de la marca del vehiculo.");
            marca = idToMarca(scanner.nextInt());
            if (marca == null) {
                System.out.println("El ID introducido no es correcto, prueba de nuevo.");
            } else {
                System.out.println("Marca seleccionada: " + marca.getName());
            }
        } while (marca == null);
        

        System.out.println("Estos son los tipos de vehiculo disponibles: ");
        showAllTiposVehiculos();
        TipoVehiculo tipoVehiculo;
        do { 
            System.out.println("Introduce el ID del tipo del vehiculo.");
            tipoVehiculo = idToTipoVehiculo(scanner.nextInt());
            if (tipoVehiculo == null) {
                System.out.println("El ID introducido no es correcto, prueba de nuevo.");
            } else {
                System.out.println("Tipo de vehiculo seleccionado: " + marca.getName());
            }
        } while (tipoVehiculo == null);

        VehiculoDAO.insert(new Vehiculo(model, year, license_plate, marca.getId(), tipoVehiculo.getId()));
    }

    public static void delVehiculo(){
        System.out.println("Introduce el ID del vehiculo que quieres eliminar.");
        int id = scanner.nextInt();

        Vehiculo toDelete = idToVehiculo(id);
        if(toDelete != null) VehiculoDAO.delete(toDelete);
        else
            System.out.println("No hay ningun vehiculo con ese ID en la base de datos.");
    }
    public static Vehiculo idToVehiculo(int id){
        for(Vehiculo vehiculo : VehiculoDAO.getAll()){
            if(vehiculo.getId() == id) return vehiculo;
        }
        return null;
    }

    public static void linkVehiculoToCliente(){
        System.out.println("Estos son los vehiculos disponibles: ");
        showAllVehiculos();

        Vehiculo toLink;
        System.out.println("Introduce el ID del vehiculo que quieres vincular a un cliente.");
        do { 
            toLink = idToVehiculo(id = scanner.nextInt());
            if (toLink == null) {
                System.out.println("El ID introducido no es correcto, prueba de nuevo.");
            } else {
                System.out.println("Vehiculo seleccionado: " + toLink.getLicense_plate());
            }
        } while (toLink == null);

        System.out.println("Estos son los clientes disponibles: ");
        showAllClientes();

        Cliente owner;
        System.out.println("Introduce el ID del cliente al que quieres vincular el vehiculo.");
        do { 
            owner = idToCliente(scanner.nextInt());
            if (owner == null) {
                System.out.println("El ID introducido no es correcto, prueba de nuevo.");
            } else {
                System.out.println("Cliente seleccionado: " + owner.getName());
            }
        } while (owner == null);

        VehiculoDAO.actualizarOwner(toLink, owner);
    }

    public static void describeVehiculo(){
        System.out.println("Introduce el ID del vehiculo cuya informacion quieres ver.");
        Vehiculo toDescribe;
        do { 
            toDescribe = idToVehiculo(scanner.nextInt());
                if (toDescribe != null) {
                    System.out.println("Vehiculo seleccionado, mostrando detalles...");
                    toDescribe.details();
                }
                else
                    System.out.println("El ID introducido no corresponde a ningun vehiculo. Vuelve a intentarlo.");
        } while (toDescribe == null);
    }
}
