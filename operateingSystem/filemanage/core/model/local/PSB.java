package operateingSystem.filemanage.core.model.local;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/1/4 15:39
 */
@Data
@NoArgsConstructor
public class PSB {
  String value;
  boolean isUsing;

  public PSB(String value) {
    this.value = value;
    this.isUsing = true;
  }
}
