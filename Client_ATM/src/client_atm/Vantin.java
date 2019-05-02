/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_atm;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quang Ha
 */
public class Vantin extends javax.swing.JFrame {

    User user;
    /**
     * Creates new form Vantin
     */
    public Vantin() {
        initComponents();
        setLocationRelativeTo(null);
        user = new User();
        inquiry();
    }
    private void inquiry(){
        try {
            setValue(user.bank.inquiry(Login.userInfo.get(0), Login.userInfo.get(1)));
        } catch (RemoteException ex) {
            Logger.getLogger(Vantin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Vantin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        lbten = new javax.swing.JLabel();
        lbaddress = new javax.swing.JLabel();
        lbphone = new javax.swing.JLabel();
        lbnumAcc = new javax.swing.JLabel();
        lbsodu = new javax.swing.JLabel();
        lbcmnd = new javax.swing.JLabel();
        lbresult = new javax.swing.JLabel();
        btBack = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbten.setText("Họ tên : ");

        lbaddress.setText("Địa chỉ :");

        lbphone.setText("Số điện thoại : ");

        lbnumAcc.setText("Số tài khoản : ");

        lbsodu.setText("Số dư : ");

        lbcmnd.setText("Số cmnd : ");

        lbresult.setText("Thông tin của người dùng : ");

        btBack.setText("Back");
        btBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbresult)
                            .addComponent(lbcmnd)
                            .addComponent(lbsodu)
                            .addComponent(lbnumAcc)
                            .addComponent(lbaddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbphone, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(btBack, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lbaddress, lbcmnd, lbnumAcc, lbphone, lbsodu, lbten});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(lbresult)
                .addGap(18, 18, 18)
                .addComponent(lbten)
                .addGap(18, 18, 18)
                .addComponent(lbaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbphone)
                .addGap(18, 18, 18)
                .addComponent(lbnumAcc)
                .addGap(18, 18, 18)
                .addComponent(lbcmnd)
                .addGap(18, 18, 18)
                .addComponent(lbsodu)
                .addGap(18, 18, 18)
                .addComponent(btBack)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBackActionPerformed
        new GUI().setVisible(true);
        dispose();
    }//GEN-LAST:event_btBackActionPerformed

    private void setValue(ArrayList<String> result){
        lbten.setText(lbten.getText()+ result.get(0));
        lbaddress.setText(lbaddress.getText()+result.get(1));
        lbphone.setText(lbphone.getText()+result.get(2));
        lbnumAcc.setText(lbnumAcc.getText()+result.get(3));
        lbcmnd.setText(lbcmnd.getText()+result.get(4));
        lbsodu.setText(lbsodu.getText()+result.get(5));   
    }
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
            java.util.logging.Logger.getLogger(Vantin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vantin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vantin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vantin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vantin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBack;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lbaddress;
    private javax.swing.JLabel lbcmnd;
    private javax.swing.JLabel lbnumAcc;
    private javax.swing.JLabel lbphone;
    private javax.swing.JLabel lbresult;
    private javax.swing.JLabel lbsodu;
    private javax.swing.JLabel lbten;
    // End of variables declaration//GEN-END:variables
}