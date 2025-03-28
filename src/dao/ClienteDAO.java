package dao;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Cliente;
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
            
            String query = "SELECT * FROM clientes"; 
            try (Statement statement = conexion.createStatement(); ResultSet results = statement.executeQuery(query)) {
                Cliente x;
                int id;
                String name;
                String phone_num;
                String shipping_location;
                Date registration_date;
                int entity_type;
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

    public static void delete(Cliente cliente){
        Connection conexion = ConexionDB.connectDB();
        int id = cliente.getID();
        if (conexion != null) {
            String query = "DELETE FROM clientes WHERE id = ?";
            try (PreparedStatement statement = conexion.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.executeUpdate();
                System.out.println("Cliente eliminado.");
            } catch (SQLException e) {
                System.out.println("Error al eliminar cliente: " + e.getMessage());
            }
        }
    }


    //Actualizar atributos

    public static void actualizarTelefono(Cliente cliente, String nuevoTelefono) {
        Connection conexion = ConexionDB.connectDB();
        if (conexion != null) {
            String query = "UPDATE clientes SET phone_num = ? WHERE id = ?";
            try (PreparedStatement statement = conexion.prepareStatement(query)) {
                statement.setString(1, nuevoTelefono);
                statement.setInt(2, cliente.getID());
                statement.executeUpdate();
                System.out.println("Telefono actualizado.");
            } catch (SQLException e) {
                System.out.println("Error al actualizar el telofono del cliente: " + e.getMessage());
            }
        }
    }

    public static void actualizarNombre(Cliente cliente, String nuevoNombre) {
        Connection conexion = ConexionDB.connectDB();
        if (conexion != null) {
            String query = "UPDATE clientes SET name = ? WHERE id = ?";
            try (PreparedStatement statement = conexion.prepareStatement(query)) {
                statement.setString(1, nuevoNombre);
                statement.setInt(2, cliente.getID());
                statement.executeUpdate();
                System.out.println("Nombre actualizado.");
            } catch (SQLException e) {
                System.out.println("Error al actualizar el nombre del cliente: " + e.getMessage());
            }
        }
    }

    public static void actualizarDireccion(Cliente cliente, String nuevaDireccion) {
        Connection conexion = ConexionDB.connectDB();
        if (conexion != null) {
            String query = "UPDATE clientes SET shipping_location = ? WHERE id = ?";
            try (PreparedStatement statement = conexion.prepareStatement(query)) {
                statement.setString(1, nuevaDireccion);
                statement.setInt(2, cliente.getID());
                statement.executeUpdate();
                System.out.println("Direccion de envio actualizado.");
            } catch (SQLException e) {
                System.out.println("Error al actualizar la direccion de envio del cliente: " + e.getMessage());
            }
        }
    }

    public static void actualizarTipoEntidad(Cliente cliente, int nuevoTipo) {
        Connection conexion = ConexionDB.connectDB();
        if (conexion != null) {
            String query = "UPDATE clientes SET entity_type = ? WHERE id = ?";
            try (PreparedStatement statement = conexion.prepareStatement(query)) {
                statement.setInt(1, nuevoTipo);
                statement.setInt(2, cliente.getID());
                statement.executeUpdate();
                System.out.println("Tipo de entidad actualizada.");
            } catch (SQLException e) {
                System.out.println("Error al actualizar el tipo de entidad del cliente: " + e.getMessage());
            }
        }
    }

    //e
}
