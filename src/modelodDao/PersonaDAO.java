package modelodDao;

import conexion.ConexionBD;
import modelo.PersonaVO;

import java.sql.*;
import java.util.ArrayList;

public class PersonaDAO {

    public boolean registrarPersona(PersonaVO persona) {
        Connection con = ConexionBD.getInstance().getConexion();
        String sql = "INSERT INTO personas (documento, nombre, telefono, direccion) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, persona.getDocumento());
            ps.setString(2, persona.getNombre());
            ps.setString(3, persona.getTelefono());
            ps.setString(4, persona.getDireccion());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar persona: " + e.getMessage());
            return false;
        }
    }

    public PersonaVO consultarPersona(String documento) {
        Connection con = ConexionBD.getInstance().getConexion();
        String sql = "SELECT * FROM personas WHERE documento = ?";
        PersonaVO persona = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, documento);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                persona = new PersonaVO(
                    rs.getString("documento"),
                    rs.getString("nombre"),
                    rs.getString("telefono"),
                    rs.getString("direccion")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar persona: " + e.getMessage());
        }
        return persona;
    }

    public boolean actualizarPersona(PersonaVO persona) {
        Connection con = ConexionBD.getInstance().getConexion();
        String sql = "UPDATE personas SET nombre=?, telefono=?, direccion=? WHERE documento=?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getTelefono());
            ps.setString(3, persona.getDireccion());
            ps.setString(4, persona.getDocumento());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar persona: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarPersona(String documento) {
        Connection con = ConexionBD.getInstance().getConexion();
        String sql = "DELETE FROM personas WHERE documento=?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, documento);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar persona: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<PersonaVO> listarPersonas() {
        Connection con = ConexionBD.getInstance().getConexion();
        String sql = "SELECT * FROM personas";
        ArrayList<PersonaVO> lista = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                PersonaVO persona = new PersonaVO(
                    rs.getString("documento"),
                    rs.getString("nombre"),
                    rs.getString("telefono"),
                    rs.getString("direccion")
                );
                lista.add(persona);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar personas: " + e.getMessage());
        }
        return lista;
    }
}

