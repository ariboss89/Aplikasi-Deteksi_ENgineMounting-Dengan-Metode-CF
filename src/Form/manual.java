/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Koneksi.koneksi;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class manual extends javax.swing.JFrame {

    private DefaultTableModel DftTblModel;
    /**
     * Creates new form automatic
     */
    public manual() {
        initComponents();
        gejala();
        setLocationRelativeTo(this);
        id();
        idriwayat();
        jLabel_cfgejala.setVisible(false);
        jLabel_cfpilihan.setVisible(false);
        jLabel_cfhasil.setVisible(false);
        jLabel_cfold.setVisible(false);
        jLabel_cfsebelum.setVisible(false);
        jLabel_id.setVisible(false);
        jLabel_idriwayat.setVisible(false);
        jLabel_jenismobil.setVisible(false);
        jLabel_jumlahbaris.setVisible(false);
        jLabel_kerusakan.setVisible(false);
        jLabel_kesimpulan.setVisible(false);
        jLabel_jmlgejala.setVisible(false);
        jLabel_solusi.setVisible(false);
    }

    public void TampilData(){
        DftTblModel = new DefaultTableModel();
        DftTblModel.addColumn("ID");
        DftTblModel.addColumn("ID RIWAYAT");
        DftTblModel.addColumn("NAMA KERUSAKAN");
        DftTblModel.addColumn("JENIS MOBIL");
        DftTblModel.addColumn("GEJALA");
        DftTblModel.addColumn("KETERANGAN");
        DftTblModel.addColumn("NILAI CF");
        DftTblModel.addColumn("NILAI CF OLD");
        jTable1.setModel(DftTblModel);
        java.sql.Connection conn = new Koneksi.koneksi().connect();
     try{
         java.sql.Statement stmt = conn.createStatement();
            String SQL = " select*from sementara";
         java.sql.ResultSet res=stmt.executeQuery(SQL);
         while(res.next()){
             DftTblModel.addRow(new Object[]{
                 res.getString("Id"),
                 res.getString("idriwayat"),
                 res.getString("nama"),
                 res.getString("jenismobil"),
                 res.getString("gejala"),
                 res.getString("keterangan"),
                 res.getString("nilai"),
                 res.getString("cfold")
             });
         }
     }catch(Exception e){
             }
    
    }
    
    public void id(){        
        java.sql.Connection conn= new Koneksi.koneksi().connect();       
        try {            
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select *from sementara ORDER BY Id DESC"); 
            if (rs.next()) {
                String nocust = rs.getString("Id").substring(4);
                String AN = "" + (Integer.parseInt(nocust) + 1);
                String Nol = "";
                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}               
                jLabel_id.setText("HSL-" + Nol + AN);
            }else{
                jLabel_id.setText("HSL-0001");
            }           
        }catch(Exception e){           
            JOptionPane.showMessageDialog(null, e);           
        }     
    }
     
    public void idriwayat(){        
        java.sql.Connection conn= new Koneksi.koneksi().connect();       
        try {            
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select *from riwayat ORDER BY Id DESC"); 
            if (rs.next()) {
                String nocust = rs.getString("Id").substring(4);
                String AN = "" + (Integer.parseInt(nocust) + 1);
                String Nol = "";
                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}               
                jLabel_idriwayat.setText("RWY-" + Nol + AN);
            }else{
                jLabel_idriwayat.setText("RWY-0001");
            }           
        }catch(Exception e){           
            JOptionPane.showMessageDialog(null, e);           
        }     
    }
    
    public void refresh(){
        id();
        idriwayat();
        jComboBox_gejala1.setSelectedItem("PILIH");
        jComboBox_gejala2.setSelectedItem("PILIH");
        jComboBox_gejala3.setSelectedItem("PILIH");
        jComboBox_gejala4.setSelectedItem("PILIH");
        jComboBox_pilih1.setSelectedItem("PILIH");
        jComboBox_pilih2.setSelectedItem("PILIH");
        jComboBox_pilih3.setSelectedItem("PILIH");
        jComboBox_pilih4.setSelectedItem("PILIH");
        jComboBox_gejala1.setEnabled(true);
        jComboBox_gejala2.setEnabled(true);
        jComboBox_gejala3.setEnabled(true);
        jComboBox_gejala4.setEnabled(true);
        jComboBox_pilih1.setEnabled(true);
        jComboBox_pilih2.setEnabled(true);
        jComboBox_pilih3.setEnabled(true);
        jComboBox_pilih4.setEnabled(true);
        jButton_add1.setEnabled(true);
        jButton_add2.setEnabled(true);
        jButton_add3.setEnabled(true);
        jButton_add4.setEnabled(true);
        jLabel_cfgejala.setText("");
        jLabel_cfpilihan.setText("");
        jLabel_cfhasil.setText("");
        jLabel_cfsebelum.setText("");
        jLabel_jumlahbaris.setText("");
        jLabel_kerusakan.setText("");
        jLabel_kesimpulan.setText("");
        jLabel_jmlgejala.setText("");
        jLabel_cfold.setText("");
        jLabel_solusi.setText("");
    }
    
    private void hapus(){
        java.sql.Connection conn= new Koneksi.koneksi().connect();        
            try{
                String SQL="delete from sementara where idriwayat='"+jLabel_idriwayat.getText()+"'";
                java.sql.PreparedStatement stmt=conn.prepareStatement(SQL);
                stmt.executeUpdate();
                TampilData();
                refresh();
            }catch(Exception ex){               
            }                
    }
    
    private void hapus2(){
        java.sql.Connection conn= new Koneksi.koneksi().connect();        
            try{
                String SQL="delete from detailriwayat where idriwayat='"+jLabel_idriwayat.getText()+"'";
                java.sql.PreparedStatement stmt=conn.prepareStatement(SQL);
                stmt.executeUpdate();
                TampilData();
                refresh();
            }catch(Exception ex){               
            }                
    }
    
    public void gejala(){
        java.sql.Connection conn= new Koneksi.koneksi().connect();
        try{
            java.sql.Statement stmt= conn.createStatement();
            java.sql.ResultSet res= stmt.executeQuery("select *from gejala where jenismobil='AUTOMATIC'" );
            while(res.next()){
                jComboBox_gejala1.addItem(res.getString("gejala"));
                jComboBox_gejala2.addItem(res.getString("gejala"));
                jComboBox_gejala3.addItem(res.getString("gejala"));
                jComboBox_gejala4.addItem(res.getString("gejala"));                
            }
        }catch(SQLException ex){            
        }
    }
    
    private void hitungbaris(){
        DefaultTableModel dataModel = (DefaultTableModel) jTable1.getModel();
        int jumlah = dataModel.getRowCount();       
        
        jLabel_jumlahbaris.setText(Integer.toString(jumlah));                         
    }
    
    public void call1(){
        java.sql.Connection conn= new Koneksi.koneksi().connect();
        try{
            java.sql.Statement stmt= conn.createStatement();
            java.sql.ResultSet res= stmt.executeQuery("select *from sementara where gejala='"+jComboBox_gejala1.getSelectedItem()+"'" );
            while(res.next()){
                jLabel_cfsebelum.setText(res.getString("nilai"));
            }
        }catch(SQLException ex){            
        }
    }
    
    public void call2(){
        java.sql.Connection conn= new Koneksi.koneksi().connect();
        try{
            java.sql.Statement stmt= conn.createStatement();
            java.sql.ResultSet res= stmt.executeQuery("select *from sementara where gejala like '%"+jComboBox_gejala2.getSelectedItem()+"%'" );
            while(res.next()){
                jLabel_cfsebelum.setText(res.getString("nilai"));
                jLabel_cfhasil.setText(res.getString("cfold"));
            }
        }catch(SQLException ex){            
        }
    }
    
    public void call3(){
        java.sql.Connection conn= new Koneksi.koneksi().connect();
        try{
            java.sql.Statement stmt= conn.createStatement();
            java.sql.ResultSet res= stmt.executeQuery("select *from sementara where gejala like '%"+jComboBox_gejala3.getSelectedItem()+"%'" );
            while(res.next()){
                jLabel_cfsebelum.setText(res.getString("nilai"));
                jLabel_cfhasil.setText(res.getString("cfold"));
            }
        }catch(SQLException ex){            
        }
    }
    
    public void call4(){
        java.sql.Connection conn= new Koneksi.koneksi().connect();
        try{
            java.sql.Statement stmt= conn.createStatement();
            java.sql.ResultSet res= stmt.executeQuery("select *from sementara where gejala like '%"+jComboBox_gejala4.getSelectedItem()+"%'" );
            while(res.next()){
                jLabel_cfhasil.setText(res.getString("cfold"));
            }
        }catch(SQLException ex){            
        }
    }
    
    private void cf1(){             
       float cfgejala = Float.parseFloat(jLabel_cfgejala.getText());
       float cfpilihan = Float.parseFloat(jLabel_cfpilihan.getText());
       float total = cfgejala*cfpilihan;
       jLabel_cfhasil.setText(String.valueOf(total));       
    }
    
     public void cf2(){     
        float cf1 = Float.parseFloat(jLabel_cfsebelum.getText());
        float cf2 = Float.parseFloat(jLabel_cfhasil.getText());        
        float total =(cf1)+(cf2*(1-cf1)) ;
        jLabel_cfold.setText(String.valueOf(total));
    }
    
    public void cfold(){       
        float cfold = Float.parseFloat(jLabel_cfold.getText());
        float cf = Float.parseFloat(jLabel_cfhasil.getText());       
        float total =(cfold)+(cf*(1-cfold)) ;
        jLabel_cfold.setText(String.valueOf(total));                
    }
    
    public void simpan1(){        
            
        java.sql.Connection conn= new Koneksi.koneksi().connect();            
        try{
            java.sql.PreparedStatement stmt=conn.prepareStatement("insert into sementara (Id,idriwayat,nama,jenismobil,gejala,keterangan,nilai,cfold) values (?,?,?,?,?,?,?,?)");
            try{           
                stmt.setString(1,jLabel_id.getText());
                stmt.setString(2,jLabel_idriwayat.getText());
                stmt.setString(3,jLabel_kerusakan.getText());
                stmt.setString(4,jLabel_jenismobil.getText());
                stmt.setString(5,jComboBox_gejala1.getSelectedItem().toString());
                stmt.setString(6,jComboBox_pilih1.getSelectedItem().toString());
                stmt.setString(7,jLabel_cfhasil.getText());
                stmt.setString(8,jLabel_cfold.getText());               
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"MENYIMPAN DATA","Pesan",JOptionPane.INFORMATION_MESSAGE);

            } catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"GAGAL MENYIMPAN DATA !!!","Pesan",JOptionPane.WARNING_MESSAGE);
            }
        }catch(Exception e){

        }                
    }
    
    public void simpan2(){        
            
        java.sql.Connection conn= new Koneksi.koneksi().connect();            
        try{
            java.sql.PreparedStatement stmt=conn.prepareStatement("insert into sementara (Id,idriwayat,nama,jenismobil,gejala,keterangan,nilai,cfold) values (?,?,?,?,?,?,?,?)");
            try{           
                stmt.setString(1,jLabel_id.getText());
                stmt.setString(2,jLabel_idriwayat.getText());
                stmt.setString(3,jLabel_kerusakan.getText());
                stmt.setString(4,jLabel_jenismobil.getText());
                stmt.setString(5,jComboBox_gejala2.getSelectedItem().toString());
                stmt.setString(6,jComboBox_pilih2.getSelectedItem().toString());
                stmt.setString(7,jLabel_cfhasil.getText());
                stmt.setString(8,jLabel_cfold.getText());               
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"MENYIMPAN DATA","Pesan",JOptionPane.INFORMATION_MESSAGE);

            } catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"GAGAL MENYIMPAN DATA !!!","Pesan",JOptionPane.WARNING_MESSAGE);
            }
        }catch(Exception e){

        }                
    }
    
    public void simpan3(){        
            
        java.sql.Connection conn= new Koneksi.koneksi().connect();            
        try{
            java.sql.PreparedStatement stmt=conn.prepareStatement("insert into sementara (Id,idriwayat,nama,jenismobil,gejala,keterangan,nilai,cfold) values (?,?,?,?,?,?,?,?)");
            try{           
                stmt.setString(1,jLabel_id.getText());
                stmt.setString(2,jLabel_idriwayat.getText());
                stmt.setString(3,jLabel_kerusakan.getText());
                stmt.setString(4,jLabel_jenismobil.getText());
                stmt.setString(5,jComboBox_gejala3.getSelectedItem().toString());
                stmt.setString(6,jComboBox_pilih3.getSelectedItem().toString());
                stmt.setString(7,jLabel_cfhasil.getText());
                stmt.setString(8,jLabel_cfold.getText());               
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"MENYIMPAN DATA","Pesan",JOptionPane.INFORMATION_MESSAGE);

            } catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"GAGAL MENYIMPAN DATA !!!","Pesan",JOptionPane.WARNING_MESSAGE);
            }
        }catch(Exception e){

        }                
    }
    
    public void simpan4(){        
            
        java.sql.Connection conn= new Koneksi.koneksi().connect();            
        try{
            java.sql.PreparedStatement stmt=conn.prepareStatement("insert into sementara (Id,idriwayat,nama,jenismobil,gejala,keterangan,nilai,cfold) values (?,?,?,?,?,?,?,?)");
            try{           
                stmt.setString(1,jLabel_id.getText());
                stmt.setString(2,jLabel_idriwayat.getText());
                stmt.setString(3,jLabel_kerusakan.getText());
                stmt.setString(4,jLabel_jenismobil.getText());
                stmt.setString(5,jComboBox_gejala4.getSelectedItem().toString());
                stmt.setString(6,jComboBox_pilih4.getSelectedItem().toString());
                stmt.setString(7,jLabel_cfhasil.getText());
                stmt.setString(8,jLabel_cfold.getText());               
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"MENYIMPAN DATA","Pesan",JOptionPane.INFORMATION_MESSAGE);

            } catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"GAGAL MENYIMPAN DATA !!!","Pesan",JOptionPane.WARNING_MESSAGE);
            }
        }catch(Exception e){

        }                
    }
    
    public void simpanriwayat1(){        
            
        java.sql.Connection conn= new Koneksi.koneksi().connect();            
        try{
            java.sql.PreparedStatement stmt=conn.prepareStatement("insert into detailriwayat (idriwayat,nama,jenismobil,gejala,keterangan,nilai,cfold) values (?,?,?,?,?,?,?)");
            try{           
                stmt.setString(1,jLabel_idriwayat.getText());
                stmt.setString(2,jLabel_kerusakan.getText());
                stmt.setString(3,jLabel_jenismobil.getText());
                stmt.setString(4,jComboBox_gejala1.getSelectedItem().toString());
                stmt.setString(5,jComboBox_pilih1.getSelectedItem().toString());
                stmt.setString(6,jLabel_cfhasil.getText());
                stmt.setString(7,jLabel_cfold.getText());               
                stmt.executeUpdate();              
            } catch(SQLException ex){                
            }
        }catch(Exception e){

        }                
    }
    
    public void simpanriwayat2(){        
            
        java.sql.Connection conn= new Koneksi.koneksi().connect();            
        try{
            java.sql.PreparedStatement stmt=conn.prepareStatement("insert into detailriwayat (idriwayat,nama,jenismobil,gejala,keterangan,nilai,cfold) values (?,?,?,?,?,?,?)");
            try{           
                stmt.setString(1,jLabel_idriwayat.getText());
                stmt.setString(2,jLabel_kerusakan.getText());
                stmt.setString(3,jLabel_jenismobil.getText());
                stmt.setString(4,jComboBox_gejala2.getSelectedItem().toString());
                stmt.setString(5,jComboBox_pilih2.getSelectedItem().toString());
                stmt.setString(6,jLabel_cfhasil.getText());
                stmt.setString(7,jLabel_cfold.getText());               
                stmt.executeUpdate();              
            } catch(SQLException ex){                
            }
        }catch(Exception e){

        }                
    }
    
    public void simpanriwayat3(){        
            
        java.sql.Connection conn= new Koneksi.koneksi().connect();            
        try{
            java.sql.PreparedStatement stmt=conn.prepareStatement("insert into detailriwayat (idriwayat,nama,jenismobil,gejala,keterangan,nilai,cfold) values (?,?,?,?,?,?,?)");
            try{           
                stmt.setString(1,jLabel_idriwayat.getText());
                stmt.setString(2,jLabel_kerusakan.getText());
                stmt.setString(3,jLabel_jenismobil.getText());
                stmt.setString(4,jComboBox_gejala3.getSelectedItem().toString());
                stmt.setString(5,jComboBox_pilih3.getSelectedItem().toString());
                stmt.setString(6,jLabel_cfhasil.getText());
                stmt.setString(7,jLabel_cfold.getText());               
                stmt.executeUpdate();              
            } catch(SQLException ex){                
            }
        }catch(Exception e){

        }                
    }
    
    public void simpanriwayat4(){        
            
        java.sql.Connection conn= new Koneksi.koneksi().connect();            
        try{
            java.sql.PreparedStatement stmt=conn.prepareStatement("insert into detailriwayat (idriwayat,nama,jenismobil,gejala,keterangan,nilai,cfold) values (?,?,?,?,?,?,?)");
            try{           
                stmt.setString(1,jLabel_idriwayat.getText());
                stmt.setString(2,jLabel_kerusakan.getText());
                stmt.setString(3,jLabel_jenismobil.getText());
                stmt.setString(4,jComboBox_gejala4.getSelectedItem().toString());
                stmt.setString(5,jComboBox_pilih4.getSelectedItem().toString());
                stmt.setString(6,jLabel_cfhasil.getText());
                stmt.setString(7,jLabel_cfold.getText());               
                stmt.executeUpdate();              
            } catch(SQLException ex){                
            }
        }catch(Exception e){

        }                
    }
    
    public void simpanriwayat(){        
            
        java.sql.Connection conn= new Koneksi.koneksi().connect();            
        try{
            java.sql.PreparedStatement stmt=conn.prepareStatement("insert into riwayat (Id,nama,jenismobil,jumlahgejala,nilai,kesimpulan,solusi) values (?,?,?,?,?,?,?)");
            try{           
                stmt.setString(1,jLabel_idriwayat.getText());
                stmt.setString(2,jLabel_kerusakan.getText());
                stmt.setString(3,jLabel_jenismobil.getText());
                stmt.setString(4,jLabel_jmlgejala.getText());
                stmt.setString(5,jLabel_cfold.getText());
                stmt.setString(6,jLabel_kesimpulan.getText());               
                stmt.setString(7,jLabel_solusi.getText());
                stmt.executeUpdate();               
            } catch(SQLException ex){      
                
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
               "select *from riwayat where Id like '%"+jLabel_idriwayat.getText()+"%'";
               
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
               "select *from detailriwayat where idriwayat like '%"+jLabel_idriwayat.getText()+"%'";
               
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
        jLabel8 = new javax.swing.JLabel();
        jComboBox_gejala1 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jComboBox_gejala2 = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jComboBox_gejala3 = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jComboBox_gejala4 = new javax.swing.JComboBox();
        jButton_cancel = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton_deteksi = new javax.swing.JButton();
        jComboBox_pilih1 = new javax.swing.JComboBox();
        jButton_add1 = new javax.swing.JButton();
        jLabel_jenismobil = new javax.swing.JLabel();
        jLabel_cfhasil = new javax.swing.JLabel();
        jLabel_cfgejala = new javax.swing.JLabel();
        jLabel_cfpilihan = new javax.swing.JLabel();
        jComboBox_pilih2 = new javax.swing.JComboBox();
        jComboBox_pilih3 = new javax.swing.JComboBox();
        jComboBox_pilih4 = new javax.swing.JComboBox();
        jButton_add2 = new javax.swing.JButton();
        jButton_add3 = new javax.swing.JButton();
        jButton_add4 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel_cfold = new javax.swing.JLabel();
        jLabel_id = new javax.swing.JLabel();
        jLabel_kerusakan = new javax.swing.JLabel();
        jLabel_cfsebelum = new javax.swing.JLabel();
        jLabel_jumlahbaris = new javax.swing.JLabel();
        jLabel_idriwayat = new javax.swing.JLabel();
        jLabel_kesimpulan = new javax.swing.JLabel();
        jLabel_jmlgejala = new javax.swing.JLabel();
        jLabel_solusi = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

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

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("GEJALA 1");

        jComboBox_gejala1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox_gejala1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PILIH" }));
        jComboBox_gejala1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_gejala1ItemStateChanged(evt);
            }
        });
        jComboBox_gejala1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_gejala1ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("GEJALA 2");

        jComboBox_gejala2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox_gejala2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PILIH" }));
        jComboBox_gejala2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_gejala2ItemStateChanged(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("GEJALA 3");

        jComboBox_gejala3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox_gejala3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PILIH" }));
        jComboBox_gejala3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_gejala3ItemStateChanged(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("GEJALA 4");

        jComboBox_gejala4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox_gejala4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PILIH" }));
        jComboBox_gejala4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_gejala4ItemStateChanged(evt);
            }
        });
        jComboBox_gejala4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_gejala4ActionPerformed(evt);
            }
        });

        jButton_cancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/cancel (2).png"))); // NOI18N
        jButton_cancel.setText("CANCEL");
        jButton_cancel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelActionPerformed(evt);
            }
        });

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

        jButton_deteksi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_deteksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/next.png"))); // NOI18N
        jButton_deteksi.setText("DETEKSI");
        jButton_deteksi.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton_deteksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_deteksiActionPerformed(evt);
            }
        });

        jComboBox_pilih1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox_pilih1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PILIH", "SANGAT YAKIN", "YAKIN", "CUKUP YAKIN", "SEDIKIT YAKIN", "TIDAK TAHU", "TIDAK" }));
        jComboBox_pilih1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_pilih1ItemStateChanged(evt);
            }
        });
        jComboBox_pilih1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_pilih1ActionPerformed(evt);
            }
        });

        jButton_add1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_add1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/hand.png"))); // NOI18N
        jButton_add1.setText("ADD");
        jButton_add1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton_add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_add1ActionPerformed(evt);
            }
        });

        jLabel_jenismobil.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_jenismobil.setText("MANUAL");

        jLabel_cfhasil.setForeground(new java.awt.Color(255, 255, 255));

        jLabel_cfgejala.setForeground(new java.awt.Color(255, 255, 255));

        jLabel_cfpilihan.setForeground(new java.awt.Color(255, 255, 255));

        jComboBox_pilih2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox_pilih2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PILIH", "SANGAT YAKIN", "YAKIN", "CUKUP YAKIN", "SEDIKIT YAKIN", "TIDAK TAHU", "TIDAK" }));
        jComboBox_pilih2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_pilih2ItemStateChanged(evt);
            }
        });
        jComboBox_pilih2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_pilih2ActionPerformed(evt);
            }
        });

        jComboBox_pilih3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox_pilih3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PILIH", "SANGAT YAKIN", "YAKIN", "CUKUP YAKIN", "SEDIKIT YAKIN", "TIDAK TAHU", "TIDAK" }));
        jComboBox_pilih3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_pilih3ItemStateChanged(evt);
            }
        });
        jComboBox_pilih3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_pilih3ActionPerformed(evt);
            }
        });

        jComboBox_pilih4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox_pilih4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PILIH", "SANGAT YAKIN", "YAKIN", "CUKUP YAKIN", "SEDIKIT YAKIN", "TIDAK TAHU", "TIDAK" }));
        jComboBox_pilih4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_pilih4ItemStateChanged(evt);
            }
        });
        jComboBox_pilih4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_pilih4ActionPerformed(evt);
            }
        });

        jButton_add2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_add2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/hand.png"))); // NOI18N
        jButton_add2.setText("ADD");
        jButton_add2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton_add2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_add2ActionPerformed(evt);
            }
        });

        jButton_add3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_add3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/hand.png"))); // NOI18N
        jButton_add3.setText("ADD");
        jButton_add3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton_add3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_add3ActionPerformed(evt);
            }
        });

        jButton_add4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_add4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/hand.png"))); // NOI18N
        jButton_add4.setText("ADD");
        jButton_add4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton_add4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_add4ActionPerformed(evt);
            }
        });

        jLabel_cfold.setForeground(new java.awt.Color(255, 255, 255));

        jLabel_id.setForeground(new java.awt.Color(255, 255, 255));

        jLabel_kerusakan.setForeground(new java.awt.Color(255, 255, 255));

        jLabel_cfsebelum.setForeground(new java.awt.Color(255, 255, 255));

        jLabel_jumlahbaris.setForeground(new java.awt.Color(255, 255, 255));

        jLabel_idriwayat.setForeground(new java.awt.Color(255, 255, 255));

        jLabel_kesimpulan.setForeground(new java.awt.Color(255, 255, 255));

        jLabel_jmlgejala.setForeground(new java.awt.Color(255, 255, 255));

        jLabel_solusi.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(135, 135, 135))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel_kerusakan)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel_id))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel_cfold)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel_cfhasil))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel_cfpilihan)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel_cfgejala)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox_gejala3, 0, 587, Short.MAX_VALUE)
                            .addComponent(jComboBox_gejala2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox_gejala1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox_gejala4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox_pilih1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox_pilih2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox_pilih3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox_pilih4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_add1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton_add2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton_add3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton_add4, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel_jenismobil)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_solusi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_cfsebelum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_jumlahbaris)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_idriwayat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 351, Short.MAX_VALUE)
                        .addComponent(jLabel_kesimpulan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel_jmlgejala, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(245, 245, 245)
                        .addComponent(jButton_cancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_deteksi)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox_gejala1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_pilih1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_cfgejala)
                    .addComponent(jLabel_cfpilihan)
                    .addComponent(jButton_add1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBox_gejala2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_cfhasil)
                    .addComponent(jComboBox_pilih2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_add2)
                    .addComponent(jLabel_cfold))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_gejala3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jComboBox_pilih3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_add3)
                    .addComponent(jLabel_id)
                    .addComponent(jLabel_kerusakan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_gejala4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jComboBox_pilih4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_add4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton_deteksi)
                        .addComponent(jButton_cancel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel_jenismobil)
                        .addComponent(jLabel_cfsebelum)
                        .addComponent(jLabel_jumlahbaris)
                        .addComponent(jLabel_idriwayat)
                        .addComponent(jLabel_kesimpulan)
                        .addComponent(jLabel_jmlgejala)
                        .addComponent(jLabel_solusi)))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("X");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/car.png"))); // NOI18N
        jLabel2.setText("MANUAL CAR");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
      /*  int baris = jTable1.getSelectedRow();
        jLabel_ID.setText(DftTblModel.getValueAt(baris,0).toString());
        jTextField_kerusakan.setText(DftTblModel.getValueAt(baris,1).toString());
        jComboBox_jenismobil.setSelectedItem(DftTblModel.getValueAt(baris,2).toString());
        jTextField_gejala.setText(DftTblModel.getValueAt(baris,3).toString());
        jTextField_nilai.setText(DftTblModel.getValueAt(baris,4).toString());
        jButton_updategejala.setEnabled(true);
        jButton_simpan.setEnabled(false);
        */
    }//GEN-LAST:event_jTable1MouseClicked

    private void jComboBox_gejala1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_gejala1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_gejala1ActionPerformed

    private void jComboBox_pilih1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_pilih1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_pilih1ActionPerformed

    private void jComboBox_gejala4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_gejala4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_gejala4ActionPerformed

    private void jComboBox_pilih1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_pilih1ItemStateChanged
        // TODO add your handling code here:        
        if(jComboBox_pilih1.getSelectedItem().equals("PILIH")){
           jLabel_cfpilihan.setText("");
        }
        else if(jComboBox_pilih1.getSelectedItem().equals("SANGAT YAKIN")){
            jLabel_cfpilihan.setText("1");
            cf1();
        }
        else if(jComboBox_pilih1.getSelectedItem().equals("YAKIN")){
            jLabel_cfpilihan.setText("0.8");
            cf1();
        }
        else if(jComboBox_pilih1.getSelectedItem().equals("CUKUP YAKIN")){
            jLabel_cfpilihan.setText("0.6");
            cf1();
        }
        else if(jComboBox_pilih1.getSelectedItem().equals("SEDIKIT YAKIN")){
            jLabel_cfpilihan.setText("0.4");
            cf1();
        }
        else if(jComboBox_pilih1.getSelectedItem().equals("TIDAK TAHU")){
            jLabel_cfpilihan.setText("0.2");
            cf1();
        }
        else if(jComboBox_pilih1.getSelectedItem().equals("TIDAK")){
            jLabel_cfpilihan.setText("0");
            cf1();
        }
        
    }//GEN-LAST:event_jComboBox_pilih1ItemStateChanged

    private void jComboBox_gejala1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_gejala1ItemStateChanged
        // TODO add your handling code here:
        java.sql.Connection conn= new Koneksi.koneksi().connect();
        try{
            java.sql.Statement stmt= conn.createStatement();
            java.sql.ResultSet res= stmt.executeQuery("select *from gejala where gejala='"+jComboBox_gejala1.getSelectedItem()+"'" );
            while(res.next()){
                jLabel_cfgejala.setText(res.getString("nilai"));
                jLabel_kerusakan.setText(res.getString("nama"));
                jComboBox_pilih1.setSelectedItem("PILIH");
                
            }
        }catch(SQLException ex){
            
        }
    }//GEN-LAST:event_jComboBox_gejala1ItemStateChanged

    private void jComboBox_pilih2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_pilih2ItemStateChanged
        // TODO add your handling code here:
        if(jComboBox_pilih2.getSelectedItem().equals("PILIH")){
           jLabel_cfpilihan.setText("");
        }
        else if(jComboBox_pilih2.getSelectedItem().equals("SANGAT YAKIN")){
            jLabel_cfpilihan.setText("1");
            cf1();
        }
        else if(jComboBox_pilih2.getSelectedItem().equals("YAKIN")){
            jLabel_cfpilihan.setText("0.8");
            cf1();
        }
        else if(jComboBox_pilih2.getSelectedItem().equals("CUKUP YAKIN")){
            jLabel_cfpilihan.setText("0.6");
            cf1();
        }
        else if(jComboBox_pilih2.getSelectedItem().equals("SEDIKIT YAKIN")){
            jLabel_cfpilihan.setText("0.4");
            cf1();
        }
        else if(jComboBox_pilih2.getSelectedItem().equals("TIDAK TAHU")){
            jLabel_cfpilihan.setText("0.2");
            cf1();
        }
        else if(jComboBox_pilih2.getSelectedItem().equals("TIDAK")){
            jLabel_cfpilihan.setText("0");
            cf1();
        }
    }//GEN-LAST:event_jComboBox_pilih2ItemStateChanged

    private void jComboBox_pilih2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_pilih2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_pilih2ActionPerformed

    private void jComboBox_pilih3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_pilih3ItemStateChanged
        // TODO add your handling code here:
        if(jComboBox_pilih3.getSelectedItem().equals("PILIH")){
           jLabel_cfpilihan.setText("");
        }
        else if(jComboBox_pilih3.getSelectedItem().equals("SANGAT YAKIN")){
            jLabel_cfpilihan.setText("1");
            cf1();
        }
        else if(jComboBox_pilih3.getSelectedItem().equals("YAKIN")){
            jLabel_cfpilihan.setText("0.8");
            cf1();
        }
        else if(jComboBox_pilih3.getSelectedItem().equals("CUKUP YAKIN")){
            jLabel_cfpilihan.setText("0.6");
            cf1();
        }
        else if(jComboBox_pilih3.getSelectedItem().equals("SEDIKIT YAKIN")){
            jLabel_cfpilihan.setText("0.4");
            cf1();
        }
        else if(jComboBox_pilih3.getSelectedItem().equals("TIDAK TAHU")){
            jLabel_cfpilihan.setText("0.2");
            cf1();
        }
        else if(jComboBox_pilih3.getSelectedItem().equals("TIDAK")){
            jLabel_cfpilihan.setText("0");
            cf1();
        }
    }//GEN-LAST:event_jComboBox_pilih3ItemStateChanged

    private void jComboBox_pilih3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_pilih3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_pilih3ActionPerformed

    private void jComboBox_pilih4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_pilih4ItemStateChanged
        // TODO add your handling code here:
        if(jComboBox_pilih4.getSelectedItem().equals("PILIH")){
           jLabel_cfpilihan.setText("");
        }
        else if(jComboBox_pilih4.getSelectedItem().equals("SANGAT YAKIN")){
            jLabel_cfpilihan.setText("1");
            cf1();
        }
        else if(jComboBox_pilih4.getSelectedItem().equals("YAKIN")){
            jLabel_cfpilihan.setText("0.8");
            cf1();
        }
        else if(jComboBox_pilih4.getSelectedItem().equals("CUKUP YAKIN")){
            jLabel_cfpilihan.setText("0.6");
            cf1();
        }
        else if(jComboBox_pilih4.getSelectedItem().equals("SEDIKIT YAKIN")){
            jLabel_cfpilihan.setText("0.4");
            cf1();
        }
        else if(jComboBox_pilih4.getSelectedItem().equals("TIDAK TAHU")){
            jLabel_cfpilihan.setText("0.2");
            cf1();
        }
        else if(jComboBox_pilih4.getSelectedItem().equals("TIDAK")){
            jLabel_cfpilihan.setText("0");
            cf1();
        }
    }//GEN-LAST:event_jComboBox_pilih4ItemStateChanged

    private void jComboBox_pilih4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_pilih4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_pilih4ActionPerformed

    private void jComboBox_gejala2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_gejala2ItemStateChanged
        // TODO add your handling code here:
        java.sql.Connection conn= new Koneksi.koneksi().connect();
        try{
            java.sql.Statement stmt= conn.createStatement();
            java.sql.ResultSet res= stmt.executeQuery("select *from gejala where gejala='"+jComboBox_gejala2.getSelectedItem()+"'" );
            while(res.next()){
                jLabel_cfgejala.setText(res.getString("nilai"));
                jComboBox_pilih2.setSelectedItem("PILIH");
            }
        }catch(SQLException ex){
            
        }
    }//GEN-LAST:event_jComboBox_gejala2ItemStateChanged

    private void jComboBox_gejala3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_gejala3ItemStateChanged
        // TODO add your handling code here:
        java.sql.Connection conn= new Koneksi.koneksi().connect();
        try{
            java.sql.Statement stmt= conn.createStatement();
            java.sql.ResultSet res= stmt.executeQuery("select *from gejala where gejala='"+jComboBox_gejala3.getSelectedItem()+"'" );
            while(res.next()){
                jLabel_cfgejala.setText(res.getString("nilai"));
                jComboBox_pilih3.setSelectedItem("PILIH");
            }
        }catch(SQLException ex){
            
        }
    }//GEN-LAST:event_jComboBox_gejala3ItemStateChanged

    private void jComboBox_gejala4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_gejala4ItemStateChanged
        // TODO add your handling code here:
        java.sql.Connection conn= new Koneksi.koneksi().connect();
        try{
            java.sql.Statement stmt= conn.createStatement();
            java.sql.ResultSet res= stmt.executeQuery("select *from gejala where gejala='"+jComboBox_gejala4.getSelectedItem()+"'" );
            while(res.next()){
                jLabel_cfgejala.setText(res.getString("nilai"));
                jComboBox_pilih4.setSelectedItem("PILIH");
            }
        }catch(SQLException ex){
            
        }
    }//GEN-LAST:event_jComboBox_gejala4ItemStateChanged

    private void jButton_add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_add1ActionPerformed
        // TODO add your handling code here:
        if(jComboBox_gejala1.getSelectedItem().equals("PILIH")){
            JOptionPane.showMessageDialog(null,"PILIH GEJALA KEDUA !!!");
            jComboBox_gejala1.requestFocus();
        }
        else if(jComboBox_pilih1.getSelectedItem().equals("PILIH")){
            JOptionPane.showMessageDialog(null,"PILIH JAWABAN  !!!");
            jComboBox_pilih1.requestFocus();
        }
        else{
            jComboBox_gejala1.setEnabled(false);
            jComboBox_pilih1.setEnabled(false);
            jButton_add1.setEnabled(false);
            simpan1();
            simpanriwayat1();
            hitungbaris();
            id();
            call1();
        }
    }//GEN-LAST:event_jButton_add1ActionPerformed

    private void jButton_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelActionPerformed
        // TODO add your handling code here:
        hapus();
        hapus2();
        refresh();        
    }//GEN-LAST:event_jButton_cancelActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        TampilData();
    }//GEN-LAST:event_formWindowActivated

    private void jButton_add2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_add2ActionPerformed
        // TODO add your handling code here:
        if(jComboBox_gejala1.getSelectedItem().equals(jComboBox_gejala2.getSelectedItem().toString())){
            JOptionPane.showMessageDialog(null,"GEJALA SAMA !!!");
            jComboBox_gejala2.requestFocus();
        }
        else if(jComboBox_gejala2.getSelectedItem().equals("PILIH")){
            JOptionPane.showMessageDialog(null,"PILIH GEJALA KEDUA !!!");
            jComboBox_gejala2.requestFocus();
        }
        else if(jComboBox_pilih2.getSelectedItem().equals("PILIH")){
            JOptionPane.showMessageDialog(null,"PILIH JAWABAN  !!!");
            jComboBox_pilih2.requestFocus();
        }
        else{
        cf2();
        jComboBox_gejala2.setEnabled(false);
        jComboBox_pilih2.setEnabled(false);
        jButton_add2.setEnabled(false);
        simpan2();
        simpanriwayat2();
        hitungbaris();
        id();
        call2();
        }
    }//GEN-LAST:event_jButton_add2ActionPerformed

    private void jButton_add3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_add3ActionPerformed
        // TODO add your handling code here:
        if(jComboBox_gejala3.getSelectedItem().equals(jComboBox_gejala2.getSelectedItem().toString()) || jComboBox_gejala3.getSelectedItem().equals(jComboBox_gejala1.getSelectedItem().toString())){
            JOptionPane.showMessageDialog(null,"GEJALA SAMA !!!");
            jComboBox_gejala3.requestFocus();
        }       
        else{
        cfold();
        jComboBox_gejala3.setEnabled(false);
        jComboBox_pilih3.setEnabled(false);
        jButton_add3.setEnabled(false);
        simpan3();
        simpanriwayat3();
        hitungbaris();
        id();
        call3();
        }
    }//GEN-LAST:event_jButton_add3ActionPerformed

    private void jButton_add4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_add4ActionPerformed
        // TODO add your handling code here:
        if(jComboBox_gejala4.getSelectedItem().equals(jComboBox_gejala1.getSelectedItem().toString()) || jComboBox_gejala4.getSelectedItem().equals(jComboBox_gejala2.getSelectedItem().toString())|| jComboBox_gejala4.getSelectedItem().equals(jComboBox_gejala3.getSelectedItem().toString())){
            JOptionPane.showMessageDialog(null,"GEJALA SAMA !!!");
            jComboBox_gejala4.requestFocus();
        }      
        else{
        cfold();
        jComboBox_gejala4.setEnabled(false);
        jComboBox_pilih4.setEnabled(false);
        jButton_add4.setEnabled(false);
        simpan4();
        simpanriwayat4();
        hitungbaris();
        id();
        call4();
        }
    }//GEN-LAST:event_jButton_add4ActionPerformed

    private void jButton_deteksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_deteksiActionPerformed
        // TODO add your handling code here:
        int jmlbaris = Integer.parseInt(jLabel_jumlahbaris.getText());
        if(jmlbaris == 0){
            JOptionPane.showMessageDialog(null, "MINIMUM GEJALA YANG DIPILIH IALAH 2 !!!");
            jComboBox_gejala2.requestFocus();
        }
        else{
            int jmlgejala = Integer.parseInt(jLabel_jumlahbaris.getText());
            int total= jmlgejala+1;
            jLabel_jmlgejala.setText(String.valueOf(total));
            float cfold = Float.parseFloat(jLabel_cfold.getText());
            float persen = cfold*100;
            String kerusakan = String.valueOf(jLabel_kerusakan.getText());
            jLabel_kesimpulan.setText(String.valueOf("ENGINE MOUNTING MOBIL MANUAL ANDA MENGALAMI KERUSAKAN SEBESAR "+(persen)+"%"));      
            if(persen >= 50){
                jLabel_solusi.setText("PERIKSAKAN SEGERA MOBIL ANDA KE TEMPAT SERVIS AGAR ENGINE MOUNTING PADA MOBIL ANDA SEGERA DIGANTI");
                simpanriwayat();
                cetak();
                cetak2();
                hapus();
                TampilData();
                refresh();
            }
            else{
                jLabel_solusi.setText("ENGINE MOUNTING BELUM SAMPAI PADA TAHAP HARUS DI GANTI , AKAN TETAPI SEBAIKNYA SEGERA DI PERIKSAKAN KE TEMPAT SERVIS");
                simpanriwayat();
                cetak();
                hapus();
                TampilData();
                refresh();
            }          
        }                         
    }//GEN-LAST:event_jButton_deteksiActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(manual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manual().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_add1;
    private javax.swing.JButton jButton_add2;
    private javax.swing.JButton jButton_add3;
    private javax.swing.JButton jButton_add4;
    private javax.swing.JButton jButton_cancel;
    private javax.swing.JButton jButton_deteksi;
    private javax.swing.JComboBox jComboBox_gejala1;
    private javax.swing.JComboBox jComboBox_gejala2;
    private javax.swing.JComboBox jComboBox_gejala3;
    private javax.swing.JComboBox jComboBox_gejala4;
    private javax.swing.JComboBox jComboBox_pilih1;
    private javax.swing.JComboBox jComboBox_pilih2;
    private javax.swing.JComboBox jComboBox_pilih3;
    private javax.swing.JComboBox jComboBox_pilih4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_cfgejala;
    private javax.swing.JLabel jLabel_cfhasil;
    private javax.swing.JLabel jLabel_cfold;
    private javax.swing.JLabel jLabel_cfpilihan;
    private javax.swing.JLabel jLabel_cfsebelum;
    private javax.swing.JLabel jLabel_id;
    private javax.swing.JLabel jLabel_idriwayat;
    private javax.swing.JLabel jLabel_jenismobil;
    private javax.swing.JLabel jLabel_jmlgejala;
    private javax.swing.JLabel jLabel_jumlahbaris;
    private javax.swing.JLabel jLabel_kerusakan;
    private javax.swing.JLabel jLabel_kesimpulan;
    private javax.swing.JLabel jLabel_solusi;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
