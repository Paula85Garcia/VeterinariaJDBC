package prueba;

import conexion.ConexionBD;

import java.sql.Connection;

public class PruebaConexion {
    public static void main(String[] args) {
        ConexionBD conexion = ConexionBD.getInstance();  
        Connection con = conexion.getConexion();

        if (con != null) {
            System.out.println("¡La conexión a la base de datos fue exitosa!");
            conexion.cerrarConexion(); 
        } else {
            System.out.println("Falló la conexión a la base de datos.");
        }
    }
}
