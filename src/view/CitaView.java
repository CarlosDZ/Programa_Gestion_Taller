package view;

import java.util.ArrayList;
import model.Cita;

public class CitaView {
    public static void quickGeneralView(ArrayList<Cita> citas) {
        for(Cita cita : citas) {
            System.out.println("ID: " + cita.getId() + ", Vehicle ID: " + cita.getId_vehiculo() + ", Date: " + cita.getFecha() + ", Service ID: " + cita.getId_servicio() + ", Compleated: " + cita.isCompleated());
        }
    }
    
    public static void showRealizados(ArrayList<Cita> citas) {
        for(Cita cita : citas) {
            if(cita.isCompleated()) 
                System.out.println("ID: " + cita.getId() + ", Vehicle ID: " + cita.getId_vehiculo() + ", Date: " + cita.getFecha() + ", Service ID: " + cita.getId_servicio());
        }
    }

    public static void showNoRealizados(ArrayList<Cita> citas) {
        for(Cita cita : citas) {
            if(!cita.isCompleated()) 
                System.out.println("ID: " + cita.getId() + ", Vehicle ID: " + cita.getId_vehiculo() + ", Date: " + cita.getFecha() + ", Service ID: " + cita.getId_servicio());
        }
    }
}
