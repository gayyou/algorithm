package test.date;

public abstract class CalendarUnit {
  protected int currentPos;  // 这是一个通用的属性，年、月、日都在这里

  protected void setCurrentPos(int pCurrentPos) {
    currentPos = pCurrentPos;
  }

  protected int getCurrentPos() {
    return currentPos;
  }

  protected abstract boolean increment();
  protected abstract boolean isValid();
}
