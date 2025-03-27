import java.util.ArrayList;

public class ClienteView {
    public static void quickGeneralView(ArrayList<Cliente> clientes){
        for(Cliente cliente : clientes){
            System.out.println(""+cliente.getID()+"        "+cliente.getName()+"        "+cliente.getPhone());
        }
    }
}
