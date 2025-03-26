
import java.util.Scanner;


public class App {
    
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al programa de gestion de " + Taller.getName());

        int main_menu_option;
        do { 
            System.out.println("Que quieres hacer?\n1 - Gestionar Clientes\n2 - Gestionar Vehiculos\n3 - Gestionar Citas\n4 - Gestion de Inventario\n5 - Gestion de Pedidos\n6 - Gestion de Proveedores\n7 - Gestion de Servicios\n8 - Salir");
            main_menu_option = scanner.nextInt();

            switch (main_menu_option) {
                case 1 -> {
                    //menuclientes
                }
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

}
