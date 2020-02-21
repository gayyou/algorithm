package operateingSystem.shiyan1.osExpect1;

import java.util.Deque;
import java.util.LinkedList;

public class PCBDeque {
  public int authority;
  public int roundTime;
  public Deque<PCB> deque;

  public PCBDeque(int authority, int roundTime) {
    this.authority = authority;
    this.roundTime = roundTime;
    this.deque = new LinkedList<>();
  }
}
