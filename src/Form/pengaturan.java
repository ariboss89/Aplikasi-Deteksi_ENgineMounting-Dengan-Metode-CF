/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ariboss
 */
public class pengaturan extends javax.swing.JFrame {

    /**
     * Creates new form pengaturan
     */
    public pengaturan() {
        initComponents();
        setLocationRelativeTo(this);
        jPanel1.requestFocus();
        panggil();
    }
    
    private void panggil(){
        java.sql.Connection conn = new Koneksi.koneksi().connect();
        try{
            java.sql.Statement stmt= conn.createStatement();
            java.sql.ResultSet res = stmt.executeQuery("select *from login");
            while(res.next()){
                jLabel_username.setText(res.getString("username"));
                jLabel_status.setText(res.getString("status"));
            }
        }catch(SQLException ex){
            
        }    
    }
    
    private void cekpassword(){
        java.sql.Connection conn = new Koneksi.koneksi().connect();
        try{
            java.sql.Statement stmt= conn.createStatement();
            java.sql.ResultSet res = stmt.executeQuery("select *from pengguna where username='"+jLabel_username.getText()+"'"); 
            while(res.next()){
                if(jPasswordField1.getText().equals(res.getString("password"))){
                    
                }
                else{
                    JOptionPane.showMessageDialog(null, "GAGAL DIGANTI !!!");
                    jPasswordField1.setText("");
                }
            }
        }catch(SQLException ex){
            
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jPasswordField3 = new javax.swing.JPasswordField();
        jButton_ganti = new javax.swing.JButton();
        jLabel_username = new javax.swing.JLabel();
        jLabel_status = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("USERNAME");

        jPasswordField1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPasswordField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordField1.setText("jPasswordField1");
        jPasswordField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordField1MouseClicked(evt);
            }
        });
        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("STATUS");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("PASSWORD LAMA");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("PASSWORD BARU");

        jPasswordField2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPasswordField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordField2.setText("jPasswordField1");
        jPasswordField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordField2MouseClicked(evt);
            }
        });
        jPasswordField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPasswordField2KeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("KONFIRMASI PASSWORD");

        jPasswordField3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPasswordField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordField3.setText("jPasswordField1");
        jPasswordField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordField3MouseClicked(evt);
            }
        });
        jPasswordField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField3KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPasswordField3KeyTyped(evt);
            }
        });

        jButton_ganti.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_ganti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/hand.png"))); // NOI18N
        jButton_ganti.setText("GANTI");
        jButton_ganti.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton_ganti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_gantiActionPerformed(evt);
            }
        });

        jLabel_username.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_username.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_username.setText("USERNAME");

        jLabel_status.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_status.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_status.setText("STATUS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(198, 198, 198)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                            .addComponent(jLabel_username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(154, 154, 154)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_ganti, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPasswordField3)
                            .addComponent(jPasswordField2))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel_username))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel_status))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_ganti)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPasswordField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode()== KeyEvent.VK_ENTER)
        {
            jPasswordField2.setText("");
            jPasswordField2.requestFocus();
        }
    }//GEN-LAST:event_jPasswordField1KeyPressed

    private void jPasswordField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();

        if(jPasswordField1.getText().length()==0 && karakter == KeyEvent.VK_SPACE)
        {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_jPasswordField1KeyTyped

    private void jPasswordField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField2KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode()== KeyEvent.VK_ENTER)
        {
            jPasswordField3.setText("");
            jPasswordField3.requestFocus();
        }
    }//GEN-LAST:event_jPasswordField2KeyPressed

    private void jPasswordField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField2KeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();

        if(jPasswordField2.getText().length()==0 && karakter == KeyEvent.VK_SPACE)
        {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_jPasswordField2KeyTyped

    private void jPasswordField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField3KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode()== KeyEvent.VK_ENTER)
        {
            jButton_gantiActionPerformed(null);
        }
    }//GEN-LAST:event_jPasswordField3KeyPressed

    private void jPasswordField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField3KeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();

        if(jPasswordField3.getText().length()==0 && karakter == KeyEvent.VK_SPACE)
        {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_jPasswordField3KeyTyped

    private void jButton_gantiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_gantiActionPerformed
        // TODO add your handling code here:
        cekpassword();
        if(jPasswordField1.getText().equals("")){
            jPasswordField1.requestFocus();
        }
        else if(!jPasswordField2.getText().equals(jPasswordField3.getText())){
            JOptionPane.showMessageDialog(null, "KONFIRMASI BERBEDA !!!");
            jPasswordField3.requestFocus();
        }
        else{
        java.sql.Connection conn = new Koneksi.koneksi().connect();
        try{
            java.sql.PreparedStatement stmt= conn.prepareStatement("update pengguna set password=?,konfirmasi=? where username=? ");
            try{
                stmt.setString(1,jPasswordField2.getText());
                stmt.setString(2,jPasswordField3.getText());                
                stmt.setString(3,jLabel_username.getText());                
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "PASSWORD DIGANTI !!!","Pesan",JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "GAGAL DI GANTI !!!","Pesan",JOptionPane.WARNING_MESSAGE);
            }
        }catch(Exception e){

        }
        }
    }//GEN-LAST:event_jButton_gantiActionPerformed

    private void jPasswordField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordField1MouseClicked
        // TODO add your handling code here:
        jPasswordField1.setText("");
        jPasswordField1.requestFocus();
    }//GEN-LAST:event_jPasswordField1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jPasswordField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordField2MouseClicked
        // TODO add your handling code here:
        jPasswordField2.setText("");
        jPasswordField2.requestFocus();
    }//GEN-LAST:event_jPasswordField2MouseClicked

    private void jPasswordField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordField3MouseClicked
        // TODO add your handling code here:
        jPasswordField3.setText("");
        jPasswordField3.requestFocus();
    }//GEN-LAST:event_jPasswordField3MouseClicked

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
            java.util.logging.Logger.getLogger(pengaturan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pengaturan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pengaturan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pengaturan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pengaturan().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_ganti;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_status;
    private javax.swing.JLabel jLabel_username;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField3;
    // End of variables declaration//GEN-END:variables
}