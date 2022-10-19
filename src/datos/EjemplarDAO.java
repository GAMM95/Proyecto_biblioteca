/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import entidad.Autor;
import entidad.Ejemplar;
import entidad.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class EjemplarDAO {
    private Connection cnn = null;
    private ResultSet rs=null;

    private static EjemplarDAO instancia;

    public static EjemplarDAO getInstancia()
    {
        if(instancia==null)
            instancia=new EjemplarDAO();
        return instancia;
    }
    
    public void insertar(Ejemplar ejemplar) throws SQLException {
        cnn = Conexion.getInstancia().miConexion();
        
        PreparedStatement ps=null;
        try {
            String idejemplar=ejemplar.getIdejemplar();
            String localizacion=ejemplar.getLocalizacion();
            String idlibro=ejemplar.getLibro().getIdlibro();
            String sql="INSERT INTO ejemplar(idejemplar,localizacion,idlibro) values(?,?,?)";
            ps = cnn.prepareStatement(sql);
            ps.setString(1, idejemplar);
            ps.setString(2, localizacion);
            ps.setString(3, idlibro);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } finally {
            cnn.close();
            ps.close();
        }
    }
    
    public Ejemplar buscarEjemplar(String idejemplar) throws SQLException {
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps=null;
        Ejemplar ejemplar=null;
        try {
            String sql="select * from ejemplar where idejemplar=?";
            ps = cnn.prepareStatement(sql);
            ps.setString(1,idejemplar);
            rs = ps.executeQuery();
            if (rs.next()){
                String localizacion=rs.getString("localizacion");
                String idlibro=rs.getString("idlibro");
                Libro libro=LibroDAO.getInstancia().buscarLibro(idlibro);
                ejemplar= new Ejemplar(idejemplar,localizacion,libro);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } finally {
            cnn.close();
            ps.close();
        }
        return ejemplar;
    }
    
    public void actualizar(Ejemplar ejemplar) throws SQLException {
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps=null;
        try {
            String idejemplar=ejemplar.getIdejemplar();
            String localizacion=ejemplar.getLocalizacion();
            String sql="update ejemplar set localizacion=? where idejemplar=?";
            ps = cnn.prepareStatement(sql);
            ps.setString(1, localizacion);
            ps.setString(2, idejemplar);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } finally {
            cnn.close();
            ps.close();
        }
    }

    public void eliminar(String idejemplar) throws SQLException {

        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps=null;
        try {
            String sql="delete from ejemplar where idejemplar=?";
            ps = cnn.prepareStatement(sql);
            ps.setString(1, idejemplar);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } finally {
            cnn.close();
            ps.close();
        }
    }

    public void  mostrarEjemplares(DefaultTableModel modelo) throws SQLException {
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps=null;
        String titulos[]={"idejemplar","localizacion","idlibro"};
        modelo.getDataVector().removeAllElements();
        modelo.setColumnIdentifiers(titulos);
        try {
            String sql="select * from ejemplar";
            ps=cnn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                String idejemplar=rs.getString("idejemplar");
                String localizacion=rs.getString("localizacion");
                String idlibro=rs.getString("idlibro");
                String fila[]={idejemplar,localizacion,idlibro};
                modelo.addRow(fila);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } finally {
            cnn.close();
            ps.close();
        }
    }
    
    public void  mostrarPorLocalizacion(String loca,DefaultTableModel modelo) throws SQLException {
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps=null;
        String titulos[]={"idautor","localizacion","idlibro"};
        modelo.getDataVector().removeAllElements();
        modelo.setColumnIdentifiers(titulos);
        try {
            String sql="select * from ejemplar where localizacion like ?";
            ps=cnn.prepareStatement(sql);
            ps.setString(1, loca+"%");
            rs=ps.executeQuery();
            while (rs.next()) {
                String idejemplar=rs.getString("idejemplar");
                String localizacion=rs.getString("localizacion");
                String idlibro=rs.getString("idlibro");
                String fila[]={idejemplar,localizacion,idlibro};
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
