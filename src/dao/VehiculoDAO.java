package dao;

import java.sql.*;
import java.util.ArrayList;
import model.Cliente;
import model.Vehiculo;

public class VehiculoDAO {
    public static ArrayList<Vehiculo> getAll(){
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        Connection conexion = ConexionDB.connectDB();
        if (conexion != null) {
            
            String query = "SELECT * FROM vehiculos"; 
            try (Statement statement = conexion.createStatement(); ResultSet results = statement.executeQuery(query)) {
                Vehiculo x;
                int id;
                int id_brand;
                String model;
                int year;
                String license_plate;
                int client_id;
                int type;

                    while (results.next()) {
                        id = results.getInt("id");
                        id_brand = results.getInt("id_brand");
                        model = results.getString("model");
                        year = results.getInt("year");
                        license_plate = results.getString("license_plate");
                        client_id = results.getInt("client_id");
                        type = results.getInt("id_type");
                        x = new Vehiculo(model, year, license_plate, id_brand, type);
                        x.setId(id);
                        x.setId_owner(client_id);
                        vehiculos.add(x);
                    }
                    return vehiculos;
                    
            } catch (SQLException e) {
                System.out.println("Error al obtener la lista de vehiculos: " + e.getMessage());
            }
        }
        return null;
    }

    public static void insert(Vehiculo vehiculo){
        Connection conexion = ConexionDB.connectDB();
        if (conexion != null) {
            String query = "INSERT INTO vehiculos (model, year, license_plate, id_brand, client_id, id_type) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = conexion.prepareStatement(query)) {
                statement.setString(1, vehiculo.getModel());
                statement.setInt(2, vehiculo.getYear());
                statement.setString(3, vehiculo.getLicense_plate());
                statement.setInt(4, vehiculo.getId_brand());
                statement.setInt(5, vehiculo.getId_owner());
                statement.setInt(6, vehiculo.getVehicle_type());

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Vehiculo insertado correctamente.");
                }
            } catch (SQLException e) {
                System.out.println("Error al insertar el vehiculo: " + e.getMessage());
            }
        }
    }

    public static void delete(Vehiculo vehiculo){
        Connection conexion = ConexionDB.connectDB();
        if (conexion != null) {
            String query = "DELETE FROM vehiculos WHERE id = ?";
            try (PreparedStatement statement = conexion.prepareStatement(query)) {
                statement.setInt(1, vehiculo.getId());
                int rowsDeleted = statement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Vehiculo eliminado correctamente.");
                }
            } catch (SQLException e) {
                System.out.println("Error al eliminar el vehiculo: " + e.getMessage());
            }
        }
    }

    //Actualizar atributos
    public static void actualizarOwner(Vehiculo vehiculo, Cliente cliente){
        Connection conexion = ConexionDB.connectDB();
        if (conexion != null) {
            String query = "UPDATE vehiculos SET client_id = ? WHERE id = ?";
            try (PreparedStatement statement = conexion.prepareStatement(query)) {
                statement.setInt(1, cliente.getID());
                statement.setInt(2, vehiculo.getId());
                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Dueño cambiado correctamente correctamente.");
                }
            } catch (SQLException e) {
                System.out.println("Error al cambiar de dueño el vehiculo: " + e.getMessage());
            }
        }
    }

}
