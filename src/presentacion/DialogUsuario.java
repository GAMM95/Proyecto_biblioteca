package presentacion;

import datos.LibroDAO;
import datos.ListaDetalleUsuario;
import datos.UsuarioDAO;
import entidad.DetalleUsuario;
import entidad.Ejemplar;
import entidad.Libro;
import entidad.Usuario;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DialogUsuario extends javax.swing.JDialog {

    DefaultTableModel modeloUsuario = new DefaultTableModel();
    DefaultTableModel modeloEjemplar = new DefaultTableModel();
    
    public DialogUsuario() {
        super(FrmPrincipal.getInstancia(), true);
        initComponents();
        setLocationRelativeTo(null);
        desHabilitar();
        String titulos[]={"idejemplar","localizacion","Fecha Prestamo","Fecha Devolucino","idlibro"};
        modeloEjemplar.setColumnIdentifiers(titulos);
       try {
            UsuarioDAO.getInstancia().mostrarUsuarios(modeloUsuario);
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    
    public void habilitar(){
        btnActualizar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnConsultar.setEnabled(false);
    }
    
     
    public void desHabilitar(){
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnConsultar.setEnabled(true);
    }     
    
    public void limpiarEntradas(){
        txtIdUsuario.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtIdejemplar.setText("");
        txtLocalizacion.setText("");
        String titulos[]={"idejemplar","localizacion","Fecha Prestamo","Fecha Devolucino","idlibro"};
        modeloEjemplar.setDataVector(null, titulos);
        txtIdUsuario.requestFocus();
    }    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIdUsuario = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtIdejemplar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtLocalizacion = new javax.swing.JTextField();
        btnAgregarEjemplar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnEliminarEjemplar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEjemplar = new javax.swing.JTable();
        btnBuscarEjemplar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtFechaPrestamo = new javax.swing.JTextField();
        txtFechaDevolucion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtIdlibro = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnRestaurar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaUsuario = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("idusuario");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 24, -1, 20));

        jLabel2.setText("nombre");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel3.setText("telefono");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jLabel4.setText("direccion");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));
        getContentPane().add(txtIdUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 70, -1));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 180, -1));
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 70, -1));
        getContentPane().add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 70, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ejemplar"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setText("idejemplar");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));
        jPanel1.add(txtIdejemplar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 70, -1));

        jLabel7.setText("localizacion");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));
        jPanel1.add(txtLocalizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 70, -1));

        btnAgregarEjemplar.setText("Agregar Ejemplar");
        btnAgregarEjemplar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEjemplarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarEjemplar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, -1, -1));

        btnEliminarEjemplar.setText("EliminarEjemplar");
        btnEliminarEjemplar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEjemplarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarEjemplar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, -1, -1));

        tablaEjemplar.setModel(modeloEjemplar
        );
        jScrollPane1.setViewportView(tablaEjemplar);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 420, 140));

        btnBuscarEjemplar.setText("...");
        btnBuscarEjemplar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEjemplarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarEjemplar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        jLabel5.setText("Fecha de Prestamo");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel8.setText("Fecha de Devolucion");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));
        jPanel1.add(txtFechaPrestamo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 80, -1));
        jPanel1.add(txtFechaDevolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 80, -1));

        jLabel9.setText("idlibro");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, -1, -1));
        jPanel1.add(txtIdlibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 60, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 460, 340));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 80, -1));

        btnRestaurar.setText("Restaurar");
        btnRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRestaurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 80, -1));

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        getContentPane().add(btnConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 80, 30));

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 90, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 80, 30));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 90, -1));

        tablaUsuario.setModel(modeloUsuario);
        jScrollPane2.setViewportView(tablaUsuario);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 630, 170));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarEjemplarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEjemplarActionPerformed
        // TODO add your handling code here:
        String idejemplar=txtIdejemplar.getText();
        String localizacion=txtLocalizacion.getText();
        String fechaprestamo=txtFechaPrestamo.getText();
        String fechadevolucion=txtFechaDevolucion.getText();
        String idlibro=txtIdlibro.getText();
        String fila[]={idejemplar,localizacion,fechaprestamo,fechadevolucion,idlibro};
        modeloEjemplar.addRow(fila);
        txtIdejemplar.setText("");
        txtLocalizacion.setText("");
        txtFechaPrestamo.setText("");
        txtFechaDevolucion.setText("");
        txtIdejemplar.requestFocus();
    }//GEN-LAST:event_btnAgregarEjemplarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        txtIdejemplar.setText("");
        txtLocalizacion.setText("");
        txtIdejemplar.requestFocus();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarEjemplarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEjemplarActionPerformed
        // TODO add your handling code here:
        int i = tablaEjemplar.getSelectedRow();
        if (i != -1) {
            int rpta = JOptionPane.showConfirmDialog(null, "Esta seguro?", "Eliminar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (rpta == JOptionPane.OK_OPTION) {
                modeloEjemplar.removeRow(i);
            }
        } else
        JOptionPane.showMessageDialog(null, "Seleccione un autor", "Eliminar", 1);
    }//GEN-LAST:event_btnEliminarEjemplarActionPerformed

    private void btnBuscarEjemplarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEjemplarActionPerformed
        // TODO add your handling code here:
        DialogBuscarEjemplar f=new DialogBuscarEjemplar();
        f.setVisible(true);
        Ejemplar ejemplar = f.ejemplarSelec;
        txtIdejemplar.setText(ejemplar.getIdejemplar());
        txtLocalizacion.setText(ejemplar.getLocalizacion());
        txtIdlibro.setText(ejemplar.getLibro().getIdlibro());
    }//GEN-LAST:event_btnBuscarEjemplarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        try{
            String idusuario=txtIdUsuario.getText();
            String nombre=txtNombre.getText();
            String telefono=txtTelefono.getText();
            String direccion=txtDireccion.getText();
            Usuario usuario=new Usuario(idusuario,nombre,telefono,direccion);
            int nfilas = modeloEjemplar.getRowCount();
            for (int i = 0; i < nfilas; i++) {
                String idejemplar = modeloEjemplar.getValueAt(i, 0).toString();
                String localizacion = modeloEjemplar.getValueAt(i, 1).toString();
                String fechaprestamo=modeloEjemplar.getValueAt(i, 2).toString();
                String fechadevolucion=modeloEjemplar.getValueAt(i, 3).toString();
                String idlibro=modeloEjemplar.getValueAt(i, 4).toString();
                Libro libro=LibroDAO.getInstancia().buscarLibro(idlibro);
                Ejemplar ejemplar=new Ejemplar(idejemplar,localizacion,libro);
                DetalleUsuario det=new DetalleUsuario(ejemplar,fechaprestamo,fechadevolucion);
                usuario.registrarDetalleUsuario(det);
            }
            UsuarioDAO.getInstancia().insertar(usuario);
            UsuarioDAO.getInstancia().mostrarUsuarios(modeloUsuario);
            JOptionPane.showMessageDialog(null, "Libro registrado");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        limpiarEntradas();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarActionPerformed
        // TODO add your handling code here:
        limpiarEntradas();
        desHabilitar();
    }//GEN-LAST:event_btnRestaurarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // TODO add your handling code here:
        String idusuario = txtIdUsuario.getText();
        if(idusuario.equalsIgnoreCase(""))
            JOptionPane.showMessageDialog(null, "POR FAVOR INGRESA idusuario");
        else
        {
            try {
                Usuario x = UsuarioDAO.getInstancia().buscarUsuario(idusuario);
                if(x!=null) {
                    txtIdUsuario.setText(x.getIdusuario());
                    txtNombre.setText(x.getNombre());
                    txtTelefono.setText(x.getTelefono());
                    txtDireccion.setText(x.getDireccion());
                    ListaDetalleUsuario LD=x.getLD();
                    modeloEjemplar.getDataVector().removeAllElements();
                    for(int i=0;i<LD.getN();i++)
                    {
                        DetalleUsuario det = LD.getElemento(i);
                        String idejemplar=det.getEjemplar().getIdejemplar();
                        String localizacion =det.getEjemplar().getLocalizacion();
                        String fechaprestamo=det.getFechaPrestamo();
                        String fechadevolucion=det.getFechaDevolucion();
                        String idlibro=det.getEjemplar().getLibro().getIdlibro();
                        String fila[]={idejemplar,localizacion,fechaprestamo,fechadevolucion,idlibro};
                        modeloEjemplar.addRow(fila);
                    }
                    habilitar();
                }
                else
                JOptionPane.showMessageDialog(null,"El idlibro no existe");
            }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        try{
            String idusuario=txtIdUsuario.getText();
            String nombre=txtNombre.getText();
            String telefono=txtTelefono.getText();
            String direccion=txtDireccion.getText();
            Usuario usuario=new Usuario(idusuario,nombre,telefono,direccion);
            int nfilas = modeloEjemplar.getRowCount();

            for (int i = 0; i < nfilas; i++) {
                String idejemplar = modeloEjemplar.getValueAt(i, 0).toString();
                String localizacion = modeloEjemplar.getValueAt(i, 1).toString();
                String fechaprestamo=modeloEjemplar.getValueAt(i, 2).toString();
                String fechadevolucion=modeloEjemplar.getValueAt(i, 3).toString();
                String idlibro=modeloEjemplar.getValueAt(i, 4).toString();
                Libro libro=LibroDAO.getInstancia().buscarLibro(idlibro);
                Ejemplar ejemplar=new Ejemplar(idejemplar,localizacion,libro);
                DetalleUsuario det=new DetalleUsuario(ejemplar,fechaprestamo,fechadevolucion);
                usuario.registrarDetalleUsuario(det);
            }
            UsuarioDAO.getInstancia().actualizar(usuario);
            UsuarioDAO.getInstancia().mostrarUsuarios(modeloUsuario);
            JOptionPane.showMessageDialog(null, "Usuario modificado");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        limpiarEntradas();
        desHabilitar();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try{
            int resp= JOptionPane.showConfirmDialog(this,"Deseas Eliminarlo ","Eliminar Dato",JOptionPane.YES_NO_OPTION );
            if( resp == JOptionPane.YES_OPTION )
            {
                String idusuario=txtIdUsuario.getText();
                UsuarioDAO.getInstancia().eliminar(idusuario);
                JOptionPane.showMessageDialog(this,"Registro eliminado");
                UsuarioDAO.getInstancia().mostrarUsuarios(modeloUsuario);
            }
            else
            JOptionPane.showMessageDialog(null,"El idusuario no existe");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        limpiarEntradas();
        desHabilitar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        dispose();

    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(DialogUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogUsuario dialog = new DialogUsuario();
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
    private javax.swing.JButton btnAgregarEjemplar;
    private javax.swing.JButton btnBuscarEjemplar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarEjemplar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRestaurar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaEjemplar;
    private javax.swing.JTable tablaUsuario;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFechaDevolucion;
    private javax.swing.JTextField txtFechaPrestamo;
    private javax.swing.JTextField txtIdUsuario;
    private javax.swing.JTextField txtIdejemplar;
    private javax.swing.JTextField txtIdlibro;
    private javax.swing.JTextField txtLocalizacion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}