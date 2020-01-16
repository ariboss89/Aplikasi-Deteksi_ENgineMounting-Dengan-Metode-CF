/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Koneksi.koneksi;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ariboss
 */
public class riwayathasil extends javax.swing.JFrame {
    private DefaultTableModel DftTblModel;
    /**
     * Creates new form riwayathasil
     */
    public riwayathasil() {
        initComponents();
        setLocationRelativeTo(this);
        jTextField_noriwayat.requestFocus();
    }

    public void TampilData(){
        DftTblModel = new DefaultTableModel();
        DftTblModel.addColumn("ID");
        DftTblModel.addColumn("NAMA");
        DftTblModel.addColumn("JENIS MOBIL");
        DftTblModel.addColumn("JUMLAH GEJALA");
        DftTblModel.addColumn("KESIMPULAN");
        DftTblModel.addColumn("SOLUSI");
        jTable1.setModel(DftTblModel);
        java.sql.Connection conn = new Koneksi.koneksi().connect();
     try{
         java.sql.Statement stmt = conn.createStatement();
            String SQL = " select*from riwayat";
         java.sql.ResultSet res=stmt.executeQuery(SQL);
         while(res.next()){
             DftTblModel.addRow(new Object[]{
                 res.getString("Id"),
                 res.getString("nama"),
                 res.getString("jenismobil"),
                 res.getString("jumlahgejala"),
                 res.getString("kesimpulan"),
                 res.getString("solusi")
             });
         }
     }catch(Exception e){
             }
    
    }
    
    public void cetak(){
        java.sql.Connection conn= new koneksi().connect();
        
            try{
               File file = new File("src/laporan/hasildeteksi.jrxml");
               JasperDesign jasperDesign = JRXmlLoader.load(file);
               String sql= 
               "select *from riwayat where Id like '%"+jLabel_noriwayat.getText()+"%'";
               
               Statement st = conn.createStatement(); 
               JRDesignQuery newQuery= new JRDesignQuery();
               newQuery.setText(sql);
               jasperDesign.setQuery(newQuery);
               JasperReport jasperReport=JasperCompileManager.compileReport(jasperDesign);
               JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport, null, conn);
               JasperViewer.viewReport(jasperPrint,false);
            }        
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }            
    }
    
    public void cetak2(){
        java.sql.Connection conn= new koneksi().connect();
        
            try{
               File file = new File("src/laporan/riwayathasildeteksi.jrxml");
               JasperDesign jasperDesign = JRXmlLoader.load(file);
               String sql= 
               "select *from detailriwayat where idriwayat like '%"+jLabel_noriwayat.getText()+"%'";
               
               Statement st = conn.createStatement(); 
               JRDesignQuery newQuery= new JRDesignQuery();
               newQuery.setText(sql);
               jasperDesign.setQuery(newQuery);
               JasperReport jasperReport=JasperCompileManager.compileReport(jasperDesign);
               JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport, null, conn);
               JasperViewer.viewReport(jasperPrint,false);
            }        
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
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
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jTextField_noriwayat = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel_noriwayat = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jTable1.setBackground(new java.awt.Color(0, 0, 0));
        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable1);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CARI NO RIWAYAT");

        jTextField_noriwayat.setBackground(new java.awt.Color(0, 0, 0));
        jTextField_noriwayat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField_noriwayat.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_noriwayat.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_noriwayat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField_noriwayatMouseClicked(evt);
            }
        });
        jTextField_noriwayat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_noriwayatKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_noriwayatKeyTyped(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/printer.png"))); // NOI18N
        jButton1.setText("DETAIL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel_noriwayat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_noriwayat, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_noriwayat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel_noriwayat))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("X");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int baris = jTable1.getSelectedRow();
        jLabel_noriwayat.setText(DftTblModel.getValueAt(baris,0).toString());        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField_noriwayatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_noriwayatMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_noriwayatMouseClicked

    private void jTextField_noriwayatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_noriwayatKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode()== KeyEvent.VK_ENTER)
        {
            DftTblModel = new DefaultTableModel();
            DftTblModel.addColumn("ID");
            DftTblModel.addColumn("NAMA");
            DftTblModel.addColumn("JENIS MOBIL");
            DftTblModel.addColumn("JUMLAH GEJALA");
            DftTblModel.addColumn("KESIMPULAN");
            DftTblModel.addColumn("SOLUSI");
            jTable1.setModel(DftTblModel);
            java.sql.Connection conn = new Koneksi.koneksi().connect();     
            try{         
                java.sql.Statement stmt = conn.createStatement();
                String SQL = " select*from riwayat where Id like '%"+jTextField_noriwayat.getText()+"%'";
                java.sql.ResultSet res=stmt.executeQuery(SQL);            
                while(res.next()){
                DftTblModel.addRow(new Object[]{
                res.getString("Id"),
                res.getString("nama"),
                res.getString("jenismobil"),
                res.getString("jumlahgejala"),
                res.getString("kesimpulan"),
                res.getString("solusi")             
                });         
                }     
            }catch(Exception e){             
            }   
        }
        else{
            TampilData();
        }
    }//GEN-LAST:event_jTextField_noriwayatKeyPressed

    private void jTextField_noriwayatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_noriwayatKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();

        if(jTextField_noriwayat.getText().length()==0 && karakter == KeyEvent.VK_SPACE)
        {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_jTextField_noriwayatKeyTyped

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        TampilData();
    }//GEN-LAST:event_formWindowActivated

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(jLabel_noriwayat.getText().equals("")){
            JOptionPane.showMessageDialog(null, "NO RIWAYAT BELUM DIPILIH !!!");
        }
        else{
            cetak2();
            cetak();
            jLabel_noriwayat.setText("");
            jTextField_noriwayat.setText("");
            TampilData();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(riwayathasil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(riwayathasil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(riwayathasil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(riwayathasil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new riwayathasil().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_noriwayat;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField_noriwayat;
    // End of variables declaration//GEN-END:variables
}
