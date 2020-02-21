package chaper3HeightQuailty;

import org.junit.Test;
import java.util.Arrays;

/**
 * @description 该算法的难点在于能够想到程序的可扩展性，在这里使用函数式接口OrderResolve是方面不断变化的需求
 * 目前的需求是将偶数放到奇数后面，以后的需求可能是将负数放到前面，正数放到后面，都是有可能的。
 * @// TODO: 2019/10/3 这里花费时间比较长的是将lambda表达式作为参数时候怎么做，需要使用到函数式接口 
 */
public class ReorderOddEven {
  public void ReorderOddEven(int[] data, OrderResolve callback) {
    if (data.length == 0) {
      return ;
    }
    int temp;
    int leftPoint = 0, rightPoint = data.length - 1;

    while(leftPoint < rightPoint) {
      while(rightPoint > leftPoint && !callback.run(data[rightPoint])) {
        rightPoint--;
      }

      while (leftPoint < rightPoint && callback.run(data[leftPoint])) {
        leftPoint++;
      }

      if (leftPoint < rightPoint) {
        temp = data[leftPoint];
        data[leftPoint] = data[rightPoint];
        data[rightPoint] = temp;
      }
    }
  }

  @Test
  public void test01() {
    int[] data = new int[]{1, 3, 2, 1, 1,11, 2, 3, 1,2 ,2,2, 2, 2, 2, 2, 1,2,2 };
    ReorderOddEven reorderOddEven = new ReorderOddEven();
    reorderOddEven.ReorderOddEven(data, (a) -> {return a % 2 == 1;});
    System.out.println(Arrays.toString(data));
  }
}

@FunctionalInterface
interface OrderResolve{
  boolean run(int a);
}