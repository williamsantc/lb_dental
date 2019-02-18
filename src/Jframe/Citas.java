package Jframe;

import CRUD.CRUD_cita;
import CRUD.CRUD_doctor;
import CRUD.CRUD_paciente;
import CRUD.CRUD_persona;
import Clases.*;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.text.DateFormat;
import java.util.ArrayList;

public class Citas extends javax.swing.JFrame {

    CRUD_persona persCRUD = new CRUD_persona();
    CRUD_paciente paciCRUD = new CRUD_paciente();
    CRUD_doctor doctCRUD = new CRUD_doctor();
    CRUD_cita citaCRUD = new CRUD_cita();

    ArrayList<persona> listaPersona = null;
    ArrayList<paciente> listaPaciente = null;
    ArrayList<doctor> listaDoctor = null;

    DateFormat df = DateFormat.getDateInstance();

    public Citas() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("CITAS");
//        this.setResizable(false);

        ImageIcon imagen = new ImageIcon("src/Img/focus_2.jpg");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT));
        fondo.setIcon(icono);
        this.repaint();
        this.cbox_doctor = doctCRUD.listarCombo(cbox_doctor);
        this.cbox_paciente = paciCRUD.listarCombo(cbox_paciente);
        this.listaPersona = persCRUD.listarObject();
        this.listaPaciente = paciCRUD.listarObject();
        this.listaDoctor = doctCRUD.listarObject();
        this.cbox_doctor.setSelectedItem(null);
        this.cbox_paciente.setSelectedItem(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_hora = new javax.swing.JTextField();
        btnreg = new javax.swing.JButton();
        btnsal4 = new javax.swing.JButton();
        fecha_ingresada = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        cbox_paciente = new javax.swing.JComboBox<>();
        cbox_doctor = new javax.swing.JComboBox<>();
        fecha_generada = new com.toedter.calendar.JDateChooser();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("HORA:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, -1, 30));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("PACIENTE:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 80, 30));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("DOCTOR:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, -1, 30));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText(" FECHA:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, -1, 30));
        getContentPane().add(txt_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 100, -1));

        btnreg.setText("REGISTRARSE");
        btnreg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnreg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregActionPerformed(evt);
            }
        });
        getContentPane().add(btnreg, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, -1, -1));

        btnsal4.setText("SALIR");
        btnsal4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsal4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsal4MouseClicked(evt);
            }
        });
        getContentPane().add(btnsal4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 440, -1, -1));
        getContentPane().add(fecha_ingresada, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 200, 30));

        jLabel7.setFont(new java.awt.Font("Elephant", 3, 36)); // NOI18N
        jLabel7.setText("Registro de Citas");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        getContentPane().add(cbox_paciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 220, 30));

        getContentPane().add(cbox_doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 220, 30));
        getContentPane().add(fecha_generada, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 200, 30));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 580, 10));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("FECHA CITA:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, -1, -1));
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsal4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsal4MouseClicked
        Principal pri = new Principal();
        pri.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnsal4MouseClicked

    private void btnregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregActionPerformed
//        if(txt_docpaciente.getText().isEmpty() || txt_docdoctor.getText().isEmpty() || txtmedico.getText().isEmpty() || txthora.getText().isEmpty()){
//            JOptionPane.showMessageDialog(null, "Hay campos de textos vacios","ERROR",JOptionPane.ERROR_MESSAGE);
//        }else{
//            int r=obj.vercit(txt_docdoctor.getText());
//            if(r==1){
//                JOptionPane.showMessageDialog(null, "Registro no valido. Cedula ya esta registrada","ERROR",JOptionPane.ERROR_MESSAGE);
//            }else{
//                Clases.Citas citas=new Clases.Citas(txt_docpaciente.getText(),txt_docdoctor.getText(),df.format(fecha_ingresada.getDate()),txtmedico.getText(),txthora.getText());
//                obj.liscit.add(citas);
//
//                obj.Mcit=new String[obj.liscit.size()][5];
//                fecha_ingresada.setDate(null);
//                txt_docpaciente.setText(null);
//                txt_docdoctor.setText(null);
//                txtmedico.setText(null);
//                txthora.setText(null);
//            }
//        }
        if (cbox_paciente.getSelectedIndex() < 0 || cbox_doctor.getSelectedIndex() < 0 || txt_hora.getText().isEmpty() || fecha_ingresada.getDate() == null || fecha_generada.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Campos incompletos", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            cita cita = new cita(-1, listaPaciente.get(cbox_paciente.getSelectedIndex()).getpers_id(), listaDoctor.get(cbox_doctor.getSelectedIndex()).getpers_id(), txt_hora.getText(), (new java.sql.Date(fecha_ingresada.getDate().getTime())), (new java.sql.Date(fecha_generada.getDate().getTime())));
            if (citaCRUD.registro(cita)) {
                JOptionPane.showMessageDialog(null, "Cita registrada correctamente", "OK", JOptionPane.INFORMATION_MESSAGE);
                fecha_ingresada.setDate(null);
                fecha_generada.setDate(null);
                txt_hora.setText(null);
                cbox_paciente.setSelectedItem(null);
                cbox_doctor.setSelectedItem(null);

            }
        }

    }//GEN-LAST:event_btnregActionPerformed

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
            java.util.logging.Logger.getLogger(Citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Citas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnreg;
    private javax.swing.JButton btnsal4;
    private javax.swing.JComboBox<String> cbox_doctor;
    private javax.swing.JComboBox<String> cbox_paciente;
    private com.toedter.calendar.JDateChooser fecha_generada;
    private com.toedter.calendar.JDateChooser fecha_ingresada;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txt_hora;
    // End of variables declaration//GEN-END:variables
}
