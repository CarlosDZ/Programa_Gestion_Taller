package Main;

import dao.ConexionDB;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class App {
    static Scanner scanner = new Scanner(System.in);

    static Connection conexion_sql = ConexionDB.connectDB();
    public static void main(String[] args) throws Exception {

        System.out.println("Bienvenido al programa de gestion de " + Taller.getName());
        if(App.conexion_sql == null) System.err.println("Error en a conexion a la base de datos. Saliendo del programa.");
        else{
            int main_menu_option;
            do { 
                System.out.println("Que quieres hacer?\n1 - Gestionar Clientes\n2 - Gestionar Vehiculos\n3 - Gestionar Citas\n4 - Gestion de Inventario\n5 - Gestion contabilidad\n6 - Salir");
                main_menu_option = scanner.nextInt();
    
                switch (main_menu_option) {
                    case 1 -> { menuClientes(); }
                    case 2 -> { menuVehiculos(); }
                    case 3 -> { menuCitas(); }
                    case 4 -> { menuInventario(); }
                    case 5 -> { menuContabilidad(); }
                    case 6 -> { System.out.println("Saliendo del programa!"); }
    
                    default -> System.out.println("El numero no esta en el rango especificado, introduce un numero entre 1 y 6.");
                }
            } while (main_menu_option != 6);
        }
    }

    public static void menuClientes(){
        int menu_clientes_opcion;

        do { 
            System.out.println("Que quieres hacer?\n1 - Ver todos los clientes\n2 - Nuevo cliente\n3 - Borrar cliente\n4 - Editar cliente\n5 - Vincular vehiculo a cliente\n6 - Ver informacion detallada de un cliente\n7 - Salir del menu de clientes");
            menu_clientes_opcion = scanner.nextInt();

            switch (menu_clientes_opcion) {
                case 1 -> { Taller.showAllClientes(); }
                case 2 -> {
                    Taller.newCliente();
                }
                case 3 -> { Taller.delCliente(); }
                case 4 -> { Taller.editCliente(); }
                case 5 -> {
                    //Vehiculo.linkToCliente()
                }
                case 6 -> {
                    //Cliente.details()
                }
                case 7 -> { System.out.println("Saliendo del menu de clientes..."); }

                default -> System.out.println("El numero no esta en el rango especificado, introduce un numero entre 1 y 7.");
            }

        } while (menu_clientes_opcion != 7);
    }

    public static void menuVehiculos(){
        int menu_vehiculos_opcion;

        do { 
            System.out.println("Que quieres hacer?\n1 - Ver todos los vehiculos\n2 - Nuevo vehiculo\n3 - Borrar vehiculo\n 4 - Editar vehiculo\n5 - Vincular vehiculo a cliente\n6 - Ver informacion detallada de un vehiculo\n7 - Gestionar tipos de vehiculos\n8 - Gestionar fabricantes\n9 - Salir del menu de vehiculos");
            menu_vehiculos_opcion = scanner.nextInt();

            switch (menu_vehiculos_opcion) {
                case 1 -> {
                    //Taller.printAllVehiculos()
                }
                case 2 -> {
                    //Taller.newVehiculo()
                }
                case 3 -> {
                    //Taller.delVehiculo()
                }
                case 4 -> {
                    //Vehiculo.edit()
                }
                case 5 -> {
                    //Vehiculo.linkToCliente()
                }
                case 6 -> {
                    //Vehiculo.details()
                }
                case 7 -> { menuTiposVehiculo(); }

                case 8 -> { menuFabricantes(); }

                case 9 -> { System.out.println("Saliendo del menu de vehiculos..."); }

                default -> System.out.println("El numero no esta en el rango especificado, introduce un numero entre 1 y 9.");
            }

        } while (menu_vehiculos_opcion != 9);
    }

    public static void menuTiposVehiculo(){
        int menu_tipos_vehiculo_opcion;

        do { 
            System.out.println("Que quieres hacer?\n1 - Ver todos los tipos de vehiculo\n2 - Nuevo tipo de vehiculo\n3 - Borrar tipo de vehiculo\n 4 - Editar tipo de vehiculo\n5 - Ver informacion detallada de un tipo de vehiculo\n6 - Salir del menu de tipos de vehiculo");
            menu_tipos_vehiculo_opcion = scanner.nextInt();

            switch (menu_tipos_vehiculo_opcion) {
                case 1 -> {
                    //Taller.printAllTiposVehiculo()
                }
                case 2 -> {
                    //Taller.newTipoVehiculo()
                }
                case 3 -> {
                    //Taller.delTipoVehiculo()
                }
                case 4 -> {
                    //TipoVehiculo.edit()
                }
                case 5 -> {
                    //TipoVehiculo.details()
                }
                case 6 -> {
                    System.out.println("Saliendo del menu de tipos de vehiculo...");
                }

                default -> System.out.println("El numero no esta en el rango especificado, introduce un numero entre 1 y 6.");
            }

        } while (menu_tipos_vehiculo_opcion != 6);
    }

    public static void menuFabricantes(){
        int menu_fabricantes_opcion;

        do { 
            System.out.println("Que quieres hacer?\n1 - Ver todos los fabricantes\n2 - Nuevo fabricante\n3 - Borrar fabricante\n4 - Salir del menu de fabricantes");
            menu_fabricantes_opcion = scanner.nextInt();

            switch (menu_fabricantes_opcion) {
                case 1 -> {
                    //Taller.printAllFabricantes()
                }
                case 2 -> {
                    //Taller.newFabricante()
                }
                case 3 -> {
                    //Taller.delFabricante()
                }
                case 4 -> {
                    System.out.println("Saliendo del menu de fabricantes...");
                }

                default -> System.out.println("El numero no esta en el rango especificado, introduce un numero entre 1 y 4.");
            }

        } while (menu_fabricantes_opcion != 4);
    }

    public static void menuCitas(){
        int menu_citas_opcion;

        do { 
            System.out.println("Que quieres hacer?\n1 - Ver todas las citas\n2 - Nueva cita\n3 - Borrar cita\n4 - Editar cita\n5 - Gestionar servicios\n6 - Salir del menu de citas");
            menu_citas_opcion = scanner.nextInt();

            switch (menu_citas_opcion) {
                case 1 -> {
                    //Taller.printAllCitas()
                }
                case 2 -> {
                    //Taller.newCita()
                }
                case 3 -> {
                    //Taller.delCita()
                }
                case 4 -> {
                    //Cita.edit()
                }
                case 5 -> { menuServicios(); }
                case 6 -> { System.out.println("Saliendo del menu de citas..."); }
                default -> System.out.println("El numero no esta en el rango especificado, introduce un numero entre 1 y 6.");
            }

        } while (menu_citas_opcion != 6);
    }

    public static void menuServicios(){
        int menu_servicios_opcion;

        do { 
            System.out.println("Que quieres hacer?\n1 - Ver todos los servicios\n2 - Nuevo servicio\n3 - Borrar servicio\n4 - Editar servicio\n5 - Informacion detallada de un servicio\n6 - Salir del menu de servicios");
            menu_servicios_opcion = scanner.nextInt();

            switch (menu_servicios_opcion) {
                case 1 -> {
                    //Taller.printAllServicios()
                }
                case 2 -> {
                    //Taller.newServicio()
                }
                case 3 -> {
                    //Taller.delServicio()
                }
                case 4 -> {
                    //Servicio.edit()
                }
                case 5 -> {
                    //Servicio.details()
                }
                case 6 -> {
                    System.out.println("Saliendo del menu de servicios...");
                }

                default -> System.out.println("El numero no esta en el rango especificado, introduce un numero entre 1 y 6.");
            }

        } while (menu_servicios_opcion != 6);
    }

    public static void menuInventario(){
        int menu_invetario_opcion;

        do { 
            System.out.println("Que quieres hacer?\n1 - Ver inventario\n2 - Modificar cantidad de objeto\n3 - Gestion de objetos \n4 - Gestion de pedidos\n5 - Busqueda por ID\n6 - Salir del menu de inventario");
            menu_invetario_opcion = scanner.nextInt();

            switch (menu_invetario_opcion) {
                case 1 -> {
                    //Inventario.printAll()
                }
                case 2 -> {
                    //Inventario.changeQuantity();
                }
                case 3 -> { menuObjetos(); }
                case 4 -> {
                    //menuPedidos()
                }
                case 5 -> {
                    //Inventario.showDetails();
                }
                case 6 -> { System.out.println("Saliendo del menu de inventario..."); }

                default -> System.out.println("El numero no esta en el rango especificado, introduce un numero entre 1 y 6.");
            }

        } while (menu_invetario_opcion != 6);
    }

    public static void menuObjetos(){
        int menu_objetos_opcion;

        do { 
            System.out.println("Que quieres hacer?\n1 - Ver objetos\n2 - Nuevo objeto\n3 - Borrar objeto \n4 - Editar Objetos\n5 - Ver informacion detallada de un objeto\n6 - Salir del menu de objetos");
            menu_objetos_opcion = scanner.nextInt();

            switch (menu_objetos_opcion) {
                case 1 -> {
                    //Taller.printAllObjetos()
                }
                case 2 -> {
                    //Taller.addObjeto();
                }
                case 3 -> {
                    //Taller.delObjeto();
                }
                case 4 -> {
                    //Objeto.edit()
                }
                case 5 -> {
                    //Objeto.details();
                }
                case 6 -> { System.out.println("Saliendo del menu de objetos..."); }

                default -> System.out.println("El numero no esta en el rango especificado, introduce un numero entre 1 y 6.");
            }

        } while (menu_objetos_opcion != 6);
    }

    public static void menuPedidos(){
        int menu_pedidos_opcion;

        do { 
            System.out.println("Que quieres hacer?\n1 - Ver pedidos por llegar\n2 - Nuevo pedido\n3 - Borrar pedido \n4 - Editar pedido\n5 - Marcar llegada de pedido\n6 - Ver pedidos completados\n7 - Gestion de proveedores\n8 - Salir del menu de objetos");
            menu_pedidos_opcion = scanner.nextInt();

            switch (menu_pedidos_opcion) {
                case 1 -> {
                    //Taller.printAllObjetos()
                }
                case 2 -> {
                    //Taller.addObjeto();
                }
                case 3 -> {
                    //Taller.delObjeto();
                }
                case 4 -> {
                    //Objeto.edit()
                }
                case 5 -> {
                    //Objeto.details();
                }
                case 6 -> {
                    //Objeto.details();
                }
                case 7 -> { menuProveedores(); }
                case 8 -> { System.out.println("Saliendo del menu de pedidos..."); }

                default -> System.out.println("El numero no esta en el rango especificado, introduce un numero entre 1 y 8.");
            }

        } while (menu_pedidos_opcion != 8);
    }

    public static void menuProveedores(){
        int menu_proveedores_opcion;

        do { 
            System.out.println("Que quieres hacer?\n1 - Ver proveedores\n2 - Nuevo proveedor\n3 - Borrar proveedor \n4 - Editar proveedor\n5 - Ver detalles de proveedor\n6 - Salir del menu de proveedores");
            menu_proveedores_opcion = scanner.nextInt();

            switch (menu_proveedores_opcion) {
                case 1 -> {
                    //Taller.printAllProveedores()
                }
                case 2 -> {
                    //Taller.addProveedor();
                }
                case 3 -> {
                    //Taller.delProveedor();
                }
                case 4 -> {
                    //Proveedor.edit()
                }
                case 5 -> {
                    //Proveedor.details();
                }
                case 6 -> { System.out.println("Saliendo del menu de proveedores..."); }
                default -> System.out.println("El numero no esta en el rango especificado, introduce un numero entre 1 y 6.");
            }
        } while (menu_proveedores_opcion != 6);
    }

    public static void menuContabilidad(){
        int menu_contabilidad_opcion;

        do { 
            System.out.println("Que quieres hacer?\n1 - Ver balance actual\n2 - Ver historial de transacciones\n3 - Nueva transaccion\n4 - Detalles de una transaccion\n5 - Cambiar balance actual (No recomendado)\n6 - Borrar transaccion (No recomendado)\n7 - Editar transaccion (No recomendado)\n8 - Salir del menu de contabilidad");
            menu_contabilidad_opcion = scanner.nextInt();

            switch (menu_contabilidad_opcion) {
                case 1 -> { Taller.getCurMoney(); }
                case 2 -> {
                    //Taller.printTransactionHistory();
                }
                case 3 -> {
                    //Taller.addTransaction();
                }
                case 4 -> {
                    //Transaction.details()
                }
                case 5 -> {
                    //Taller.balanceChange();
                }
                case 6 -> {
                    //Proveedor.delTransaction();
                }
                case 7 -> {
                    //Transaction.changeDetails();
                }
                case 8 -> { System.out.println("Saliendo del menu de contabilidad..."); }
                default -> System.out.println("El numero no esta en el rango especificado, introduce un numero entre 1 y 8.");
            }
        } while (menu_contabilidad_opcion != 8);
    }

    public static String getEnvValue(String key){
        String PATH = ".env";

        try(BufferedReader reader = new BufferedReader(new FileReader(PATH))){
            Pattern pattern = Pattern.compile(key+" = \"([A-Za-z -/._:0-9]*)\"");
            String valueToReturn;

            String line;
            while((line = reader.readLine()) != null){
                Matcher matcher = pattern.matcher(line);
                if(matcher.find()){
                    valueToReturn = matcher.group(1);
                    return valueToReturn;
                }
            }
        }catch(Exception ex){
            System.err.println("Error al intentar acceder a .env");
        }
        return null;
    }

    
}
