import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


/**
 * @author Weybn
 * time 2019-11-11 11:27
 * motto : Waht do you wanne to do today? Weybn
 * description
 */
public class AESUtil {
  private static final String AES = "AES";
  private static BASE64Encoder base64Encoder = new BASE64Encoder();
  private static BASE64Decoder base64Decoder = new BASE64Decoder();
  public static String doSth(String data, String password, int model){
    try {
      KeyGenerator keyGenerator = KeyGenerator.getInstance(AES);
      keyGenerator.init(128, new SecureRandom(password.getBytes()));

      //产生原始对称密钥
      SecretKey secretKey = keyGenerator.generateKey();
      byte[] keyFormat = secretKey.getEncoded();
      //根据字节数组生成密钥
      SecretKeySpec keySpec = new SecretKeySpec(keyFormat, AES);
      //生成密码器
      Cipher cipher = Cipher.getInstance(AES);
      cipher.init(model, keySpec);
      if (model == Cipher.ENCRYPT_MODE) {
        byte[] result = cipher.doFinal(data.getBytes());
        return base64Encoder.encode(result);
      }else {
        byte[] result = cipher.doFinal(base64Decoder.decodeBuffer(data));
        return new String(result);
      }
    } catch (NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException | InvalidKeyException | IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static void main(String[] args) throws IOException {
    String password = "3117004959郑伟滨";
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
    System.out.println("解密后的结果为： "+decrypt);
  }
}