package dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Transaccion;

public class TransaccionDAO {

    public static Double getBalanceActual(){
        String sql = "SELECT SUM(cantidad) FROM transacciones";
        Double balance = 0.0;
        Connection conexion = ConexionDB.connectDB();

        if(conexion != null){
            try(PreparedStatement statement = conexion.prepareStatement(sql)){
                ResultSet resultSet = statement.executeQuery();
                if(resultSet.next()){
                    balance = resultSet.getDouble(1);
                }
            }catch(SQLException e){
                System.err.println("Error al obtener el balance actual de la base de datos: "+ e.getMessage());
            }
        }
        return balance;
    }

    public static ArrayList<Transaccion> getAll(){
        ArrayList<Transaccion> transacciones = new ArrayList<>();
        Connection conexion = ConexionDB.connectDB();
        if (conexion != null) {
            String query = "SELECT * FROM transacciones";
            try (Statement statement = conexion.createStatement(); ResultSet results = statement.executeQuery(query)) {
                Transaccion x;
                int id;
                Double cantidad;
                String concepto;
                String fecha;
                int id_tipo;
                int id_variable;
                    while (results.next()) {
                        id = results.getInt("id");
                        cantidad = results.getDouble("cantidad");
                        concepto = results.getString("concepto");
                        fecha = results.getDate("fecha").toString();
                        id_tipo = results.getInt("tipo");
                        if(id_tipo != 1 && id_tipo != 2){
                            id_variable = results.getInt("id_variable");
                            x = new Transaccion(id, cantidad, concepto, fecha, id_tipo, id_variable);
                            transacciones.add(x);
                        }
                        else{
                            x = new Transaccion(id, cantidad, concepto, fecha, id_tipo);
                            transacciones.add(x);
                        }
                    }
                    return transacciones;
                    
            } catch (SQLException e) {
                System.err.println("Error al obtener las transacciones de la base de datos: "+ e.getMessage());
            }
        }
        return null;
    }

    public static void insert(Transaccion transaccion){
        Connection conexion = ConexionDB.connectDB();
        if(conexion != null){
            if(transaccion.getId_tipo() == 1 || transaccion.getId_tipo() == 2){
                String query = "INSERT INTO transacciones (cantidad, concepto, fecha, tipo) VALUES (?, ?, ?, ?)";
                try (PreparedStatement statement = conexion.prepareStatement(query)){
                    statement.setDouble(1, transaccion.getCantidad());
                    statement.setString(2, transaccion.getConcepto());
                    statement.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
                    statement.setInt(4, transaccion.getId_tipo());
                    statement.executeUpdate();
                    System.out.println("Transaccion agregada exitosamente a la base de datos");
                } catch (SQLException e) {
                    System.out.println("Error al insertar la transaccion: " + e.getMessage());
                }
            }
            else{
                String query = "INSERT INTO transacciones (cantidad, concepto, fecha, tipo, id_variable) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement statement = conexion.prepareStatement(query)){
                    statement.setDouble(1, transaccion.getCantidad());
                    statement.setString(2, transaccion.getConcepto());
                    statement.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
                    statement.setInt(4, transaccion.getId_tipo());
                    statement.setInt(5, transaccion.getId_variable());
                    statement.executeUpdate();
                    System.out.println("Transaccion agregada exitosamente a la base de datos");
                } catch (SQLException e) {
                    System.out.println("Error al insertar la transaccion: " + e.getMessage());
                }
            }
        }
    }

    public static void delete(Transaccion transaccion){
        if(transaccion == null){
            System.out.println("La transaccion que intenta borrar no existe.");
        }
        else{
            Connection conexion = ConexionDB.connectDB();
            if(conexion != null){
                String query = "DELETE FROM transacciones WHERE id = ?";
                try (PreparedStatement statement = conexion.prepareStatement(query)){
                    statement.setInt(1, transaccion.getId());
                    statement.executeUpdate();
                    System.out.println("Transaccion eliminada exitosamente de la base de datos");
                } catch (SQLException e) {
                    System.err.println("Error al eliminar la transaccion: " + e.getMessage());
                }
            }
        }
    }
    public static Transaccion searchByLinkedEvent(int tipo, int id_variable){
        Connection conexion = ConexionDB.connectDB();
        if(conexion != null){
            String sql = "SELECT * FROM transacciones WHERE tipo = ? AND id_variable = ?";
            try(PreparedStatement statement = conexion.prepareStatement(sql)){
                statement.setInt(1, tipo);
                statement.setInt(2, id_variable);
                ResultSet resultSet = statement.executeQuery();
                if(resultSet.next()){
                    int id = resultSet.getInt("id");
                    Double cantidad = resultSet.getDouble("cantidad");
                    String concepto = resultSet.getString("concepto");
                    String fecha = resultSet.getDate("fecha").toString();
                    Transaccion transaccion = new Transaccion(id, cantidad, concepto, fecha, tipo, id_variable);
                    return transaccion;
                }
            }catch(SQLException e){
                System.err.println("Error al buscar la transaccion por evento vinculado: "+ e.getMessage());
            }
        }
        return null;
    }
}
