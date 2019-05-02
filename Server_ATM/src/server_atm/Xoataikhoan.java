/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_atm;

import common_atm.User;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Quang Ha
 */
public class Xoataikhoan extends javax.swing.JFrame {

    Server_ATM server;
    Connection cont,cont1;
    
    /**
     * Creates new form Xoataikhoan
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public Xoataikhoan() throws SQLException, ClassNotFoundException {
        initComponents();
        setLocationRelativeTo(null);
        try {
            server = new Server_ATM();
            cont = server.cont;
            cont1 = server.cont1;
        } catch (RemoteException ex) {
            Logger.getLogger(Xoataikhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        //utils = new Utils();
        //this.cont=utils.cont;
//        Registry registry;
//        try {
//            registry = LocateRegistry.getRegistry("localhost",1996);
//            bank=(Bank) registry.lookup("atm");
//        } catch (RemoteException ex) {
//            Logger.getLogger(Xoataikhoan.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (NotBoundException ex) {
//            Logger.getLogger(Xoataikhoan.class.getName()).log(Level.SEVERE, null, ex);
//        }
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
        tfnumAccount = new javax.swing.JTextField();
        tfcmnd = new javax.swing.JTextField();
        btOk = new javax.swing.JButton();
        btBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Số tài khoản : ");

        jLabel2.setText("Số cmnd       :");

        tfcmnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfcmndActionPerformed(evt);
            }
        });

        btOk.setText("Ok");
        btOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOkActionPerformed(evt);
            }
        });

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
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfnumAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfcmnd, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(btOk, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btBack, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfnumAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfcmnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btOk)
                    .addComponent(btBack))
                .addContainerGap(88, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfcmndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfcmndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfcmndActionPerformed

    private boolean validation(){
        return !(tfnumAccount.getText().equals("")||tfcmnd.getText().equals(""));
    }
    
    private void reset(){
        tfcmnd.setText("");
        tfnumAccount.setText("");
    }
    private void deleteAccount(User user) throws SQLException{
        String sql;
        PreparedStatement ps;
        if(user.getId_parent()!=0){
            sql = "delete user,account,user_account from user inner join user_account on "
                    + "user.id=user_account.id_user inner join account on "
                    + "user_account.id_account=account.id "
                    + "where user.id=?";
            ps=cont.prepareStatement(sql);
            ps.setInt(1, user.getId());   
            ps.executeUpdate();
            //backup dữ liệu
            ps=cont1.prepareStatement(sql);
            ps.setInt(1, user.getId());   
            ps.executeUpdate();
        }else{
            sql = "delete user,account,user_account from user inner join user_account on "
                    + "user.id=user_account.id_user inner join account on "
                    + "user_account.id_account=account.id "
                    + "where user.id=? or user.id_parent=?";
            ps=cont.prepareStatement(sql);
            ps.setInt(1, user.getId());
            ps.setInt(2, user.getId());
            ps.executeQuery();
            //backup dữ liệu
            ps=cont1.prepareStatement(sql);
            ps.setInt(1, user.getId());
            ps.setInt(2, user.getId());
            ps.executeUpdate();
        }
    }
    
    private void btOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOkActionPerformed
        try {
            if(validation()){
                User user = server.getUser(tfnumAccount.getText(), tfcmnd.getText());
                if(user==null){
                    JOptionPane.showMessageDialog(null, "Không có người dùng này", "Warning",
                    JOptionPane.WARNING_MESSAGE); 
                }else{
                    deleteAccount(user);
                    JOptionPane.showMessageDialog(null, "Xóa tài khoản thành công"
                    ,"Success", JOptionPane.INFORMATION_MESSAGE);  
                    reset();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Bạn chưa điền đủ thông tin", "Warning",
                JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Xoataikhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btOkActionPerformed

    private void btBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBackActionPerformed
        try {
            new GUI().setVisible(true);
            dispose();
        } catch (RemoteException ex) {
            Logger.getLogger(Xoataikhoan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Xoataikhoan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Xoataikhoan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AlreadyBoundException ex) {
            Logger.getLogger(Xoataikhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btBackActionPerformed

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
            java.util.logging.Logger.getLogger(Xoataikhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Xoataikhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Xoataikhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Xoataikhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Xoataikhoan().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Xoataikhoan.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Xoataikhoan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBack;
    private javax.swing.JButton btOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField tfcmnd;
    private javax.swing.JTextField tfnumAccount;
    // End of variables declaration//GEN-END:variables
}