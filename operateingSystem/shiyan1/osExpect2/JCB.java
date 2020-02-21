package operateingSystem.shiyan1.osExpect2;

import java.util.Comparator;

public class JCB {
  public String name;
  public int runTime;
  public int submitTime;
  public int resource;
  public char state;
  public int authority;
  public int needMachine;
  public int startWorkTime;
  public int finishTime;
  public int workTime;
  public int serveTime;
  public float auServeTime;

  public JCB(String name, int runTime, int submitTime, int resource, char state, int needMachine) {
    this.name = name;
    this.runTime = runTime;
    this.submitTime = submitTime;
    this.resource = resource;
    this.state = state;
    this.needMachine = needMachine;
  }

  public JCB(String name, int runTime, int submitTime, int resource, char state, int authority, int needMachine) {
    this.name = name;
    this.runTime = runTime;
    this.submitTime = submitTime;
    this.resource = resource;
    this.state = state;
    this.authority = authority;
    this.needMachine = needMachine;
  }
}
