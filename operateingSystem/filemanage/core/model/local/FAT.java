package operateingSystem.filemanage.core.model.local;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/1/4 10:30
 */
@Data
@NoArgsConstructor
public class FAT {
  int PSBIndex;
  int nextFATIndex;

  {
    this.nextFATIndex = -1;
  }

  public FAT(int PSBIndex) {
    this.PSBIndex = PSBIndex;
  }
}
