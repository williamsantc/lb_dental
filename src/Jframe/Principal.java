
package Jframe;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("LABORATORIO DENTAL");
//        this.setResizable(false);
        
        
        ImageIcon imagen=new ImageIcon("src/Img/focus_2.jpg");
        Icon icono=new ImageIcon(imagen.getImage().getScaledInstance(fondo.getWidth(),fondo.getHeight(),Image.SCALE_DEFAULT));
        fondo.setIcon(icono);
        this.repaint();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        inf = new javax.swing.JButton();
        btnsal = new javax.swing.JButton();
        btnmed = new javax.swing.JButton();
        btncit = new javax.swing.JButton();
        btnpac = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(java.awt.Color.gray);
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inf.setBackground(new java.awt.Color(102, 102, 102));
        inf.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        inf.setForeground(java.awt.Color.white);
        inf.setText("Informes");
        inf.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        inf.setBorderPainted(false);
        inf.setContentAreaFilled(false);
        inf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infActionPerformed(evt);
            }
        });
        jPanel1.add(inf, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 30));

        btnsal.setText("Salir");
        btnsal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnsal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalActionPerformed(evt);
            }
        });
        getContentPane().add(btnsal, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 470, 80, 30));

        btnmed.setText("Medicos");
        btnmed.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnmed.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnmed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnmedMouseClicked(evt);
            }
        });
        btnmed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmedActionPerformed(evt);
            }
        });
        getContentPane().add(btnmed, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 90, 30));

        btncit.setText("Citas");
        btncit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btncit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncitMouseClicked(evt);
            }
        });
        getContentPane().add(btncit, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 90, 30));

        btnpac.setText("Pacientes");
        btnpac.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnpac.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnpac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnpacMouseClicked(evt);
            }
        });
        getContentPane().add(btnpac, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 90, 30));

        jLabel1.setFont(new java.awt.Font("Monotype Corsiva", 1, 60)); // NOI18N
        jLabel1.setForeground(java.awt.Color.blue);
        jLabel1.setText("Bienvenido");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 310, 10));
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnsalActionPerformed

    private void btnpacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpacMouseClicked
        Pacientes pac=new Pacientes();
        pac.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnpacMouseClicked

    private void btnmedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmedMouseClicked
        Medicos pac=new Medicos();
        pac.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnmedMouseClicked

    private void btncitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncitMouseClicked
        Citas pac=new Citas();
        pac.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btncitMouseClicked

    private void infActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infActionPerformed
        Informes pac=new Informes();
        pac.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_infActionPerformed

    private void btnmedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnmedActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncit;
    private javax.swing.JButton btnmed;
    private javax.swing.JButton btnpac;
    private javax.swing.JButton btnsal;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton inf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
