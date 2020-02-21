import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.io.*;
import java.security.SecureRandom;

/**
 * @author WilderGao
 * time 2018-12-04 09:32
 * motto : everything is no in vain
 * description
 */
public class DESUtil {
  private static BASE64Encoder base64Encoder = new BASE64Encoder();
  private static BASE64Decoder base64Decoder = new BASE64Decoder();
  /**
   * DES加密方法
   * @param datasource 加密内容
   * @param password  密钥
   * @return 加密结果
   */
  public static String doSth(String datasource, String password, int model){
    try {
      SecureRandom random = new SecureRandom();
      DESKeySpec desKeySpec = new DESKeySpec(password.getBytes());
      SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
      SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
      //Cipher对象完成加密操作
      Cipher cipher = Cipher.getInstance("DES");
      cipher.init(model, secretKey, random);
      //获取数据并正式加密
      if (model == Cipher.ENCRYPT_MODE) {
        //判断为加密
        byte[] encodeBytes = cipher.doFinal(datasource.getBytes());
        //由于直接加密之后的结果直接转成字符串之后解密会出现异常，因此先用Base64进行转码
        return base64Encoder.encode(encodeBytes);
      }else if (model == Cipher.DECRYPT_MODE){
        //判断为解密
        byte[] decodeBytes = cipher.doFinal(base64Decoder.decodeBuffer(datasource));
        return new String(decodeBytes);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public static void main(String[] args) throws IOException {
    String password = "郑伟滨3117004959";
    File file = new File("src/test.txt");
    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
    StringBuilder datasource = new StringBuilder();
    String line;
    while ((line = reader.readLine())!=null){
      datasource.append(line);
    }
    String data = datasource.toString();
    System.out.println("==========程序开始===========");
    System.out.println("文件读出的内容为: "+ data);
    System.out.println("==========下面进行加密操作=========");
    System.out.println("\n进行加密，密钥为 "+password+" ");
    String encrypt = doSth(data, password, Cipher.ENCRYPT_MODE);
    System.out.println("加密后的结果为: "+encrypt);
    System.out.println("\n========= 现在进行解密 =========");
    String decrypt = doSth(encrypt, password, Cipher.DECRYPT_MODE);
    System.out.println("解密后的结果为： " + decrypt);
  }
}