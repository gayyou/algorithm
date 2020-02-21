package operateingSystem.filemanage.core.model.local;

import lombok.Data;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/1/4 16:06
 */
@Data
public class Context {
  private String contextPath;
  private DCB contextDCB;
  private DCB rootDCB;
  private FCB currentFCB;
}
