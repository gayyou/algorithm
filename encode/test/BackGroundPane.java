package encode.test;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *  * 具有背景的面板
 *  
 */
public class BackGroundPane extends JPanel {
  private String imageUrl;

  public BackGroundPane(String imageUrl) {
    super();
    this.imageUrl = imageUrl;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (null != imageUrl) {
      try {
        Image img = ImageIO.read(new File(imageUrl));
        g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
