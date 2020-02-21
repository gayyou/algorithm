package encode.test;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;

/**
 *初始面板 - 需要继承JPanel才能成为面板
 *
 */
public class LoginPane extends BackGroundPane{
	private JLabel String;  //输入需加解密的字符串
	private JLabel Key;   //密钥
	private JTextField StringTf; //字符串输入框
	private JPasswordField KeyPf; //密钥输入框
	private JLabel Result;  //输入需加解密的字符串
	private JFormattedTextField ReTf;   //密钥
	private JButton EnBtn;  //加密按钮
	private JButton DeBtn;   //解密按钮
	public LoginPane(String imageUrl){
		super(imageUrl);
		setBackground(Color.white);//设置背景颜色
		setForeground(Color.white);
		initComponents();//初始化组件
		layoutComponents();//布局组件
}
/**
  * 初始化组件
  */
	private void initComponents(){
		String = new JLabel("字符串");
		Key = new JLabel("密钥");
		StringTf = new JTextField();
		KeyPf = new JPasswordField();
		Result = new JLabel("结果");
    ReTf = new JFormattedTextField();
    EnBtn = new JButton("加密");
    DeBtn = new JButton("解密");
    // TODO 调用事件监听
    this.addEventListen();
    //JButton EnBtn = new JButton("加密");
	//JButton DeBtn = new JButton("解密");
	}

	// TODO 这里是我添加的
	private void encode() {
		String str = StringTf.getText().trim();
		String keyValue = new String(KeyPf.getPassword());
		StringBuilder result = new StringBuilder();
		boolean keyIsChar = false;
		int key;

		for (int i = 0; i < keyValue.length(); i++) {
			if (keyValue.charAt(i) < '0' || keyValue.charAt(i) > '9') {
				if (keyValue.length() > 1) {
					System.out.println("字符秘钥不能多于1位");
				}
				keyIsChar = true;
				break;
			}
		}

		if (keyIsChar) {
			key = keyValue.charAt(0);
		} else {
			key = Integer.parseInt(keyValue);
		}

		System.out.println(key);

		for(int i=0;i<str.length();i++) {
			result.append((char)(str.charAt(i) ^ key));
		}
		ReTf.setText(result.toString());
	}


	// TODO 这里是添加事件监听，实际上两个按钮的事件监听回调函数都相同
	private void addEventListen() {
		EnBtn.addActionListener((ActionEvent e) -> {
			this.encode();
		});

		DeBtn.addActionListener((ActionEvent e) -> {
			this.encode();
		});
	}
/**
  * 布局组件
  */
private void layoutComponents(){
	setLayout(null);//绝对定位布局
	String.setBounds(80, 100, 50, 30);//设定组件的绝对位置和大小
	StringTf.setBounds(150, 100, 250, 30);
	Key.setBounds(80, 150, 50, 30);//设定组件的绝对位置和大小
	KeyPf.setBounds(150, 150, 250, 30);
	Result.setBounds(80, 200, 50, 30);//设定组件的绝对位置和大小
	ReTf.setBounds(150, 200, 250, 30);
	EnBtn.setBounds(180, 250, 80, 30);
	DeBtn.setBounds(280, 250, 80, 30);
	add(String);
	add(StringTf);
	add(Key);
	add(KeyPf);
	add(Result);
	//EnBtn.setActionCommand("EnBtn");//做标记
	//EnBtn.addActionListener((ActionListener) this);
	add(ReTf);
	add(EnBtn);
	add(DeBtn);
	}
    
}

