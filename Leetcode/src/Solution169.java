import java.util.*;

/*
NO169 多数元素
给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class Solution169 {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if (hashMap.containsKey(num)) {
                hashMap.put(num, hashMap.get(num) + 1);
            } else {
                hashMap.put(num, 1);
            }
        }
        Set<Integer> keys = hashMap.keySet();
        for (Integer key : keys) {
            if (hashMap.get(key) > n / 2) return key;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] x = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(new Solution169().majorityElement(x));
    }
}
