package controlador;

import javax.swing.SwingUtilities;
import conexion.ConexionBD;
import modelodDao.MascotaDAO;
import modelodDao.PersonaDAO;
import vista.VentanaPersonas;
import vista.VentanaPrincipal;
import vista.VentanaMascotas;

public class Relaciones {

    public Relaciones() {
        SwingUtilities.invokeLater(() -> {
            // Instanciar vistas
            VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
            VentanaPersonas ventanaPersonas = new VentanaPersonas();
            VentanaMascotas ventanaMascotas = new VentanaMascotas();

            // Instanciar DAOs
            PersonaDAO personaDAO = new PersonaDAO();
            MascotaDAO mascotaDAO = new MascotaDAO();

            // Obtener conexión (singleton)
            ConexionBD conexionBD = ConexionBD.getInstance();

            // Instanciar coordinador
            Coordinador coordinador = new Coordinador();

            // Setear coordinador en vistas
            ventanaPrincipal.setCoordinador(coordinador);
            ventanaPersonas.setCoordinador(coordinador);
            ventanaMascotas.setCoordinador(coordinador);

            // Setear modelos y vistas en coordinador
            coordinador.setVentanaPrincipal(ventanaPrincipal);
            coordinador.setVentanaPersonas(ventanaPersonas);
            coordinador.setVentanaMascotas(ventanaMascotas);
            coordinador.setPersonaDAO(personaDAO);
            coordinador.setMascotaDAO(mascotaDAO);
            coordinador.setConexionBD(conexionBD);

            // Mostrar ventana principal
            coordinador.mostrarVentanaPrincipal();
        });
    }
}
