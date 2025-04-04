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
}
