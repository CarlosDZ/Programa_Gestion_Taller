package view;

import Main.Taller;
import java.util.ArrayList;
import model.Inventario;

public class InventarioView {
    public static void showInventarioNot0(ArrayList<Inventario> inventario){
        for(Inventario item : inventario){
            if(item.getCantidad() != 0)
                System.out.println("(" + item.getId_objeto() +") "+Taller.idToObjeto(item.getId_objeto()).getNombre() + " : " + item.getCantidad());
        }
    }
    public static void showAllInventario(ArrayList<Inventario> inventario){
        for(Inventario item : inventario){
            System.out.println("(" + item.getId_objeto() +") "+Taller.idToObjeto(item.getId_objeto()).getNombre() + " : " + item.getCantidad());
        }
    }
}
