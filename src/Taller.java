import java.util.Scanner;
import javax.swing.text.View;

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
        System.out.println("-------------------------------------");
        ClienteView.quickGeneralView(ClienteDAO.getAll());
        System.out.println("-------------------------------------");
    }
}
