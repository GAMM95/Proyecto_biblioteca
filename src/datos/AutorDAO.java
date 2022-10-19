package datos;

import entidad.Autor;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class AutorDAO {

    private Connection cnn = null;
    private ResultSet rs = null;

    private static AutorDAO instancia;

    public static AutorDAO getInstancia() {
        if (instancia == null) {
            instancia = new AutorDAO();
        }
        return instancia;
    }

    public void insertar(Autor autor) throws SQLException {
        cnn = Conexion.getInstancia().miConexion();

        PreparedStatement ps = null;
        try {
            String idautor = autor.getIdautor();
            String nombre = autor.getNombre();
            String sql = "INSERT INTO autor(idautor,nombre) values(?,?)";
            ps = cnn.prepareStatement(sql);
            ps.setString(1, idautor);
            ps.setString(2, nombre);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } finally {
            cnn.close();
            ps.close();
        }
    }

    public Autor buscarAutor(String idautor) throws SQLException {
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        Autor autor = null;
        try {
            String sql = "select * from autor where idautor=?";
            ps = cnn.prepareStatement(sql);
            ps.setString(1, idautor);
            rs = ps.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                autor = new Autor(idautor, nombre);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } finally {
            cnn.close();
            ps.close();
        }
        return autor;
    }

    public void actualizar(Autor autor) throws SQLException {
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try {
            String idautor = autor.getIdautor();
            String nombre = autor.getNombre();
            String sql = "update autor set nombre=? where idautor=?";
            ps = cnn.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, idautor);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } finally {
            cnn.close();
            ps.close();
        }
    }

    public void eliminar(String idautor) throws SQLException {

        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try {
            String sql = "delete from autor where idautor=?";
            ps = cnn.prepareStatement(sql);
            ps.setString(1, idautor);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } finally {
            cnn.close();
            ps.close();
        }
    }

    public void mostrarAutores(DefaultTableModel modelo) throws SQLException {
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        String titulos[] = {"idautor", "nombre"};
        modelo.getDataVector().removeAllElements();
        modelo.setColumnIdentifiers(titulos);
        try {
            String sql = "select * from autor";
            ps = cnn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String idautor = rs.getString("idautor");
                String nombre = rs.getString("nombre");
                String fila[] = {idautor, nombre};
                modelo.addRow(fila);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } finally {
            cnn.close();
            ps.close();
        }
    }

    public void mostrarPorNombre(String nom, DefaultTableModel modelo) throws SQLException {
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        String titulos[] = {"idautor", "nombre"};
        modelo.getDataVector().removeAllElements();
        modelo.setColumnIdentifiers(titulos);

        try {
            String sql = "select * from autor where nombre like ?";
            ps = cnn.prepareStatement(sql);
            ps.setString(1, nom + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                String idautor = rs.getString("idautor");
                String nombre = rs.getString("nombre");
                String fila[] = {idautor, nombre};
                modelo.addRow(fila);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } finally {
            cnn.close();
            ps.close();
        }

    }

}
