package presentacion;

import datos.LibroDAO;
import entidad.Libro;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class DialogBuscarLibro extends javax.swing.JDialog {

    DefaultTableModel modelo = new DefaultTableModel();
    Libro libroSelec = new Libro();
    
    public DialogBuscarLibro() {
        super(FrmPrincipal.getInstancia(),true);
        setLocationRelativeTo(null);        
        initComponents();
        try {
               LibroDAO.getInstancia().mostrarLibros(modelo);
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
        txtTitulo = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnTodos = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CONSULTAR LIBRO");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tabla.setModel(modelo);
        jScrollPane1.setViewportView(Tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 482, 275));

        jLabel1.setText("Titulo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 37, -1, -1));

        txtTitulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTituloKeyReleased(evt);
            }
        });
        getContentPane().add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 34, 184, -1));

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
        getContentPane().add(btnTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 65, -1));

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 74, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTituloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTituloKeyReleased
        String titulo=txtTitulo.getText();

        try {
            LibroDAO.getInstancia().mostrarPorTitulo(titulo, modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_txtTituloKeyReleased

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String titulo=txtTitulo.getText();

        try {
            LibroDAO.getInstancia().mostrarPorTitulo(titulo, modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodosActionPerformed
        try {
               LibroDAO.getInstancia().mostrarLibros(modelo);
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }//GEN-LAST:event_btnTodosActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        int i = Tabla.getSelectedRow();
        if(i!=-1)
        {
            libroSelec.setIdlibro(modelo.getValueAt(i, 0).toString());
            libroSelec.setTitulo(modelo.getValueAt(i, 1).toString());
            libroSelec.setIsbn(modelo.getValueAt(i, 2).toString());
            libroSelec.setEditorial(modelo.getValueAt(i, 3).toString());
            libroSelec.setPaginas(Integer.parseInt(modelo.getValueAt(i, 4).toString()));
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
            java.util.logging.Logger.getLogger(DialogBuscarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogBuscarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogBuscarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogBuscarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogBuscarLibro dialog = new DialogBuscarLibro();
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
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
