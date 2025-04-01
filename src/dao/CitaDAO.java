package dao;

import java.sql.*;
import java.util.ArrayList;
import model.Cita;

public class CitaDAO {
    public static void insert(Cita cita){

        Connection conexion = ConexionDB.connectDB();

        if(conexion != null){
            String query = "INSERT INTO citas (vehicle_id,date,time,service_id,compleated) VALUES (?,?,?,?,?)";
            try(PreparedStatement statement = conexion.prepareStatement(query)){
                statement.setInt(1, cita.getId_vehiculo());
                statement.setString(2, cita.getFecha());
                statement.setString(3, cita.getHora());
                statement.setInt(4, cita.getId_servicio());
                statement.setBoolean(5, cita.isCompleated());

                statement.executeUpdate();

                System.out.println("Cita agregada exitosamente a la base de datos");

            }catch(SQLException e){
                System.err.println("Error al agregar la cita a la base de datos: "+ e.getMessage());
            }
        }
    }

    public static ArrayList<Cita> getAll(){
        ArrayList<Cita> citas = new ArrayList<>();

        Connection conexion = ConexionDB.connectDB();

        if(conexion != null){
            String query = "SELECT * FROM citas";
            try(PreparedStatement statement = conexion.prepareStatement(query)){
                ResultSet resultSet = statement.executeQuery();

                Cita cita;
                while(resultSet.next()){
                    cita = new Cita(0, 0, null, null);
                    cita.setId(resultSet.getInt("id"));
                    cita.setId_vehiculo(resultSet.getInt("vehicle_id"));
                    cita.setFecha(resultSet.getString("date"));
                    cita.setHora(resultSet.getString("time"));
                    cita.setId_servicio(resultSet.getInt("service_id"));
                    cita.setCompleated(resultSet.getBoolean("compleated"));

                    citas.add(cita);
                }

            }catch(SQLException e){
                System.err.println("Error al obtener las citas de la base de datos: "+ e.getMessage());
            }
        }
        return citas;
    }

    public static void delete(Cita cita){
        Connection conexion = ConexionDB.connectDB();

        if(conexion != null){
            String query = "DELETE FROM citas WHERE id = ?";
            try(PreparedStatement statement = conexion.prepareStatement(query)){
                statement.setInt(1, cita.getId());

                statement.executeUpdate();

                System.out.println("Cita eliminada exitosamente de la base de datos");

            }catch(SQLException e){
                System.err.println("Error al eliminar la cita de la base de datos: "+ e.getMessage());
            }
        }
    }
    public static void changeState(Cita cita){
        Connection conexion = ConexionDB.connectDB();

        if(conexion != null){
            String query = "UPDATE citas SET compleated = ? WHERE id = ?";
            try(PreparedStatement statement = conexion.prepareStatement(query)){
                statement.setBoolean(1, !cita.isCompleated());
                statement.setInt(2, cita.getId());

                statement.executeUpdate();

                System.out.println("Estado de la cita cambiado exitosamente en la base de datos");

            }catch(SQLException e){
                System.err.println("Error al cambiar el estado de la cita en la base de datos: "+ e.getMessage());
            }
        }
    }
}
