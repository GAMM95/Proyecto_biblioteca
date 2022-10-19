package datos;

import entidad.Autor;
import entidad.DetalleLibro;
import entidad.Libro;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class LibroDAO {
    
    private Connection cnn = null;
    private ResultSet rs=null;

    private static LibroDAO instancia;

    public static LibroDAO getInstancia()
    {
        if(instancia==null)
            instancia=new LibroDAO();
        return instancia;
    }
    
    public void insertar(Libro libro) throws SQLException {
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps=null;
        try {
             String sql="insert into libro(idlibro,titulo,isbn,editorial,paginas) values(?,?,?,?,?)";
             ps = cnn.prepareStatement(sql);
             ps.setString(1, libro.getIdlibro());
             ps.setString(2, libro.getTitulo());
             ps.setString(3, libro.getIsbn());
             ps.setString(4,libro.getEditorial());
             ps.setInt(5, libro.getPaginas());
             ps.executeUpdate();
             
             ListaDetalleLibro LD=libro.getLD();
             
             for(int i=0;i<LD.getN();i++)
             {
                 DetalleLibro x = LD.getElemento(i);
                 sql="insert into autor_libro(idautor,idlibro)values(?,?)";
                 ps=cnn.prepareStatement(sql);
                 ps.setString(1,x.getAutor().getIdautor());
                 ps.setString(2, libro.getIdlibro());
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
    
 
     public Libro buscarLibro(String idlibro) throws SQLException {
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps=null;
        Libro libro=null;
        try {
            String sql="select * from libro where idlibro=?";
            ps = cnn.prepareStatement(sql);
            ps.setString(1,idlibro);
            rs = ps.executeQuery();
            if (rs.next()) {
                String titulo=rs.getString("titulo");
                String isbn=rs.getString("isbn");
                String editorial=rs.getString("editorial");
                int paginas=rs.getInt("paginas");
                libro= new Libro(idlibro,titulo,isbn,editorial,paginas);
                sql="select * from autor_libro where idlibro=?";
                ps=cnn.prepareStatement(sql);
                ps.setString(1, idlibro);
                rs=ps.executeQuery();
                while(rs.next()){
                    String idautor=rs.getString("idautor");
                    Autor autor=AutorDAO.getInstancia().buscarAutor(idautor);
                    DetalleLibro det = new DetalleLibro(autor);
                    libro.registrarDetalleLibro(det);
                }
            }
        } catch (SQLException ex) {
            System.out.println("ERROR:" + ex.getMessage());
        } finally {
            cnn.close();
            ps.close();
        }
        return libro;
    }
     
    public void actualizar(Libro libro) throws SQLException {
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps=null;
        try {
            String idlibro=libro.getIdlibro();
            String titulo=libro.getTitulo();
            String isbn=libro.getIsbn();
            String editorial=libro.getEditorial();
            int paginas=libro.getPaginas();
            String sql="update autor set titulo=?, isbn=?, editorial=?, paginas=? where idlibro=?";
            ps = cnn.prepareStatement(sql);
            ps.setString(1, titulo);
            ps.setString(2, isbn);
            ps.setString(3, editorial);
            ps.setInt(4,paginas);
            ps.setString(5,idlibro);
            ps.executeUpdate();
            sql="delete from autor_libro where idlibro=?";
            ps = cnn.prepareStatement(sql);
            ps.setString(1, idlibro);
            ps.executeUpdate();
            
            ListaDetalleLibro LD=libro.getLD();
             
             for(int i=0;i<LD.getN();i++)
             {
                 DetalleLibro x = LD.getElemento(i);
                 sql="insert into autor_libro(idautor,idlibro)values(?,?)";
                 ps=cnn.prepareStatement(sql);
                 ps.setString(1,x.getAutor().getIdautor());
                 ps.setString(2, libro.getIdlibro());
                 ps.executeUpdate();
             }
            
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } finally {
            cnn.close();
            ps.close();
        }
    } 
    
    public void eliminar(String idlibro) throws SQLException {

        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps=null;
        try {
            String sql="delete from autor_libro where idlibro=?";
            ps = cnn.prepareStatement(sql);
            ps.setString(1, idlibro);
            ps.executeUpdate();
            sql="delete from libro where idlibro=?";
            ps = cnn.prepareStatement(sql);
            ps.setString(1, idlibro);
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } finally {
            cnn.close();
            ps.close();
        }
    }


   public void  mostrarLibros(DefaultTableModel modelo) throws SQLException {
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps=null;
        String titulos[]={"idlibro","titulo","isbn","editorial","paginas"};
        modelo.getDataVector().removeAllElements();
        modelo.setColumnIdentifiers(titulos);
        try {
            String sql="select * from libro";
            ps=cnn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                String idlibro=rs.getString("idlibro");
                String titulo=rs.getString("titulo");
                String isbn=rs.getString("isbn");
                String editorial=rs.getString("editorial");
                int paginas=rs.getInt("paginas");
                String fila[]={idlibro,titulo,isbn,editorial,String.valueOf(paginas)};
                modelo.addRow(fila);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } finally {
            cnn.close();
            ps.close();
        }
    }

    public void  mostrarPorTitulo(String tit,DefaultTableModel modelo) throws SQLException {
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps=null;
        String titulos[]={"idlibro","titulo","isbn","editorial","paginas"};
        modelo.getDataVector().removeAllElements();
        modelo.setColumnIdentifiers(titulos);

        try {
            String sql="select * from libro where titulo like ?";
            ps=cnn.prepareStatement(sql);
            ps.setString(1, tit+"%");
            rs=ps.executeQuery();
            while (rs.next()) {
                String idlibro=rs.getString("idlibro");
                String titulo=rs.getString("titulo");
                String isbn=rs.getString("isbn");
                String editorial=rs.getString("editorial");
                int paginas=rs.getInt("paginas");
                String fila[]={idlibro,titulo,isbn,editorial,String.valueOf(paginas)};
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
