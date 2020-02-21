package algorithms.dynamic.packageQuestion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/1/9 14:37
 */
@Data
public class Thing {
  int weight;
  int value;
  int count;

  public Thing(int value, int weight, int count) {
    this.value = value;
    this.weight = weight;
    this.count = count;
  }

  public Thing(int value, int weight) {
    this.value = value;
    this.weight = weight;
  }

  public Thing(Thing thing, int count) {
    this.value = thing.getValue();
    this.weight = thing.getWeight();
    this.count = count;
  }
}
