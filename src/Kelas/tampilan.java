package Kelas;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 *
 * @author ariboss
 */
public class tampilan extends JPanel{
     private Image image;
     
      public tampilan() {
        image = new ImageIcon(getClass().getResource("/Icon/1.jpg")).getImage();
        //memanggil sumber daya gambar
    }
     
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
     
        Graphics gd = (Graphics2D) g.create();
     
        gd.drawImage(image, 0,0,getWidth(),getHeight(), this);
        // menggambar image
        gd.dispose();
    
}
}

