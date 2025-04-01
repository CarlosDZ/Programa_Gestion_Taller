package dao;

import java.sql.*;
import java.util.ArrayList;
import model.Objeto;

public class ObjetoDAO {
    public static void insert(Objeto objeto){

        Connection conexion = ConexionDB.connectDB();

        if(conexion != null){
            String query = "INSERT INTO objeto (name) VALUES (?)";
            try(PreparedStatement statement = conexion.prepareStatement(query)){
                statement.setString(1, objeto.getNombre());

                statement.executeUpdate();

                System.out.println("Objeto agregado exitosamente a la base de datos");

            }catch(SQLException e){
                System.err.println("Error al agregar el objeto a la base de datos: "+ e.getMessage());
            }
        }
    }

    public static ArrayList<Objeto> getAll(){
        ArrayList<Objeto> objetos = new ArrayList<>();

        Connection conexion = ConexionDB.connectDB();

        if(conexion != null){
            String query = "SELECT * FROM objeto";
            try(PreparedStatement statement = conexion.prepareStatement(query)){
                ResultSet resultSet = statement.executeQuery();
                Objeto objeto;

                while(resultSet.next()){
                    objeto = new Objeto(resultSet.getString("name"));
                    objeto.setId(resultSet.getInt("id"));
                    objetos.add(objeto);
                }

            }catch(SQLException e){
                System.err.println("Error al obtener los objetos de la base de datos: "+ e.getMessage());
            }
        }
        return objetos;
    }

    public static void delete(Objeto objeto){
        Connection conexion = ConexionDB.connectDB();

        if(conexion != null){
            String query = "DELETE FROM objeto WHERE id = ?";
            try(PreparedStatement statement = conexion.prepareStatement(query)){
                statement.setInt(1, objeto.getId());

                statement.executeUpdate();

                System.out.println("Objeto eliminado exitosamente de la base de datos");

            }catch(SQLException e){
                System.err.println("Error al eliminar el objeto de la base de datos: "+ e.getMessage());
            }
        }
    }
}