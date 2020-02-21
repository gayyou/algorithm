package chaper3HeightQuailty;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Weybn
 * @motto Rare in the word you're worth it.
 * @time 2019/12/8 21:00
 */
public class FullArray {
  HashMap<String, String[]> hashMap = new HashMap<>();

  public String[] getFullArray(String target) {
    if (target.length() == 1) {
      return new String[]{target};
    }
    if (hashMap.get(target) != null) {
      return hashMap.get(target);
    }
    ArrayList<String> arrayList = new ArrayList<>();
    for (int i = 0; i < target.length(); i++) {
      String head = target.substring(i, i + 1);
      String[] strings = this.getFullArray(target.substring(0, i) + target.substring(i + 1));
      for (String str : strings) {
        arrayList.add(head + str);
      }
    }
    hashMap.put(target, arrayList.toArray(new String[0]));

    return arrayList.toArray(new String[0]);
  }

  private String[] getCombination(String target) {
    // 首先进行排序
    if (target.length() == 1) {
      return new String[]{target, ""};
    }
    String[] strings = getCombination(target.substring(1));
    String start = target.substring(0, 1);
    ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(strings));
    for (String string : strings) {
      arrayList.add(start + string);
    }

    return arrayList.toArray(new String[0]);
  }

  public String[] getCombinations(String target) {
    char[] chars = target.toCharArray();
    Arrays.sort(chars);
    String[] strings = this.getCombination(Arrays.toString(chars));
    LinkedList<String> linkedList = new LinkedList<>(Arrays.asList(strings));
    linkedList.remove("");
    return linkedList.toArray(new String[0]);
  }

  public static void main(String[] args) {
    FullArray fullArray = new FullArray();
    System.out.println(Arrays.toString(fullArray.getCombinations("1111")));
  }
}
