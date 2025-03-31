package dao;

import java.sql.*;
import java.util.ArrayList;
import model.TipoVehiculo;

public class TipoVehiculoDAO {
    public static void insert(TipoVehiculo tipoVehiculo) {
        Connection conexion = ConexionDB.connectDB();

        if (conexion != null) {
            String query = "INSERT INTO tipos_vehiculos (name) VALUES (?)";
            try (PreparedStatement statement = conexion.prepareStatement(query)) {
                statement.setString(1, tipoVehiculo.getName());

                statement.executeUpdate();

                System.out.println("Tipo de vehiculo agregado exitosamente a la base de datos");

            } catch (SQLException e) {
                System.err.println("Error al agregar el tipo de vehiculo a la base de datos: " + e.getMessage());
            }
        }
    }

    public static ArrayList<TipoVehiculo> getAll() {
        ArrayList<TipoVehiculo> tiposVehiculos = new ArrayList<>();
        Connection conexion = ConexionDB.connectDB();

        if (conexion != null) {
            String query = "SELECT * FROM tipos_vehiculos";
            try (Statement statement = conexion.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {

                    TipoVehiculo tipoVehiculo = new TipoVehiculo(null);
                while (resultSet.next()) {
                    tipoVehiculo.setId(resultSet.getInt("id"));
                    tipoVehiculo.setName(resultSet.getString("name"));

                    tiposVehiculos.add(tipoVehiculo);
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener los tipos de vehiculos: " + e.getMessage());
            }
        }

        return tiposVehiculos;
    }

    public static void delete(TipoVehiculo tipoVehiculo) {
        int id = tipoVehiculo.getId();
        Connection conexion = ConexionDB.connectDB();

        if (conexion != null) {
            String query = "DELETE FROM tipos_vehiculos WHERE id = ?";
            try (PreparedStatement statement = conexion.prepareStatement(query)) {
                statement.setInt(1, id);

                statement.executeUpdate();

                System.out.println("Tipo de vehiculo eliminado exitosamente de la base de datos");

            } catch (SQLException e) {
                System.err.println("Error al eliminar el tipo de vehiculo de la base de datos: " + e.getMessage());
            }
        }
    }
}
