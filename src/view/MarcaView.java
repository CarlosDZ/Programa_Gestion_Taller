package view;

import java.util.ArrayList;
import model.Marca;

public class MarcaView {
    public static void quickGeneralView(ArrayList<Marca> marcas){
        for(Marca marca : marcas){
            System.out.println(marca.getId()+"        "+marca.getName());
        }
    }
}