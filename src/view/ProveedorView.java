package view;

import java.util.ArrayList;

import model.Proveedor;

public class ProveedorView {
    public static void quickGeneralView(ArrayList<Proveedor> proveedores){
        for(Proveedor proveedor : proveedores){
            System.out.println(proveedor.getId()+"        "+proveedor.getNombre()+"        "+proveedor.getMail());
        }
    }
}
