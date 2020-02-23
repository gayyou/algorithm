package chaper4MoreEfficient.removeChonfu;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/2/5 20:25
 */
public class RemoveChongFu {
  public static int removeChonfu(int[] nums) {
    int len = nums.length;
    int i = 0;
    for(int j=1;j<len;j++){
      if(nums[i] != nums[j]){
        i++;
        nums[i] = nums[j];
      }
    }
    return i+1;
  }
}
