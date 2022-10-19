/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import entidad.DetalleUsuario;
import entidad.Ejemplar;
import entidad.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class UsuarioDAO {
    private Connection cnn = null;
    private ResultSet rs=null;

    private static UsuarioDAO instancia;

    public static UsuarioDAO getInstancia()
    {
        if(instancia==null)
            instancia=new UsuarioDAO();
        return instancia;
    }
    
    public void insertar(Usuario usuario) throws SQLException {
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps=null;
        try {
             String sql="insert into usuario(idusuario,nombre,telefono,direccion) values(?,?,?,?)";
             ps = cnn.prepareStatement(sql);
             ps.setString(1, usuario.getIdusuario());
             ps.setString(2, usuario.getNombre());
             ps.setString(3, usuario.getTelefono());
             ps.setString(4,usuario.getDireccion());
             ps.executeUpdate();
             
             ListaDetalleUsuario LD=usuario.getLD();
             
             for(int i=0;i<LD.getN();i++)
             {
                 DetalleUsuario x = LD.getElemento(i);
                 sql="insert into usuario_ejemplar(idusuario,idejemplar,fechaprestamo,fechadevolucion )values(?,?,?,?)";
                 ps=cnn.prepareStatement(sql);
                 ps.setString(1,usuario.getIdusuario());
                 ps.setString(2,x.getEjemplar().getIdejemplar());
                 ps.setString(3,x.getFechaPrestamo());
                 ps.setString(4, x.getFechaDevolucion());
                 ps.executeUpdate();
             }
        }catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }finally {
            cnn.close();
            ps.close();
        }
    }
    
    public Usuario buscarUsuario(String idusuario) throws SQLException {
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps=null;
        Usuario usuario=null;
        try {
            String sql="select * from usuario where idusuario=?";
            ps = cnn.prepareStatement(sql);
            ps.setString(1,idusuario);
            rs = ps.executeQuery();
            if (rs.next()) {
                String nombre=rs.getString("nombre");
                String telefono=rs.getString("telefono");
                String direccion=rs.getString("direccion");
                usuario= new Usuario(idusuario,nombre,telefono,direccion);
                sql="select * from usuario_ejemplar where idusuario=?";
                ps=cnn.prepareStatement(sql);
                ps.setString(1, idusuario);
                rs=ps.executeQuery();
                while(rs.next()){
                    String idejemplar=rs.getString("idejemplar");
                    String fechaprestamo=rs.getString("fechaprestamo");
                    String fechadevolucion=rs.getString("fechadevolucion");
                    Ejemplar ejemplar=EjemplarDAO.getInstancia().buscarEjemplar(idejemplar);
                    DetalleUsuario det = new DetalleUsuario(ejemplar,fechaprestamo,fechadevolucion);
                    usuario.registrarDetalleUsuario(det);
                }
            }
        } catch (SQLException ex) {
            System.out.println("ERROR:" + ex.getMessage());
        } finally {
            cnn.close();
            ps.close();
        }
        return usuario;
    }
    
    public void actualizar(Usuario usuario) throws SQLException {
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps=null;
        try {
            String idusuario=usuario.getIdusuario();
            String nombre=usuario.getNombre();
            String telefono=usuario.getTelefono();
            String direccion=usuario.getDireccion();
            String sql="update usuario set nombre=?, telefono=?,direccion=? where idusuario=?";
            ps = cnn.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, telefono);
            ps.setString(3, direccion);
            ps.executeUpdate();
            sql="delete from usuario_ejemplar where idusuario=?";
            ps = cnn.prepareStatement(sql);
            ps.setString(1, idusuario);
            ps.executeUpdate();
            ListaDetalleUsuario LD=usuario.getLD();
             
             for(int i=0;i<LD.getN();i++)
             {
                 DetalleUsuario x = LD.getElemento(i);
                 sql="insert into usario_ejemplar(idusuario,idejemplar,fechaprestamo,fechadevolucion)values(?,?,?,?)";
                 ps=cnn.prepareStatement(sql);
                 ps.setString(1,usuario.getIdusuario());
                 ps.setString(2,x.getEjemplar().getIdejemplar());
                 ps.setString(3,x.getFechaPrestamo());
                 ps.setString(4,x.getFechaDevolucion());
                 ps.executeUpdate();
             }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } finally {
            cnn.close();
            ps.close();
        }
    } 
    
    public void eliminar(String idusuario) throws SQLException {
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps=null;
        try {
            String sql="delete from usuario_ejemplar where idusuario=?";
            ps = cnn.prepareStatement(sql);
            ps.setString(1, idusuario);
            ps.executeUpdate();
            sql="delete from usuario where idusuario=?";
            ps = cnn.prepareStatement(sql);
            ps.setString(1, idusuario);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } finally {
            cnn.close();
            ps.close();
        }
    }
    
   public void  mostrarUsuarios(DefaultTableModel modelo) throws SQLException {
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps=null;
        String titulos[]={"idusuario","nobmre","telefono","direccion"};
        modelo.getDataVector().removeAllElements();
        modelo.setColumnIdentifiers(titulos);
        try {
            String sql="select * from usuario";
            ps=cnn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                String idusuario=rs.getString("idusuario");
                String nombre=rs.getString("nombre");
                String telefono=rs.getString("telefono");
                String direccion=rs.getString("direccion");
                String fila[]={idusuario,nombre,telefono,direccion};
                modelo.addRow(fila);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } finally {
            cnn.close();
            ps.close();
        }
    }
    
    public void  mostrarPorNombre(String nom,DefaultTableModel modelo) throws SQLException {
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps=null;
        String titulos[]={"idusuario","nobmre","telefono","direccion"};
        modelo.getDataVector().removeAllElements();
        modelo.setColumnIdentifiers(titulos);

        try {
            String sql="select * from usuario where nombre like ?";
            ps=cnn.prepareStatement(sql);
            ps.setString(1, nom+"%");
            rs=ps.executeQuery();
            while (rs.next()) {
                String idusuario=rs.getString("idusuario");
                String nombre=rs.getString("nombre");
                String telefono=rs.getString("telefono");
                String direccion=rs.getString("direccion");
                String fila[]={idusuario,nombre,telefono,direccion};
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
