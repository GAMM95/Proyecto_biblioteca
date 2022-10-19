package presentacion;

import datos.EjemplarDAO;
import entidad.Ejemplar;
import entidad.Libro;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DialogEjemplar extends javax.swing.JDialog {

    Libro libro = null;
    DefaultTableModel modelo = new DefaultTableModel();

    public DialogEjemplar() {
        super(FrmPrincipal.getInstancia(), true);
        initComponents();
        setLocationRelativeTo(null);
        desHabilitar();
        try {
            EjemplarDAO.getInstancia().mostrarEjemplares(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    public void habilitar() {
        btnActualizar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnConsultar.setEnabled(false);
    }

    public void desHabilitar() {
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnConsultar.setEnabled(true);
    }

    public void limpiarEntradas() {
        txtIdejemplar.setText("");
        txtLocalizacion.setText("");
        txtIdlibro.setText("");
        txtTitulo.setText("");
        txtIsbn.setText("");
        txtIdejemplar.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIdejemplar = new javax.swing.JTextField();
        txtLocalizacion = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtIdlibro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtIsbn = new javax.swing.JTextField();
        btnBuscarLibro = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnRestaurar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("idejemplar");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 25, -1, -1));

        jLabel2.setText("localizacion");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));
        getContentPane().add(txtIdejemplar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 80, -1));
        getContentPane().add(txtLocalizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 80, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("LIBRO"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("dilibro");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 45, -1, -1));
        jPanel1.add(txtIdlibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 50, -1));

        jLabel4.setText("titulo");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));
        jPanel1.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 70, -1));

        jLabel5.setText("isbn");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));
        jPanel1.add(txtIsbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 80, -1));

        btnBuscarLibro.setText("...");
        btnBuscarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarLibroActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 270, 160));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 110, -1));

        btnRestaurar.setText("Restaurar");
        btnRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRestaurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 110, -1));

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        getContentPane().add(btnConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 100, -1));

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 110, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 80, -1));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 90, -1));

        jTable1.setModel(modelo);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 490, 230));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String idejemplar = txtIdejemplar.getText();
        String localizacion = txtLocalizacion.getText();

        if (libro != null) {
            Ejemplar x = new Ejemplar(idejemplar, localizacion, libro);
            try {
                EjemplarDAO.getInstancia().insertar(x);
                JOptionPane.showMessageDialog(null, "Dato registrado");
                EjemplarDAO.getInstancia().mostrarEjemplares(modelo);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            limpiarEntradas();
        } else {
            JOptionPane.showMessageDialog(null, "DEBES ESCOGER UN LIBRO");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarActionPerformed
        limpiarEntradas();
        desHabilitar();
    }//GEN-LAST:event_btnRestaurarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // TODO add your handling code here:
        String idejemplar = txtIdejemplar.getText();
        if (idejemplar.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "POR FAVOR INGRESA CODIGO");
        } else {
            try {
                Ejemplar x = EjemplarDAO.getInstancia().buscarEjemplar(idejemplar);
                if (x != null) {
                    txtIdejemplar.setText(x.getIdejemplar());
                    txtLocalizacion.setText(x.getLocalizacion());
                    txtIdlibro.setText(x.getLibro().getIdlibro());
                    txtTitulo.setText(x.getLibro().getTitulo());
                    txtIsbn.setText(x.getLibro().getIsbn());
                    habilitar();
                } else {
                    JOptionPane.showMessageDialog(null, "El idEjemplar no existe");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        try {
            String idejemplar = txtIdejemplar.getText();
            String localizacion = txtLocalizacion.getText();
            Ejemplar x = new Ejemplar(idejemplar, localizacion, libro);
            EjemplarDAO.getInstancia().actualizar(x);
            JOptionPane.showMessageDialog(null, "Dato modificado");
            EjemplarDAO.getInstancia().mostrarEjemplares(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        limpiarEntradas();
        desHabilitar();

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            int resp = JOptionPane.showConfirmDialog(this, "Deseas Eliminarlo ", "Eliminar Dato", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_OPTION) {
                String idejemplar = txtIdejemplar.getText();
                EjemplarDAO.getInstancia().eliminar(idejemplar);
                JOptionPane.showMessageDialog(this, "Registro eliminado");
                EjemplarDAO.getInstancia().mostrarEjemplares(modelo);
            } else {
                JOptionPane.showMessageDialog(null, "El idejemplar no existe");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        limpiarEntradas();
        desHabilitar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarLibroActionPerformed
        DialogBuscarLibro f = new DialogBuscarLibro();
        f.setVisible(true);
        libro = f.libroSelec;
        txtIdlibro.setText(libro.getIdlibro());
        txtTitulo.setText(libro.getTitulo());
        txtIsbn.setText(libro.getIsbn());
    }//GEN-LAST:event_btnBuscarLibroActionPerformed

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
            java.util.logging.Logger.getLogger(DialogEjemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogEjemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogEjemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogEjemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogEjemplar dialog = new DialogEjemplar();
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
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscarLibro;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRestaurar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtIdejemplar;
    private javax.swing.JTextField txtIdlibro;
    private javax.swing.JTextField txtIsbn;
    private javax.swing.JTextField txtLocalizacion;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
