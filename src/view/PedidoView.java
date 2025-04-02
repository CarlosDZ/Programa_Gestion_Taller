package view;

import Main.Taller;
import java.util.ArrayList;
import model.Pedido;

public class PedidoView {
    public static void quickGeneralView(ArrayList<Pedido> pedidos){
        for(Pedido pedido : pedidos){
            System.out.println("ID: " + pedido.getId() + " ID Proveedor: " + pedido.getId_proveedor() + " Estado: " + (pedido.isCompleated() ? "Completado" : "Pendiente"));
        }
    }
    public static void viewPendientes(ArrayList<Pedido> pedidos){
        for(Pedido pedido : pedidos){
            if(!pedido.isCompleated()){
                System.out.println("ID: " + pedido.getId() + " ID Proveedor: " + pedido.getId_proveedor() + " Nombre proveedor: " + Taller.idToProveedor(pedido.getId_proveedor()).getNombre());
            }
        }
    }
    public static void viewCompletados(ArrayList<Pedido> pedidos){
        for(Pedido pedido : pedidos){
            if(pedido.isCompleated()){
                System.out.println("ID: " + pedido.getId() + " ID Proveedor: " + pedido.getId_proveedor() + " Nombre proveedor: " + Taller.idToProveedor(pedido.getId_proveedor()).getNombre());
            }
        }
    }
}
