package encode.test;

import java.awt.event.ActionEvent;

/**
 * 设置主界面大小
 */
import javax.swing.JFrame;


public class LoginFrame extends JFrame {
  public LoginFrame() {   // setLocation(400,500); //设置位置
    setLocationRelativeTo(null);   // 居中
    setSize(500, 400);// 窗口尺寸大小
    setResizable(false);// 禁止调节窗口大小
    //setBounds(100, 522, 100, 120);// 设置位置和尺寸大小
    LoginPane lp = new LoginPane("C:\\Users\\Chinki.000\\Desktop\\background.jpg");
    setContentPane(lp);//替换原来的默认面板
  }

  public static void main(String[] args) {
    LoginFrame lf = new LoginFrame();//创建窗口对象  
    lf.setVisible(true);
  }

}
