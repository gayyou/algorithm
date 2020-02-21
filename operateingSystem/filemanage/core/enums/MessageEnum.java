package operateingSystem.filemanage.core.enums;

public enum MessageEnum {
  ZERO(-1, "无状态"),
  FAIL(1, "操作失败"),
  SUCCESS(0, "操作成功"),
  ERROR(-2, "系统错误"),
  CREATE_FILE_FAIL(1, "已存在目标文件，创建失败"),
  CREATE_DIR_FAIL(1, ""),
  DELETE_FILE_FAIL(1, ""),
  RENAME_FILE_FAIL(1, "");

  private int state;
  private String stateInfo;
  MessageEnum(int state, String stateInfo) {}

  public int getState() {
    return this.state;
  }

  public String getStateInfo() {
    return this.stateInfo;
  }
}
