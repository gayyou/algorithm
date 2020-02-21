package operateingSystem.filemanage.core.operation;

import lombok.NoArgsConstructor;
import operateingSystem.filemanage.core.Exception.Impl.ErrorException;
import operateingSystem.filemanage.core.Exception.Impl.FailException;
import operateingSystem.filemanage.core.enums.MessageEnum;
import operateingSystem.filemanage.core.enums.OperationEnum;
import operateingSystem.filemanage.core.model.local.*;
import operateingSystem.filemanage.core.uitl.CommonUtil;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/1/3 22:26
 */
@NoArgsConstructor
public class Operation {
  private final int psbSize = 10;
  // 执行代码的上下文
  Context context;
  // 存放物理块的数组列表，相当于磁盘
  ArrayList<PSB> psbList;
  // FAT表
  ArrayList<FAT> fatList;
  // DCB树
  DCB rootDir;
  // 废弃的fat列表
  LinkedList<FAT> spaceFatList;

  {
    context = new Context();
    psbList = new ArrayList<>();
    fatList = new ArrayList<>();
    spaceFatList = new LinkedList<>();
  }

  public Operation(String account) {
    // 设置当前上下文的路径是用户的路径（即登陆后）
    this.context.setContextPath(account);
    this.rootDir = new DCB(account, account);
  }

  public void init() {
    // TODO 如果再次打开的时候，根据现有的目录对文件进行初始化
  }

  /**
   * @description 要注意一点，创建文件仅仅是对文件进行创建，并不会写入内容，也就是只创建FCB，然后把PSB设空
   * @param name
   * @param value
   * @return
   */
  private boolean createFile(String name) {
    if (openFile(name) != null) {
      return false;
    }

    FCB fcb = new FCB(name, this.context.getContextDCB());

    this.context.getContextDCB().getFileList().add(fcb);

    return true;
  }

  /**
   * @description 拿到文件的FCB块
   * @param name
   * @return
   */
  private FCB openFile(String name) {
    FCB target = null;
    for (FCB item : this.context.getContextDCB().getFileList()) {
      if (item.getName().equals(name)) {
        target = item;
      }
    }
    return target;
  }

  /**
   * @description 读取fcb的内容，并且到物理块中进行获取数据
   * @param fcb
   * @return
   */
  private String readFile(FCB fcb) {
    StringBuilder readString = new StringBuilder();
    FAT fat = fcb.getFat();
    while (fat.getNextFATIndex() != -1) {
      readString.append(psbList.get(fat.getPSBIndex()));
      fat = fatList.get(fat.getNextFATIndex());
    }

    fcb.setRecentlyReadTime(CommonUtil.getCurrentTime());

    return readString.toString();
  }

  /**
   * @description 写文件的思路是：
   * 1. 先将已经分配好的物理块进行覆盖。
   * 2. 覆盖完如果psb块不够使用的话，就另外申请内存
   * 3. 如果有剩余的话，将剩下的psb块内容置空，并且把它们挂到回收队列中
   * @param name
   * @param value
   * @return
   */
  private boolean writeFile(String name, String value) throws FailException {
    if (this.context.getCurrentFCB() == null) {
      throw new FailException(MessageEnum.FAIL);
    }
    FCB currentFCB = this.context.getCurrentFCB();
    currentFCB.setName(name);
    FAT fat = currentFCB.getFat();
    int count = (int) Math.ceil((double) value.length() / psbSize);  // 计算出需要多少个文件块
    int currentFatCount = 0;

    if (fat == null) {
      fat = new FAT();
      currentFCB.setFat(fat);
      fatList.add(fat);

      for (int i = 1; i < count; i++) {
        fat.setNextFATIndex(fatList.size());
        fat = new FAT();
        fatList.add(fat);
      }
    } else {
      // 先把可以复用的fat进行复用
      while (fat.getNextFATIndex() != -1 && currentFatCount < count) {
        currentFatCount++;
        fat = fatList.get(fat.getNextFATIndex());
      }

      // 如果写进来的文件所需的物理块大小大于已经有的物理块大小的话，那么进行申请空间
      while (currentFatCount < count) {
        // 申请fat
        fat.setNextFATIndex(fatList.size());
        fat = new FAT();
        fatList.add(fat);

        // 申请空间
        PSB psb = new PSB();
        fat.setPSBIndex(psbList.size());
        psbList.add(psb);
        currentFatCount++;
      }

      // 如果写进来的数据反而比之前的数据少了的话，则将不需要的fat放置到空闲列表中
      if (fat.getNextFATIndex() != -1) {
        FAT temp = fatList.get(fat.getNextFATIndex());
        FAT temp2;
        fat.setNextFATIndex(-1);
        while (temp.getNextFATIndex() != -1) {
          // 相当于free
          temp2 = temp;
          temp = fatList.get(temp.getNextFATIndex());
          temp2.setNextFATIndex(-1);
          psbList.get(temp2.getPSBIndex()).setUsing(false);
          spaceFatList.add(temp2);
        }
      }
    }

    fat = this.context.getCurrentFCB().getFat();
    int stringSplitIndex = 0;
    while (fat.getNextFATIndex() != -1) {
      this.psbList.get(fat.getPSBIndex())
              .setValue(value.substring(stringSplitIndex * psbSize,
                      Math.min(((stringSplitIndex + 1) * psbSize), value.length())));
      stringSplitIndex++;
    }

    this.context.getCurrentFCB().setRecentlyWriteTime(CommonUtil.getCurrentTime());

    return true;
  }

  private boolean closeFile() {
    if (this.context.getCurrentFCB() != null) {
      this.context.setCurrentFCB(null);
      return true;
    }
    return false;
  }

  private boolean deleteFile(String fileName) {
    // 先清空，也就是把psb和fat表中关于这个文件的内容进行清空
    if (!writeFile(fileName, "")) {
      return false;
    }
    // 接下来文件树中进行删除fcb块
    this.context.getContextDCB().getFileList().remove(this.context.getCurrentFCB());
    return true;
  }

  private boolean changeDir(String path) {
    return false;
  }

  private void showDir() {
    for (DCB dcb : this.context.getContextDCB().getDirList()) {
      System.out.println("Directory | " + dcb.getName());
    }
    for (FCB fcb : this.context.getContextDCB().getFileList()) {
      System.out.println("File | " + fcb.getName() + " read time:" + fcb.getRecentlyReadTime() + " write time:" + fcb.getRecentlyWriteTime());
    }
  }

  private boolean mkDir(String name) {
    DCB currentDCB = this.context.getContextDCB();
    if (currentDCB == null) {
      throw new ErrorException(MessageEnum.ERROR);
    }

    // 创建dcb
    DCB dcb = new DCB(currentDCB.getBasePath() + "/" + name, name, currentDCB);
    currentDCB.getDirList().add(dcb);
    return true;
  }

  public void receiveOperation(Instruction operate) {
    OperationEnum operationEnum = OperationEnum.getOperationEnum(operate.getOperate());
    if (operationEnum == null) {
      System.out.println(operate.getOperate() + " 不是一个有效的操作命令");
      return ;
    }
    switch (operationEnum) {
      case OPEN: {
        FCB fcb = openFile(operate.getName());
        if (fcb == null) {
          System.out.println("打开文件失败！");
        } else {
          this.context.setCurrentFCB(fcb);
        }
        break;
      }

      case CREATE: {
        if (createFile(operate.getName())) {
          System.out.println("创建文件成功");
        } else {
          System.out.println("创建文件失败");
        }
        break;
      }

      case READ: {
        String result = readFile(this.context.getCurrentFCB());
        break;
      }

      case WRITE: {
        if (writeFile(operate.getName(), operate.getValue())) {

        } else {

        }
        break;
      }

      case CLOSE: {
        if (closeFile()) {

        } else {

        }
        break;
      }

      case DELETE: {
        if (deleteFile(operate.getName())) {

        } else {

        }
        break;
      }

      case MKDIR: {
        if (mkDir(operate.getName())) {

        } else {

        }
        break;
      }

      case CD: {
        if (changeDir(operate.getName())) {

        } else {

        }
        break;
      }

      case DIR: {
        showDir();
        break;
      }
    }
  }
}
