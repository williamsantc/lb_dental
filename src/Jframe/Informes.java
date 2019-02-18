package Jframe;

import CRUD.CRUD_cita;
import CRUD.CRUD_doctor;
import CRUD.CRUD_incidenciacita;
import CRUD.CRUD_paciente;
import CRUD.CRUD_persona;
import Clases.cita;
import Clases.doctor;
import Clases.incidenciacita;
import Clases.paciente;
import Clases.persona;
import java.awt.Image;
import java.text.DateFormat;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Informes extends javax.swing.JFrame {

    DateFormat df = DateFormat.getDateInstance();

    CRUD_persona persCRUD = new CRUD_persona();
    CRUD_paciente paciCRUD = new CRUD_paciente();
    CRUD_doctor doctCRUD = new CRUD_doctor();
    CRUD_cita citaCRUD = new CRUD_cita();
    CRUD_incidenciacita inciCRUD = new CRUD_incidenciacita();

    ArrayList<persona> listaPersona = null;
    ArrayList<paciente> listaPaciente = null;
    ArrayList<doctor> listaDoctor = null;
    ArrayList<cita> listacita = null;
    ArrayList<incidenciacita> listaincicencia = null;

    public Informes() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("INFORMES");
//        this.setResizable(false);

        ImageIcon imagen = new ImageIcon("src/Img/05.jpg");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT));
        fondo.setIcon(icono);
        this.repaint();

        this.listaPersona = persCRUD.listarObject();
        this.listaPaciente = paciCRUD.listarObject();
        this.listaDoctor = doctCRUD.listarObject();
        this.listacita = citaCRUD.listarObject();
        this.listaincicencia = inciCRUD.listarObject();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCitas = new javax.swing.JTable();
        Infpac = new javax.swing.JButton();
        infcit = new javax.swing.JButton();
        infmed = new javax.swing.JButton();
        btnsal2 = new javax.swing.JButton();
        btnfiltro = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla2 = new javax.swing.JTable();
        Filtro = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tablaCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NOMBRE", "CEDULA", "EDAD", "TELF"
            }
        ));
        jScrollPane1.setViewportView(tablaCitas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 550, 130));

        Infpac.setText("Inf Pacientes");
        Infpac.setBorderPainted(false);
        Infpac.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Infpac.setDefaultCapable(false);
        Infpac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InfpacActionPerformed(evt);
            }
        });
        getContentPane().add(Infpac, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        infcit.setText("Inf Citas");
        infcit.setBorderPainted(false);
        infcit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        infcit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infcitActionPerformed(evt);
            }
        });
        getContentPane().add(infcit, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 80, -1));

        infmed.setText("Inf Medicos");
        infmed.setBorderPainted(false);
        infmed.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        infmed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infmedActionPerformed(evt);
            }
        });
        getContentPane().add(infmed, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, -1, -1));

        btnsal2.setText("SALIR");
        btnsal2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsal2MouseClicked(evt);
            }
        });
        getContentPane().add(btnsal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 510, -1, 30));

        btnfiltro.setText("Filtro de citas");
        btnfiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfiltroActionPerformed(evt);
            }
        });
        getContentPane().add(btnfiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        jScrollPane3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tabla2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NOMBRE", "CEDULA", "EDAD", "TELF"
            }
        ));
        jScrollPane3.setViewportView(tabla2);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 550, 130));
        getContentPane().add(Filtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 220, -1));

        jLabel1.setFont(new java.awt.Font("Elephant", 3, 36)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("Informes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 580, 10));
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InfpacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InfpacActionPerformed
//        obj.mostrarpaci(obj.Mpac);
        paciCRUD.listarTable(tabla2);
    }//GEN-LAST:event_InfpacActionPerformed

    private void infcitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infcitActionPerformed
        citaCRUD.listarTable(tabla2);
    }//GEN-LAST:event_infcitActionPerformed

    private void infmedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infmedActionPerformed
        doctCRUD.listarTable(tabla2);
    }//GEN-LAST:event_infmedActionPerformed

    private void btnsal2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsal2MouseClicked
        Principal pri = new Principal();
        pri.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnsal2MouseClicked

    private void btnfiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfiltroActionPerformed
        if (this.Filtro.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Campos incompletos", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            citaCRUD.listarCitaFiltrada(tablaCitas, Filtro.getDate());
        }

    }//GEN-LAST:event_btnfiltroActionPerformed

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
            java.util.logging.Logger.getLogger(Informes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Informes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Informes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Informes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Informes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Filtro;
    private javax.swing.JButton Infpac;
    private javax.swing.JButton btnfiltro;
    private javax.swing.JButton btnsal2;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton infcit;
    private javax.swing.JButton infmed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tabla2;
    private javax.swing.JTable tablaCitas;
    // End of variables declaration//GEN-END:variables
}
