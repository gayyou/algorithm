package chaper2DataStruction;

import java.util.ArrayList;
import java.util.HashMap;

public class FindRepeat {
  public static ArrayList<Integer> getRepeat(Integer[] args) {
    ArrayList<Integer> resultArray = new ArrayList<>();
    HashMap<Integer, Boolean> map = new HashMap<>();
    for (Integer arg : args) {
      if (map.get(arg) != null) {
        resultArray.add(arg);
      } else {
        map.put(arg, true);
      }
    }

    return resultArray;
  }

  public static ArrayList<Integer> getRepeatByArray(Integer[] args) {
    if (args.length == 0) {
      return new ArrayList<>();
    }

    for (Integer item : args) {
      if (item < 0 || item > args.length) {
        return new ArrayList<>();
      }
    }

    ArrayList<Integer> resultArray = new ArrayList<>();

    for (int i = 0; i < args.length; i++) {
      // 当args内容并不和下标一致时候，则进行判断这个元素所在下标数字是否一致，如果一致，说明有重复，进行获取数值，
      // 否则进行交换数字，然后i要回退
      if (args[i] != i) {
        if (args[i].equals(args[args[i]])) {
          boolean isExist = false;
          for (Integer item : resultArray) {
            if (item.equals(args[i])) {
              isExist = true;
              break;
            }
          }
          if (!isExist) {
            resultArray.add(args[i]);
          }
        } else {
          int temp = args[i];
          args[i] = args[args[i]];
          args[temp] = temp;
          i--;
        }
      }
    }

    return resultArray;
  }

  public static void main(String[] args) {
    Integer[] arg = new Integer[]{1, 2, 1, 2, 4, 3, 4, 0, 5, 6, 9, 9};
    System.out.println(FindRepeat.getRepeatByArray(arg));
  }
}
