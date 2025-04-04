package dao;

import java.sql.*;
import java.util.ArrayList;
import model.TipoTransaccion;
public class TipoTransaccionDAO {
    public static ArrayList<TipoTransaccion> getAll(){
        ArrayList<TipoTransaccion> lista = new ArrayList<>();
        Connection conexion = ConexionDB.connectDB();

        if(conexion != null){
            String query = "SELECT * FROM tipos_transaccion";
            try(PreparedStatement statement = conexion.prepareStatement(query)){
                ResultSet resultSet = statement.executeQuery();

                TipoTransaccion tipoTransaccion;
                while(resultSet.next()){
                    tipoTransaccion = new TipoTransaccion(0,null);
                    tipoTransaccion.setId(resultSet.getInt("id"));
                    tipoTransaccion.setNombre(resultSet.getString("nombre"));
                    lista.add(tipoTransaccion);
                }

            }catch(SQLException e){
                System.err.println("Error al obtener los tipos de transacción de la base de datos: "+ e.getMessage());
            }
        }
        return lista;
    }
    public static void insert(TipoTransaccion tipoTransaccion){
        Connection conexion = ConexionDB.connectDB();

        if(conexion != null){
            String query = "INSERT INTO tipos_transaccion (nombre) VALUES (?)";
            try(PreparedStatement statement = conexion.prepareStatement(query)){
                statement.setString(1, tipoTransaccion.getNombre());
                statement.executeUpdate();
                System.out.println("Tipo de transacción agregado exitosamente a la base de datos");
            }catch(SQLException e){
                System.err.println("Error al agregar el tipo de transacción a la base de datos: "+ e.getMessage());
            }
        }
    }
    public static void delete(TipoTransaccion tipoTransaccion){
        Connection conexion = ConexionDB.connectDB();

        if(conexion != null){
            String query = "DELETE FROM tipos_transaccion WHERE id = ?";
            try(PreparedStatement statement = conexion.prepareStatement(query)){
                statement.setInt(1, tipoTransaccion.getId());
                statement.executeUpdate();
                System.out.println("Tipo de transacción eliminado exitosamente de la base de datos");
            }catch(SQLException e){
                System.err.println("Error al eliminar el tipo de transacción de la base de datos: "+ e.getMessage());
            }
        }
    }
}
