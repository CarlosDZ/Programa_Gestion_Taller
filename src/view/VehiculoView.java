package view;

import java.util.ArrayList;
import model.Cliente;
import model.Vehiculo;

public class VehiculoView {
    public static void quickGeneralView(ArrayList<Vehiculo> vehiculos) {
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo.getId() + "  Modelo: " + vehiculo.getModel() + ", Año: " + vehiculo.getYear() + ", Placa: " + vehiculo.getLicense_plate());
        }
    }

    public static void vehiclesFromOWner(ArrayList<Vehiculo> vehiculos, Cliente cliente) {
        int id_cliente = cliente.getID();
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getId_owner() == id_cliente) {
                System.out.println(vehiculo.getId() + "  Modelo: " + vehiculo.getModel() + ", Año: " + vehiculo.getYear() + ", Placa: " + vehiculo.getLicense_plate());
            }
        }
    }
}