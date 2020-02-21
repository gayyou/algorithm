package operateingSystem.shiyan1.osExpect1;

public class PCB {
  public String name;
  public char state;
  public int supers;
  public int allTime;
  public int resultTime;

  public PCB(String name, char state, int supers, int allTime, int resultTime) {
    this.name = name;
    this.state = state;
    this.supers = supers;
    this.allTime = allTime;
    this.resultTime = resultTime;
  }

  public PCB(String name, char state, int allTime, int resultTime) {
    this.name = name;
    this.state = state;
    this.allTime = allTime;
    this.resultTime = resultTime;
  }
}