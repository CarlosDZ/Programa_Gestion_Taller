package dao;

import java.sql.*;
import java.util.ArrayList;
import model.Marca;

public class MarcaDAO {
    
    public static void insert(Marca marca){

        Connection conexion = ConexionDB.connectDB();

        if(conexion != null){
            String query = "INSERT INTO marcas (name) VALUES (?)";
            try(PreparedStatement statement = conexion.prepareStatement(query)){
                statement.setString(1, marca.getName());

                statement.executeUpdate();

                System.out.println("Marca agregada exitosamente a la base de datos");

            }catch(SQLException e){
                System.err.println("Error al agregar la marca a la base de datos: "+ e.getMessage());
            }
        }
    }

    public static ArrayList<Marca> getAll(){
        ArrayList<Marca> marcas = new ArrayList<>();

        Connection conexion = ConexionDB.connectDB();
        if (conexion != null) {
            
            String query = "SELECT * FROM marcas"; 
            try (Statement statement = conexion.createStatement(); ResultSet results = statement.executeQuery(query)) {
                Marca x;
                int id;
                String name;
                
                    while (results.next()) {
                        id = results.getInt("id");
                        name = results.getString("name");

                        x = new Marca(name);
                        x.setId(id);
                        marcas.add(x);
                    }
                    return marcas;
                    
            } catch (SQLException e) {
                System.out.println("Error al obtener la lista de marcas: " + e.getMessage());
            }
        }
        return null;
    }

    public static void delete(Marca marca){
        Connection conexion = ConexionDB.connectDB();

        if(conexion != null){
            String query = "DELETE FROM marcas WHERE id = ?";
            try(PreparedStatement statement = conexion.prepareStatement(query)){
                statement.setInt(1, marca.getId());

                statement.executeUpdate();

                System.out.println("Marca eliminada exitosamente de la base de datos");

            }catch(SQLException e){
                System.err.println("Error al eliminar la marca de la base de datos: "+ e.getMessage());
            }
        }
    }
}
