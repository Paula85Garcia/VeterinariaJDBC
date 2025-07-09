package controlador;

import modelo.PersonaVO;
import modelo.MascotaVO;
import modelodDao.PersonaDAO;
import modelodDao.MascotaDAO;
import vista.VentanaPrincipal;
import vista.VentanaPersonas;
import vista.VentanaMascotas;
import conexion.ConexionBD;

import java.util.ArrayList;

public class Coordinador {

    private VentanaPrincipal ventanaPrincipal;
    private VentanaPersonas ventanaPersonas;
    private VentanaMascotas ventanaMascotas;
    private PersonaDAO personaDAO;
    private MascotaDAO mascotaDAO;
    private ConexionBD conexionBD;

    public Coordinador() {
        System.out.println("Coordinador iniciado");
    }

    // Setters para ventanas y DAOs
    public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }

    public void setVentanaPersonas(VentanaPersonas ventanaPersonas) {
        this.ventanaPersonas = ventanaPersonas;
    }

    public void setVentanaMascotas(VentanaMascotas ventanaMascotas) {
        this.ventanaMascotas = ventanaMascotas;
    }

    public void setPersonaDAO(PersonaDAO personaDAO) {
        this.personaDAO = personaDAO;
    }

    public void setMascotaDAO(MascotaDAO mascotaDAO) {
        this.mascotaDAO = mascotaDAO;
    }

    public void setConexionBD(ConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    // Mostrar ventanas
    public void mostrarVentanaPrincipal() {
        if (ventanaPrincipal != null) {
            ventanaPrincipal.setVisible(true);
            System.out.println("La ventana principal debería mostrarse ahora.");
        } else {
            System.err.println("Error: ventanaPrincipal es null");
        }
    }

    public void mostrarVentanaPersonas() {
        if (ventanaPersonas != null) {
            ventanaPersonas.setVisible(true);
        } else {
            System.err.println("Error: ventanaPersonas es null");
        }
    }

    public void mostrarVentanaMascotas() {
        if (ventanaMascotas != null) {
            ventanaMascotas.setVisible(true);
        } else {
            System.err.println("Error: ventanaMascotas es null");
        }
    }

    // Métodos para Personas usando PersonaDAO

    public boolean registrarPersona(PersonaVO persona) {
        return personaDAO.registrarPersona(persona);
    }

    public PersonaVO consultarPersona(String documento) {
        return personaDAO.consultarPersona(documento);
    }

    public boolean actualizarPersona(PersonaVO persona) {
        return personaDAO.actualizarPersona(persona);
    }

    public boolean eliminarPersona(String documento) {
        return personaDAO.eliminarPersona(documento);
    }

    public ArrayList<PersonaVO> listarPersonas() {
        return personaDAO.listarPersonas();
    }

    // Métodos para Mascotas usando MascotaDAO

    public boolean registrarMascota(MascotaVO mascota) {
        return mascotaDAO.registrarMascota(mascota);
    }

    public MascotaVO consultarMascota(int id) {
        return mascotaDAO.consultarMascota(id);
    }

    public boolean actualizarMascota(MascotaVO mascota) {
        return mascotaDAO.actualizarMascota(mascota);
    }

    public boolean eliminarMascota(int id) {
        return mascotaDAO.eliminarMascota(id);
    }

    public ArrayList<MascotaVO> listarMascotas() {
        return mascotaDAO.listarMascotas();
    }
}
