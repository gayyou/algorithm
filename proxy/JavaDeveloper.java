package proxy;

public class JavaDeveloper implements Developer {
  @Override
  public void code() {
    System.out.println("java engineer is coding");
  }

  @Override
  public void debug() {
    System.out.println("java engineer is debugging");
  }
}
