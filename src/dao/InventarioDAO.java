package dao;

import java.sql.*;
import java.util.ArrayList;
import model.Inventario;

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
}
