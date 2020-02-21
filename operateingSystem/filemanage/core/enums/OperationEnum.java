package operateingSystem.filemanage.core.enums;

import operateingSystem.filemanage.core.operation.Operation;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/1/3 22:16
 */
public enum OperationEnum {
  CREATE("create"),
  OPEN("open"),
  READ("read"),
  WRITE("write"),
  CLOSE("close"),
  DELETE("delete"),
  MKDIR("mkdir"),
  CD("cd"),
  DIR("ls");

  private String operate;

  OperationEnum(String operate) {
    this.operate = operate.toLowerCase();
  }

  public static OperationEnum getOperationEnum(String operate) {
    String lowerCaseOperate = operate.toLowerCase();
    for (OperationEnum item : OperationEnum.values()) {
      if (item.getEnumValue().equals(lowerCaseOperate)) {
        return item;
      }
    }
    return null;
  }

  private String getEnumValue() {
    return this.operate;
  }
}
