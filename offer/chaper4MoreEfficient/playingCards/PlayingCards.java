package chaper4MoreEfficient.playingCards;

import java.util.HashMap;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/1/27 10:04
 * @description 利用桶排的思想来进行填充，填充完毕后从最小的数字开始进行按顺子递增，只要递增成功时候就
 */
public class PlayingCards {
  public static HashMap<Character, Integer> cardMap;

  static {
    cardMap = new HashMap<>();
    cardMap.put('1', 1);
    cardMap.put('2', 2);
    cardMap.put('3', 3);
    cardMap.put('4', 4);
    cardMap.put('5', 5);
    cardMap.put('6', 6);
    cardMap.put('7', 7);
    cardMap.put('8', 8);
    cardMap.put('9', 9);
    cardMap.put('J', 10);
    cardMap.put('Q', 11);
    cardMap.put('K', 12);
    cardMap.put('I', 0);
    cardMap.put('O', 0);
  }

  public static boolean isOrder(String target) {
    if (target == null || target.length() == 0) {
      return false;
    }

    int[] container = new int[13];
    int minNumber = 14;
    int size = target.length();

    for (char item : target.toCharArray()) {
      int number = cardMap.get(item);

      if (number != 0 && container[number] >= 1) {
        return false;
      }

      container[number] += 1;
      minNumber = number > 0 ? Math.min(number, minNumber) : minNumber;
    }

    // 全部是王，那么也是正确的
    if (minNumber == 14) {
      return true;
    }

    for (int i = minNumber; i < minNumber + size && i < 13; i++) {
      if (i == 12) {
        return true;
      }

      if (container[i] == 1) {
        continue ;
      }

      if (container[0] == 0) {
        return false;
      }

      container[0]--;
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(PlayingCards.isOrder("12356"));
    System.out.println(PlayingCards.isOrder("1233"));
    System.out.println(PlayingCards.isOrder("12356I"));
    System.out.println(PlayingCards.isOrder("1236I"));
    System.out.println(PlayingCards.isOrder("12356IO"));
    System.out.println(PlayingCards.isOrder(""));
    System.out.println(PlayingCards.isOrder("IO"));
    System.out.println(PlayingCards.isOrder("JQK"));
    System.out.println(PlayingCards.isOrder("9J"));
  }
}
