package algorithms.stack.reverseStackElems;

import java.util.Stack;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/2/17 20:37
 */
public class ReverseStackElems {
  public static int reverseStackElem(Stack<Integer> stack) {
    int result = stack.pop();
    if (stack.isEmpty()) {
      return result;
    }
    int last = reverseStackElem(stack);
    stack.push(result);
    return last;
  }

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
    System.out.println(ReverseStackElems.reverseStackElem(stack));
    System.out.println(ReverseStackElems.reverseStackElem(stack));
    System.out.println(ReverseStackElems.reverseStackElem(stack));
    System.out.println(ReverseStackElems.reverseStackElem(stack));
    System.out.println(ReverseStackElems.reverseStackElem(stack));
  }
}
