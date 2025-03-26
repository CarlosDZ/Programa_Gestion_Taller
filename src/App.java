
import java.util.Scanner;


public class App {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        System.out.println("Bienvenido al programa de gestion de " + Taller.getName());

        int main_menu_option;
        do { 
            System.out.println("Que quieres hacer?\n1 - Gestionar Clientes\n2 - Gestionar Vehiculos\n3 - Gestionar Citas\n4 - Gestion de Inventario\n5 - Gestion de Pedidos\n6 - Gestion de Proveedores\n7 - Gestion de Servicios\n8 - Salir");
            main_menu_option = scanner.nextInt();

            switch (main_menu_option) {
                case 1 -> { menuClientes(); }
                case 2 -> {
                    //menuvehiculos
                }
                case 3 -> {
                    //menucitas
                }
                case 4 -> {
                    //menuinventario
                }
                case 5 -> {
                    //menupedidos
                }
                case 6 -> {
                    //menuproveedores
                }
                case 7 -> {
                    //menuservicios
                }
                case 8 -> { System.out.println("Saliendo del programa!"); }

                default -> System.out.println("El numero no esta en el rango especificado, introduce un numero entre 1 y 8.");
            }
        } while (main_menu_option != 8);

    }

    public static void menuClientes(){
        int menu_clientes_opcion;

        do { 
            System.out.println("Que quieres hacer?\n1 - Ver todos los clientes\n2 - Nuevo cliente\n3 - Borrar cliente\n 4 - Editar cliente\n5 - Vincular vehiculo a cliente\n6 - Ver informacion detallada de un cliente\n7 - Salir del menu de clientes");
            menu_clientes_opcion = scanner.nextInt();

            switch (menu_clientes_opcion) {
                case 1 -> {
                    //Taller.printAllClientes()
                }
                case 2 -> {
                    //Taller.newCliente()
                }
                case 3 -> {
                    //Taller.delCliente()
                }
                case 4 -> {
                    //Cliente.edit()
                }
                case 5 -> {
                    //Vehiculo.linkToCliente()
                }
                case 6 -> {
                    //Cliente.details()
                }
                case 7 -> {
                    System.out.println("Saliendo del menu de clientes...");
                }

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

                case 8 -> {
                    //menuFabricantes();
                }
                case 9 -> {
                    System.out.println("Saliendo del menu de vehiculos...");
                }

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

}
