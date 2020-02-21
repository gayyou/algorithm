package operateingSystem.filemanage.core.Exception;

import operateingSystem.filemanage.core.enums.MessageEnum;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/1/5 9:33
 */
public abstract class AbstractException extends RuntimeException {
  private MessageEnum statEnum;

  public AbstractException(MessageEnum statEnum) {
    this.statEnum = statEnum;
  }

  public MessageEnum getStatEnum() {
    return statEnum;
  }
}
