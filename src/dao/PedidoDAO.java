package dao;

import java.sql.*;
import java.util.ArrayList;
import model.Inventario;
import model.Pedido;

public class PedidoDAO {
    public static void insert(Pedido pedido){
        Connection conexion = ConexionDB.connectDB();
        String sql = "INSERT INTO pedidos (id_proveedor) VALUES (?)";
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, pedido.getId_proveedor());
            statement.executeUpdate();
            System.out.println("Pedido agregado con exito a la base de datos.");

            try{
                int id = getLastID();
                for(Inventario inventario : pedido.getContenido()){
                    sql = "INSERT INTO pedidos_aux (id_pedido, id_objeto, cantidad) VALUES (?, ?, ?)";
                    statement = conexion.prepareStatement(sql);
                    statement.setInt(1, id);
                    statement.setInt(2, inventario.getId_objeto());
                    statement.setInt(3, inventario.getCantidad());
                    statement.executeUpdate();
                }
            }catch (SQLException e) {
                System.out.println("Error al agregar el contenido del pedido a la lista auxiliar de la base de datos: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error al agregar el pedido a la base de datos: " + e.getMessage());
        }
    }

    public static int getLastID(){
        Connection conexion = ConexionDB.connectDB();
        String sql = "SELECT MAX(id_pedido) FROM pedidos";
        int id = 0;
        try {
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el ID del pedido: " + e.getMessage());
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion: " + e.getMessage());
            }
        }
        return id;
    }

    public static ArrayList<Inventario> getObjetosPedido(int id_pedido){
        Connection conexion = ConexionDB.connectDB();
        String sql = "SELECT id_objeto, cantidad FROM pedidos_aux WHERE id_pedido = ?";
        ArrayList<Inventario> objetos = new ArrayList<>();
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, id_pedido);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id_objeto = resultSet.getInt("id_objeto");
                int cantidad = resultSet.getInt("cantidad");
                objetos.add(new Inventario(id_objeto, cantidad));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los objetos del pedido: " + e.getMessage());
        }
        return objetos;
    }

    public static ArrayList<Pedido> getAll(){
        Connection conexion = ConexionDB.connectDB();
        String sql = "SELECT id_pedido, id_proveedor, completado FROM pedidos";
        ArrayList<Pedido> pedidos = new ArrayList<>();
        try {
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            int id_pedido;
            int id_proveedor;
            boolean completado;
            Pedido pedido;
            ArrayList<Inventario> objetos;
            while (resultSet.next()) {
                id_pedido = resultSet.getInt("id_pedido");
                id_proveedor = resultSet.getInt("id_proveedor");
                completado = resultSet.getBoolean("completado");
                objetos = getObjetosPedido(id_pedido);
                pedido = new Pedido(id_pedido, id_proveedor, completado, objetos);
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los pedidos: " + e.getMessage());
        }
        return pedidos;
    }

    public static void changeState(Pedido pedido){
        Connection conexion = ConexionDB.connectDB();
        String sql = "UPDATE pedidos SET completado = NOT completado WHERE id_pedido = ?";
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, pedido.getId());
            statement.executeUpdate();
            System.out.println("Estado del pedido cambiado con exito.");
        } catch (SQLException e) {
            System.out.println("Error al cambiar el estado del pedido: " + e.getMessage());
        }
    }

    public static void delete(Pedido pedido){
        Connection conexion = ConexionDB.connectDB();
        String sql = "DELETE FROM pedidos WHERE id_pedido = ?;DELETE FROM pedidos_aux WHERE id_pedido = ?";
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, pedido.getId());
            statement.setInt(2, pedido.getId());
            statement.executeUpdate();
            System.out.println("Pedido eliminado con exito.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar el pedido: " + e.getMessage());
        }
    }

}
