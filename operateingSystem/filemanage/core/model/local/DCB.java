package operateingSystem.filemanage.core.model.local;

import lombok.Data;

import java.util.LinkedList;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/1/4 11:07
 */
@Data
public class DCB {
  String basePath;
  String name;
  DCB parent;
  LinkedList<DCB> dirList;
  LinkedList<FCB> fileList;

  {
    dirList = new LinkedList<>();
    fileList = new LinkedList<>();
  }

  public DCB(String basePath, String name) {
    this.basePath = basePath;
    this.name = name;
  }

  public DCB(String basePath, String name, DCB parent) {
    this.basePath = basePath;
    this.name = name;
    this.parent = parent;
  }
}
