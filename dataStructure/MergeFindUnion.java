package dataStructure;

import java.util.HashMap;

/**
 * @author Weybn
 * @motto Rare in the word you're worth it.
 * @time 2019/12/15 15:55
 */
public class MergeFindUnion<T> {
  // 并查集hashMap，这个map来作为一个树状结构来存储集合，这样实现快合并
  public HashMap<T, T> hashMap = new HashMap<>();
  // 这个是记录上面hashMap每棵树的大小，这样可以在实现子树的合并的时候，只需要将小的树放到大的树上面去，从而减少计算量
  public HashMap<T, Integer> sizeMap = new HashMap<>();

  public T find(T item) {
    if (item == null) {
      return null;
    }
    if (hashMap.get(item) == item) {
      return item;
    }
    hashMap.put(item, find(hashMap.get(item)));
    return hashMap.get(item);
  }

  public void makeSet(T item) {
    hashMap.put(item, item);
    sizeMap.put(item, 1);
  }

  public void union(T x, T y) {
    T parent = find(x);
    T child = find(y);

    if (x != y) {
      if (sizeMap.get(parent) >= sizeMap.get(child)) {
        hashMap.put(child, parent);
        sizeMap.put(child, sizeMap.get(child) + sizeMap.get(parent));
      } else {
        hashMap.put(parent, child);
        sizeMap.put(parent, sizeMap.get(child) + sizeMap.get(parent));
      }
    }
  }
}
