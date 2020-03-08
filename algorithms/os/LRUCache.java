package algorithms.os;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/3/4 22:55
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {
  private int capacity;
  private LRU lru;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.lru = new LRU(0, 0.75f, true);
  }

  public int get(int key) {
    return lru.getOrDefault(key,-1);
  }

  public void put(int key, int value) {
    lru.put(key, value);
  }

  class LRU extends LinkedHashMap<Integer, Integer> {
    public LRU(int initialCapacity, float loadFactor, boolean accessOrder) {
      super(initialCapacity, loadFactor, accessOrder);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
      return super.size() > capacity;
    }
  }
}