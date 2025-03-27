
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

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
}
