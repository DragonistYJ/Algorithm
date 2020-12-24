package interview;

import java.util.HashMap;
import java.util.Set;

/**
 * @ClassName Solution56_2
 * @Author 11214
 * @Date 2020/4/11
 * @Description TODO
 */
public class Solution56_2 {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if (hashMap.containsKey(num)) {
                hashMap.put(num, hashMap.get(num) + 1);
            } else {
                hashMap.put(num, 1);
            }
        }
        Set<Integer> keySet = hashMap.keySet();
        for (Integer key : keySet) {
            if (hashMap.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }
}
