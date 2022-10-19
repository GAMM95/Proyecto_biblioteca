package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    private static Conexion instancia;

    public static Conexion getInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    private Conexion() {
    }

    public Connection miConexion() {

        Connection cn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println("Error no se puede cargar el driver:" + e.getMessage());
        }

        try {

            String url = "jdbc:mysql://localhost:3306/biblioteca_informatica?useSSL=false";
            String user = "root";
            String password = "abc123";
            cn = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            System.out.println("Error no se establecer la conexion:" + e.getMessage());
        }

        return cn;
    }

    public static void main(String[] argumentos) {
        try {
            JOptionPane.showMessageDialog(null, Conexion.getInstancia(), "Conexion establecida", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se pudo establecer la conexion\nRevisar Driver" + ex.getMessage(), "Error de conexión", JOptionPane.ERROR_MESSAGE);

        }
    }
}
