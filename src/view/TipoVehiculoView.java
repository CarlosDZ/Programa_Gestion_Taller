package view;

import java.util.ArrayList;
import model.TipoVehiculo;

public class TipoVehiculoView {
    public static void quickGeneralView(ArrayList<TipoVehiculo> tiposVehiculos) {
        for (TipoVehiculo tipoVehiculo : tiposVehiculos) {
            System.out.println(tipoVehiculo.getId() + "        " + tipoVehiculo.getName());
        }
    }
}