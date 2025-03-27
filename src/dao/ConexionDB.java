package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Main.App;

public class ConexionDB {
    static final private String DB_URI = App.getEnvValue("DB_URI");
    static final private String DB_USER = App.getEnvValue("DB_USER");
    static final private String DB_USER_PSSW = App.getEnvValue("DB_USER_PSSW");

    public static Connection connectDB(){
        try {
            return DriverManager.getConnection(DB_URI,DB_USER,DB_USER_PSSW);
        } catch (SQLException e) {
            System.err.println("Error al conectarse a la base de datos: " + e.getMessage());
            return null;
        }
    }
}
