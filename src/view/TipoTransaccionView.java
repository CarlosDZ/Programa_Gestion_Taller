package view;

import java.util.ArrayList;
import model.TipoTransaccion;

public class TipoTransaccionView {
    public static void quickGeneralView(ArrayList<TipoTransaccion> tiposTransaccion){
        for(TipoTransaccion tipoTransaccion : tiposTransaccion){
            if(tipoTransaccion.getId() != 1)
                System.out.println(tipoTransaccion.getId() + " - " + tipoTransaccion.getNombre());
        }
    }
}
