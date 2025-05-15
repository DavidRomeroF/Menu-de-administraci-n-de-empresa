package tmk.bdd.ConexionBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {
    private static Connection conexion = null;
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/empresas";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    static {
        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión establecida automáticamente.");
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }

    public static Connection getConexion() {
        return conexion;
    }
}
