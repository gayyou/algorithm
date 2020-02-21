package operateingSystem.filemanage.core.model.dto;

import lombok.Data;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/1/5 10:45
 */
@Data
public class ResultData<T> {
  int state;
  String msg;
  T data;
}
