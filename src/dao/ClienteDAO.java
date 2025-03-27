
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ClienteDAO {
    
    public static void insert(Cliente cliente){
        java.sql.Date cur_date = java.sql.Date.valueOf(LocalDate.now());

        Connection conexion = ConexionDB.connectDB();

        if(conexion != null){
            String query = "INSERT INTO clientes (name,phone_num,shipping_location,entity_type,registration_date) VALUES (?,?,?,?,?)";
            try(PreparedStatement statement = conexion.prepareStatement(query)){
                statement.setString(1, cliente.getName());
                statement.setString(2, cliente.getPhone());
                statement.setString(3, cliente.getLocation());
                statement.setInt(4, cliente.getType());
                statement.setDate(5, cur_date);

                statement.executeUpdate();

                System.out.println("Cliente agregado exitosamente a la base de datos");

            }catch(SQLException e){
                System.err.println("Error al agregar el cliente a la base de datos: "+ e.getMessage());
            }
        }
    }

    public static ArrayList<Cliente> getAll(){
        ArrayList<Cliente> clientes = new ArrayList<>();

        Connection conexion = ConexionDB.connectDB();
        if (conexion != null) {
            int id = 0;
            String name = null;
            String phone_num = null;
            String shipping_location = null;
            Date registration_date = null;
            int entity_type = 0;
            
            String query = "SELECT * FROM clientes"; 
            try (Statement statement = conexion.createStatement(); ResultSet results = statement.executeQuery(query)) {
                Cliente x;
                    while (results.next()) {
                        id = results.getInt("id");
                        name = results.getString("name");
                        phone_num = results.getString("phone_num");
                        shipping_location = results.getString("shipping_location");
                        registration_date = results.getDate("registration_date");
                        entity_type = results.getInt("entity_type");
                        x = new Cliente(name, phone_num, shipping_location, entity_type);
                        x.setID(id);x.setRegistrationDate(registration_date);
                        clientes.add(x);
                    }
                    return clientes;
                    
            } catch (SQLException e) {
                System.out.println("Error al obtener la lista de clientes: " + e.getMessage());
            }
        }

        return null;
    }
}
