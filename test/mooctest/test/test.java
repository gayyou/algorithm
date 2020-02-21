package test.mooctest.test;

import org.junit.Test;
import test.mooctest.src.Jipa;

import static org.junit.Assert.*;

public class test {
  @Test(timeout = 4000)
  public void test00() {
    String[] stringArray0 = Jipa.splitArguments("6 kiXo,f^_`,'j$`");
    assertEquals(3, stringArray0.length);
  }

  @Test
  public void test01() {
    int int0 = Jipa.getValue("");
    assertEquals(int0, 0);
  }

  @Test
  public void test02() {
    String[] addOperandArr = new String[]{"novalue",                            // System Commands
            "set", "mov", "cpy", "var", "del", "arr",             // Setting Commands
            "add", "sub", "mul", "div", "mod",                  // Arithmethic
            "inc", "dec",                                 // Increment / Decrement
            "in", "out",                                  // Input/Output commands
            "jmp", "jnz", "jz", "je", "ja", "jae", "jb", "jbe", "jne",  // Jump commands
            "xor", "or", "and",                             // Logical Arithmethic
            "cmp"};

    for (String item : addOperandArr) {
      Jipa.processInstruction(item);
    }


  }

}
