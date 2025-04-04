package view;

import model.TipoTransaccion;
import java.util.ArrayList;

public class TipoTransaccionView {
    public static void quickGeneralView(ArrayList<TipoTransaccion> tiposTransaccion){
        for(TipoTransaccion tipoTransaccion : tiposTransaccion){
            System.out.println(tipoTransaccion.getId() + " - " + tipoTransaccion.getNombre());
        }
    }
}
