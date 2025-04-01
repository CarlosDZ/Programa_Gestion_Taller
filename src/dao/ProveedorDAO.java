package dao;

import java.sql.*;
import java.util.ArrayList;
import model.Proveedor;

public class ProveedorDAO {
    public static void insert(Proveedor proveedor) {
        Connection conexion = ConexionDB.connectDB();

        if(conexion != null){
            String query = "INSERT INTO proveedores (name,mail) VALUES (?,?)";
            try(PreparedStatement statement = conexion.prepareStatement(query)){
                statement.setString(1, proveedor.getNombre());
                statement.setString(2, proveedor.getMail());

                statement.executeUpdate();

                System.out.println("Proveedor agregado exitosamente a la base de datos");

            }catch(SQLException e){
                System.err.println("Error al agregar el proveedor a la base de datos: "+ e.getMessage());
            }
        }
    }

    public static ArrayList<Proveedor> getAll() {
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        Connection conexion = ConexionDB.connectDB();

        if(conexion != null){
            String query = "SELECT * FROM proveedores";
            try(PreparedStatement statement = conexion.prepareStatement(query)){
                ResultSet resultSet = statement.executeQuery();
                Proveedor proveedor;
                while(resultSet.next()){
                    proveedor = new Proveedor(null,null);
                    proveedor.setId(resultSet.getInt("id"));
                    proveedor.setNombre(resultSet.getString("name"));
                    proveedor.setMail(resultSet.getString("mail"));
                    proveedores.add(proveedor);
                }
            }catch(SQLException e){
                System.err.println("Error al obtener los proveedores: "+ e.getMessage());
            }
        }
        return proveedores;
    }

    public static void delete(Proveedor proveedor) {
        Connection conexion = ConexionDB.connectDB();

        if(conexion != null){
            String query = "DELETE FROM proveedores WHERE id=?";
            try(PreparedStatement statement = conexion.prepareStatement(query)){
                statement.setInt(1, proveedor.getId());
                statement.executeUpdate();
                System.out.println("Proveedor eliminado exitosamente de la base de datos");
            }catch(SQLException e){
                System.err.println("Error al eliminar el proveedor de la base de datos: "+ e.getMessage());
            }
        }
    }
}
