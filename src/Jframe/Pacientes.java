package Jframe;

import CRUD.CRUD_paciente;
import CRUD.CRUD_persona;
import Clases.paciente;
import Clases.persona;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Pacientes extends javax.swing.JFrame {

    CRUD_persona persCRUD = new CRUD_persona();
    CRUD_paciente paciCRUD = new CRUD_paciente();
    int idPersona = -1;

    public Pacientes() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("PACIENTES");
//        this.setResizable(false);

        ImageIcon imagen = new ImageIcon("src/Img/focus_2.jpg");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT));
        fondo.setIcon(icono);
        this.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_apellido = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        btnregistro = new javax.swing.JButton();
        btnsal2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_documento = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        btn_buscar = new javax.swing.JButton();
        txt_email = new javax.swing.JTextField();
        btn_modificar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("* TELEFONO:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, -1, 30));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("NOMBRE:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, -1, 30));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setText("APELLIDO:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, -1, 30));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setText("DIRECCION:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, -1, 30));

        txt_telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_telefonoKeyTyped(evt);
            }
        });
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, 200, -1));

        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreKeyTyped(evt);
            }
        });
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 200, -1));

        txt_apellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_apellidoKeyTyped(evt);
            }
        });
        getContentPane().add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 200, -1));

        txt_direccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_direccionKeyTyped(evt);
            }
        });
        getContentPane().add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 200, -1));

        btnregistro.setText("REGISTRARSE");
        btnregistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnregistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnregistroMouseClicked(evt);
            }
        });
        btnregistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistroActionPerformed(evt);
            }
        });
        getContentPane().add(btnregistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 120, -1));

        btnsal2.setText("SALIR");
        btnsal2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsal2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsal2MouseClicked(evt);
            }
        });
        btnsal2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsal2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnsal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 440, -1, 30));

        jLabel5.setFont(new java.awt.Font("Elephant", 3, 36)); // NOI18N
        jLabel5.setText("Registro de Pacientes");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DOCUMENTO:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, -1, -1));
        getContentPane().add(txt_documento, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 200, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 570, 10));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(java.awt.Color.white);
        jLabel7.setText("EMAIL");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, -1, 30));

        btn_buscar.setText("BUSCAR");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 90, 30));

        txt_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_emailKeyTyped(evt);
            }
        });
        getContentPane().add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, 200, -1));

        btn_modificar.setText("MODIFICAR");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 370, -1, -1));

        btn_limpiar.setText("LIMPIAR");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 420, -1, -1));
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsal2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsal2MouseClicked
        Principal pri = new Principal();
        pri.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnsal2MouseClicked

    private void txt_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyTyped
        char vali = evt.getKeyChar();
        if (Character.isDigit(vali)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingrese solo letras");
        }
    }//GEN-LAST:event_txt_nombreKeyTyped

    private void txt_apellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_apellidoKeyTyped
//        char vali = evt.getKeyChar();
//        if (Character.isLetter(vali)) {
//            getToolkit().beep();
//            evt.consume();
//            JOptionPane.showMessageDialog(rootPane, "Ingrese solo numeros");
//        }
    }//GEN-LAST:event_txt_apellidoKeyTyped

    private void txt_direccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_direccionKeyTyped
        char vali = evt.getKeyChar();
        if (Character.isLetter(vali)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingrese solo numeros");
        }
    }//GEN-LAST:event_txt_direccionKeyTyped

    private void txt_telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telefonoKeyTyped
        char vali = evt.getKeyChar();
        if (Character.isLetter(vali)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingrese solo numeros");
        }
    }//GEN-LAST:event_txt_telefonoKeyTyped

    private void btnregistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnregistroMouseClicked

    }//GEN-LAST:event_btnregistroMouseClicked

    private void btnsal2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsal2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnsal2ActionPerformed

    private void btnregistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistroActionPerformed
        // TODO add your handling code here:
        idPersona = -1;
        if (txt_nombre.getText().isEmpty() || txt_apellido.getText().isEmpty() || txt_direccion.getText().isEmpty() || txt_telefono.getText().isEmpty() || txt_documento.getText().isEmpty() || txt_email.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Hay campos de textos vacios", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            if (persCRUD.existePersona(txt_documento.getText())) {
                JOptionPane.showMessageDialog(null, "Registro no valido. Cedula ya esta registrada", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {

                persona persona = new persona(-1, txt_documento.getText(), txt_nombre.getText(), txt_apellido.getText(), txt_telefono.getText(), txt_email.getText());

                if (persCRUD.registro(persona)) {

                    idPersona = persCRUD.buscarIdPorDocumento(txt_documento.getText());

                    paciente paciente = new paciente(idPersona, txt_direccion.getText());

                    if (paciCRUD.registro(paciente)) {
                        JOptionPane.showMessageDialog(null, "¡Registro exitoso!", "OK", JOptionPane.INFORMATION_MESSAGE);
                    }
                }

            }
            this.limpiarCampos();
        }
    }//GEN-LAST:event_btnregistroActionPerformed

    private void txt_emailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_emailKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailKeyTyped

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        // TODO add your handling code here:
        idPersona = -1;
        if (txt_documento.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresar documento", "OK", JOptionPane.INFORMATION_MESSAGE);

        } else {
            ArrayList<persona> listaPersona = persCRUD.listarObject();
            idPersona = -1;
            for (persona object : listaPersona) {
                if (object.getpers_documento().equalsIgnoreCase(txt_documento.getText()) && paciCRUD.esPaciente(txt_documento.getText())) {
                    idPersona = object.getpers_id();
                    txt_nombre.setText(object.getpers_nombre());
                    txt_apellido.setText(object.getpers_apellido());
                    txt_email.setText(object.getpers_correo());
                    txt_documento.setText(object.getpers_documento());
                    txt_telefono.setText(object.getpers_telefono());
                    break;
                }
            }
            if (idPersona == -1) {
                JOptionPane.showMessageDialog(null, "Paciente no encontrado", "OK", JOptionPane.INFORMATION_MESSAGE);
            } else {
                ArrayList<paciente> listaPaciente = paciCRUD.listarObject();
                for (paciente object : listaPaciente) {
                    if (object.getpers_id() == idPersona) {
                        txt_direccion.setText(object.getpaci_direccion());
                        break;
                    }
                }
            }
        }

    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        // TODO add your handling code here:
        this.limpiarCampos();
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        // TODO add your handling code here:
        if (txt_nombre.getText().isEmpty() || txt_apellido.getText().isEmpty() || txt_direccion.getText().isEmpty() || txt_telefono.getText().isEmpty() || txt_documento.getText().isEmpty() || txt_email.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Hay campos de textos vacios", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            persona persona = new persona(this.idPersona, txt_documento.getText(), txt_nombre.getText(), txt_apellido.getText(), txt_telefono.getText(), txt_email.getText());
            if (persCRUD.modificar(persona)) {
                paciente paciente = new paciente(idPersona, txt_direccion.getText());

                if (paciCRUD.modificar(paciente)) {
                    JOptionPane.showMessageDialog(null, "Su modificacion fue exitosa!!", "OK", JOptionPane.INFORMATION_MESSAGE);
                    this.limpiarCampos();
                    idPersona = -1;
                }
            }
        }


    }//GEN-LAST:event_btn_modificarActionPerformed

    private void limpiarCampos() {
        txt_nombre.setText(null);
        txt_apellido.setText(null);
        txt_direccion.setText(null);
        txt_email.setText(null);
        txt_documento.setText(null);
        txt_telefono.setText(null);
    }

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
            java.util.logging.Logger.getLogger(Pacientes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pacientes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pacientes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pacientes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pacientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btnregistro;
    private javax.swing.JButton btnsal2;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_documento;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
