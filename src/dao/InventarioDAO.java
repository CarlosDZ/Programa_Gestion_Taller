package dao;

import java.sql.*;
import java.util.ArrayList;
import model.Inventario;
import model.Pedido;

public class InventarioDAO {
    public static ArrayList<Inventario> getInventario(){
        ArrayList<Inventario> inventario = new ArrayList<>();
        Connection conexion = ConexionDB.connectDB();

        if (conexion != null) {
            String query = "SELECT * FROM inventario";
            try (Statement statement = conexion.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {

                while (resultSet.next()) {

                    inventario.add(new Inventario(
                            resultSet.getInt("id_objeto"),
                            resultSet.getInt("cantidad")
                    ));
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener el inventario: " + e.getMessage());
            }
        }

        return inventario;
    }

    public static void insert(Inventario inventario) {
        Connection conexion = ConexionDB.connectDB();

        if (conexion != null) {
            String query = "INSERT INTO inventario (id_objeto, cantidad) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setInt(1, inventario.getId_objeto());
                preparedStatement.setInt(2, inventario.getCantidad());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al insertar en el inventario: " + e.getMessage());
            }
        }
    }
    public static void delete(Inventario inventario) {
        Connection conexion = ConexionDB.connectDB();

        if (conexion != null) {
            String query = "DELETE FROM inventario WHERE id_objeto = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setInt(1, inventario.getId_objeto());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al eliminar del inventario: " + e.getMessage());
            }
        }
    }
    public static void changeQuantity(Inventario inventario, int newQuantity){
        Connection conexion = ConexionDB.connectDB();

        if (conexion != null) {
            String query = "UPDATE inventario SET cantidad = ? WHERE id_objeto = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setInt(1, newQuantity);
                preparedStatement.setInt(2, inventario.getId_objeto());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al actualizar la cantidad en el inventario: " + e.getMessage());
            }
        }
    }

    public static void addQuantity(Inventario inventario, int quantity){
        Connection conexion = ConexionDB.connectDB();

        if (conexion != null) {
            String query = "UPDATE inventario SET cantidad = ? WHERE id_objeto = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setInt(1, inventario.getCantidad() + quantity);
                preparedStatement.setInt(2, inventario.getId_objeto());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error al agregar cantidad en el inventario: " + e.getMessage());
            }
        }
    }

    public static void addCantidadesPedido(Pedido pedido){
        ArrayList<Inventario> objetos_pedido = pedido.getContenido();
        for (Inventario objeto : objetos_pedido) {
            InventarioDAO.addQuantity(objeto, objeto.getCantidad());
        }
    }

    public static void removeCantidadesPedido(Pedido pedido){
        ArrayList<Inventario> objetos_pedido = pedido.getContenido();
        for (Inventario objeto : objetos_pedido) {
            InventarioDAO.addQuantity(objeto, -objeto.getCantidad());
        }
    }

    public static void autoRemoveCantidadesPedido(Pedido pedido){
        ArrayList<Inventario> objetos_pedido = pedido.getContenido();
        for (Inventario objeto : objetos_pedido) {

            if(getCantidadEnInventario(objeto) - objeto.getCantidad() >= 0){
            InventarioDAO.addQuantity(objeto, -objeto.getCantidad());
            }
            else{
                System.out.println("AVISO: La cantidad del objeto " + objeto.getId_objeto() + " iba a volverse menor a 0, por lo que se ha cambiado a 0. Se ruega revision manual del inventario.");
                InventarioDAO.changeQuantity(objeto, 0);
            }
        }
    }

    public static int getCantidadEnInventario(Inventario inventario){
        Connection conexion = ConexionDB.connectDB();
        int cantidad = 0;

        if (conexion != null) {
            String query = "SELECT cantidad FROM inventario WHERE id_objeto = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setInt(1, inventario.getId_objeto());
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    cantidad = resultSet.getInt("cantidad");
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener la cantidad del objeto: " + e.getMessage());
            }
        }

        return cantidad;
    }
}
