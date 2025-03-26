
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
                case 2 -> { menuVehiculos(); }
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
}
