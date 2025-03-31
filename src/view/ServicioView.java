package view;

import java.util.ArrayList;
import model.Servicio;

public class ServicioView {
    public static void quickGeneralView(ArrayList<Servicio> servicios){
        for (Servicio servicio : servicios) {
            System.out.println(servicio.getId() + "      " + servicio.getName() + "      " + servicio.getPrice()+" €");
        }
    }
}
