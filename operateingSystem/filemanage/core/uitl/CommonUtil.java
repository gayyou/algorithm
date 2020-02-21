package operateingSystem.filemanage.core.uitl;

import junit.framework.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/1/5 9:23
 */
public class CommonUtil {
  private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  public static String getCurrentTime() {
    return sdf.format(new Date());
  }
}
