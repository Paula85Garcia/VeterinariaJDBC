package modelodDao;

import conexion.ConexionBD;
import modelo.MascotaVO;

import java.sql.*;
import java.util.ArrayList;

public class MascotaDAO {

    public boolean registrarMascota(MascotaVO mascota) {
        Connection con = ConexionBD.getInstance().getConexion();
        // Quitamos "documentoDueño" del INSERT porque ya está "documento"
        String sql = "INSERT INTO mascotas (documento, nombreMascota, especie, raza, edad) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, mascota.getDocumentoDueño());
            ps.setString(2, mascota.getNombreMascota());
            ps.setString(3, mascota.getEspecie());
            ps.setString(4, mascota.getRaza());
            ps.setInt(5, mascota.getEdad());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar mascota: " + e.getMessage());
            return false;
        }
    }

    public MascotaVO consultarMascota(int id) {
        Connection con = ConexionBD.getInstance().getConexion();
        String sql = "SELECT * FROM mascotas WHERE id = ?";
        MascotaVO mascota = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                mascota = new MascotaVO(
                    rs.getInt("id"),
                    rs.getString("nombreMascota"), // corregido
                    rs.getString("especie"),
                    rs.getString("raza"),
                    rs.getInt("edad"),
                    rs.getString("documento")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar mascota: " + e.getMessage());
        }
        return mascota;
    }

    public boolean actualizarMascota(MascotaVO mascota) {
        Connection con = ConexionBD.getInstance().getConexion();
        String sql = "UPDATE mascotas SET nombreMascota=?, especie=?, raza=?, edad=?, documento=? WHERE id=?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, mascota.getNombreMascota());
            ps.setString(2, mascota.getEspecie());
            ps.setString(3, mascota.getRaza());
            ps.setInt(4, mascota.getEdad());
            ps.setString(5, mascota.getDocumentoDueño());
            ps.setInt(6, mascota.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar mascota: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarMascota(int id) {
        Connection con = ConexionBD.getInstance().getConexion();
        String sql = "DELETE FROM mascotas WHERE id=?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar mascota: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<MascotaVO> listarMascotas() {
        Connection con = ConexionBD.getInstance().getConexion();
        String sql = "SELECT * FROM mascotas";
        ArrayList<MascotaVO> lista = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                MascotaVO mascota = new MascotaVO(
                    rs.getInt("id"),
                    rs.getString("nombreMascota"), // corregido
                    rs.getString("especie"),
                    rs.getString("raza"),
                    rs.getInt("edad"),
                    rs.getString("documento")
                );
                lista.add(mascota);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar mascotas: " + e.getMessage());
        }
        return lista;
    }
}
