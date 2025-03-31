package dao;
import java.sql.*;
import java.util.ArrayList;
import model.Servicio;

public class ServicioDAO {
    public static ArrayList<Servicio> getAll(){
        ArrayList<Servicio> servicios = new ArrayList<>();

        Connection conexion = ConexionDB.connectDB();
        if (conexion != null) {
            
            String query = "SELECT * FROM servicios"; 
            try (Statement statement = conexion.createStatement(); ResultSet results = statement.executeQuery(query)) {
                Servicio x;
                int id;
                String name;
                Double price;
                
                    while (results.next()) {
                        id = results.getInt("id");
                        name = results.getString("name");
                        price = results.getDouble("price");

                        x = new Servicio(name, price);
                        x.setId(id);
                        servicios.add(x);
                    }
                    return servicios;
                    
            } catch (SQLException e) {
                System.out.println("Error al obtener la lista de servicios: " + e.getMessage());
            }
        }
        return null;
    }

    public static void insert(Servicio servicio){
        Connection conexion = ConexionDB.connectDB();

        if(conexion != null){
            String query = "INSERT INTO servicios (name,price) VALUES (?,?)";
            try(PreparedStatement statement = conexion.prepareStatement(query)){
                statement.setString(1, servicio.getName());
                statement.setDouble(2, servicio.getPrice());

                statement.executeUpdate();

                System.out.println("Servicio agregado exitosamente a la base de datos");

            }catch(SQLException e){
                System.err.println("Error al agregar el servicio a la base de datos: "+ e.getMessage());
            }
        }
    }

    public static void delete(Servicio servicio){
        Connection conexion = ConexionDB.connectDB();

        if(conexion != null){
            String query = "DELETE FROM servicios WHERE id = ?";
            try(PreparedStatement statement = conexion.prepareStatement(query)){
                statement.setInt(1, servicio.getId());

                statement.executeUpdate();

                System.out.println("Servicio eliminada exitosamente de la base de datos");

            }catch(SQLException e){
                System.err.println("Error al eliminar el servicio de la base de datos: "+ e.getMessage());
            }
        }
    }
}
