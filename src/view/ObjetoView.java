package view;

import java.util.ArrayList;
import model.Objeto;

public class ObjetoView {
    public static void quickGeneralView(ArrayList<Objeto> objetos){
        for(Objeto objeto : objetos){
            System.out.println("ID: " + objeto.getId() + "   Nombre: " + objeto.getNombre());
        }
    }
}