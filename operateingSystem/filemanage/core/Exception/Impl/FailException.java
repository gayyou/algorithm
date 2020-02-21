package operateingSystem.filemanage.core.Exception.Impl;

import operateingSystem.filemanage.core.Exception.AbstractException;
import operateingSystem.filemanage.core.enums.MessageEnum;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/1/5 9:41
 */
public class FailException extends AbstractException {
  public FailException(MessageEnum statEnum) {
    super(statEnum);
  }
}
