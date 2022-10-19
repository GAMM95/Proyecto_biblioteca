package presentacion;

import datos.EjemplarDAO;
import datos.LibroDAO;
import entidad.Autor;
import entidad.Ejemplar;
import entidad.Libro;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class DialogBuscarEjemplar extends javax.swing.JDialog {

      DefaultTableModel modelo = new DefaultTableModel();
      Ejemplar ejemplarSelec = new Ejemplar();
    
    
    public DialogBuscarEjemplar() {
        super(FrmPrincipal.getInstancia(), true);
        setLocationRelativeTo(null);
        initComponents();
         try {
               EjemplarDAO.getInstancia().mostrarEjemplares(modelo);
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtLocalizacion = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnTodos = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tabla.setModel(modelo);
        jScrollPane1.setViewportView(Tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 482, 275));

        jLabel1.setText("Localizacion");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 37, -1, -1));

        txtLocalizacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLocalizacionKeyReleased(evt);
            }
        });
        getContentPane().add(txtLocalizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 34, 184, -1));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 33, -1, -1));

        btnTodos.setText("Todos");
        btnTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodosActionPerformed(evt);
            }
        });
        getContentPane().add(btnTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 65, -1));

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 74, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLocalizacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLocalizacionKeyReleased
        String localizacion=txtLocalizacion.getText();
        try {
            EjemplarDAO.getInstancia().mostrarPorLocalizacion(localizacion, modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_txtLocalizacionKeyReleased

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String localizacion=txtLocalizacion.getText();
        try {
            EjemplarDAO.getInstancia().mostrarPorLocalizacion(localizacion, modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodosActionPerformed
        try {
            EjemplarDAO.getInstancia().mostrarEjemplares(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }//GEN-LAST:event_btnTodosActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        int i = Tabla.getSelectedRow();
        if(i!=-1)
        {
            ejemplarSelec.setIdejemplar(modelo.getValueAt(i, 0).toString());
            ejemplarSelec.setLocalizacion(modelo.getValueAt(i, 1).toString());
            Libro libro=null;
            try {
                 String idlibro=modelo.getValueAt(i, 2).toString();
                 libro=LibroDAO.getInstancia().buscarLibro(idlibro);
                 ejemplarSelec.setLibro(libro);
             } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(null,ex.getMessage());
             }
            this.dispose();
        }
        else
             JOptionPane.showMessageDialog(null, "Debes Seleccionar un elemento");
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DialogBuscarEjemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogBuscarEjemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogBuscarEjemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogBuscarEjemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogBuscarEjemplar dialog = new DialogBuscarEjemplar();
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JButton btnTodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtLocalizacion;
    // End of variables declaration//GEN-END:variables
}
