package day10;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class BackgroundSketch {
	Image background=new ImageIcon(("KakaoTalk_20211101_171618799.png")).getImage();
    /**
     * Creates new form Bookset
     */
    public Bookset() {
        initComponents();
    }
    
    
    @Override
    public void paint(Graphics g) {//�׸��� �Լ�
            super.paint(g);
      g.drawImage(background, 0, 0, null);//background�� �׷���      
    }
    
    @Override
    public void paintComponent(Graphics g) {//�׸��� �Լ�
            super.paintComponent(g);
      g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), null);//background�� �׷���      
    }
}
