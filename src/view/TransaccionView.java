package view;
import java.util.ArrayList;
import model.Transaccion;

public class TransaccionView {
    public static void viewHistorial(ArrayList<Transaccion> historial){
        for(Transaccion transaccion : historial){
            System.out.println("("+transaccion.getId()+")   "+transaccion.getConcepto().substring(0, 25)+"   "+transaccion.getCantidad()+"€   "+transaccion.getFecha());
        }
    }
}
