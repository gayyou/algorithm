package operateingSystem.filemanage.core.model.local;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/1/4 10:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FCB {
  String name;
  FAT fat;
  DCB dcb;
  String recentlyWriteTime;
  String recentlyReadTime;

  public FCB(String name, DCB dcb) {
    this.name = name;
    this.dcb = dcb;
  }
}
