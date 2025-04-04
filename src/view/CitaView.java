package view;

import java.util.ArrayList;
import model.Cita;
import model.Transaccion;

public class CitaView {
    public static void quickGeneralView(ArrayList<Cita> citas) {
        for(Cita cita : citas) {
            System.out.println("ID: " + cita.getId() + "    ID Vehiculo: " + cita.getId_vehiculo() + "  Fecha: " + cita.getFecha() + "  ID Fecha: " + cita.getId_servicio()+ (cita.isCompleated() ? "  Completado" : "  Pendiente"));
        }
    }
    
    public static void showRealizados(ArrayList<Cita> citas) {
        for(Cita cita : citas) {
            if(cita.isCompleated()) 
                System.out.println("ID: " + cita.getId() + "    ID Vehiculo: " + cita.getId_vehiculo() + "  Fecha: " + cita.getFecha() + "  ID Fecha: " + cita.getId_servicio());
        }
    }

    public static void showNoRealizados(ArrayList<Cita> citas) {
        for(Cita cita : citas) {
            if(!cita.isCompleated()) 
            System.out.println("ID: " + cita.getId() + "    ID Vehiculo: " + cita.getId_vehiculo() + "  Fecha: " + cita.getFecha() + "  ID Fecha: " + cita.getId_servicio());
        }
    }

    public static void viewUnlinked(ArrayList<Cita> citas, ArrayList<Transaccion> transacciones){
        boolean linked;
        for(Cita cita : citas){
            linked = false;
            for(Transaccion transaccion : transacciones){
                if(transaccion.getId_tipo() == 3 && cita.getId() == transaccion.getId_variable()){
                    linked = true;
                }
            }
            if(!linked){
                System.out.println("ID: " + cita.getId() + "    ID Vehiculo: " + cita.getId_vehiculo() + "  Fecha: " + cita.getFecha() + "  ID Fecha: " + cita.getId_servicio()+ (cita.isCompleated() ? "  Completado" : "  Pendiente"));
            }
        }
    }
}
