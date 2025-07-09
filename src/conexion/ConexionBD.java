package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/veterinaria"; // <-- Cambiado aquí
    private static final String USER = "root";
    private static final String PASS = "";

    private static ConexionBD instancia;
    private Connection conexion;

    // Constructor privado para Singleton
    private ConexionBD() {
        try {
            conexion = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.err.println("Error al conectar: " + e.getMessage());
        }
    }

    // Método para obtener instancia única
    public static ConexionBD getInstance() {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }

    // Método para obtener la conexión
    public Connection getConexion() {
        return conexion;
    }

    // Método para cerrar la conexión
    public void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar conexión: " + e.getMessage());
        }
    }

    // Si usas esto en tus DAOs, puedes dejarlo vacío o llamar cerrarConexion()
    public void desconectar() {
        cerrarConexion();
    }
}
