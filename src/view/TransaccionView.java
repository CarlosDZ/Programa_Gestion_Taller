package view;
import java.util.ArrayList;
import model.Transaccion;

public class TransaccionView {
    public static void viewHistorial(ArrayList<Transaccion> historial){
        int longitudConcepto;
        for(Transaccion transaccion : historial){
             longitudConcepto = transaccion.getConcepto().length();
             String newConcepto;
            if(longitudConcepto > 25)
                newConcepto = transaccion.getConcepto().substring(0, 25);
            else
                newConcepto = transaccion.getConcepto();

            System.out.println("("+transaccion.getId()+")   "+newConcepto+"   "+transaccion.getCantidad()+"€   "+transaccion.getFecha());
        }
    }
}
