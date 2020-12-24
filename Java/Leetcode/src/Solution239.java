import java.util.*;

/**
 * @ClassName Solution239
 * @Author 11214
 * @Date 2020/6/2
 * @Description TODO
 */
public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        TreeSet<Integer> tree = new TreeSet<>((o1, o2) -> o2 - o1);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < k; i++) {
            tree.add(nums[i]);
            if (hashMap.containsKey(nums[i])) hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
            else hashMap.put(nums[i], 1);
        }
        ans[0] = tree.first();
        for (int i = 1; i < n - k + 1; i++) {
            int numLeft = hashMap.get(nums[i - 1]);
            if (numLeft > 1) {
                hashMap.put(nums[i - 1], numLeft - 1);
            } else {
                hashMap.remove(nums[i - 1]);
                tree.remove(nums[i - 1]);
            }
            if (hashMap.containsKey(nums[i + k - 1])) {
                hashMap.put(nums[i + k - 1], hashMap.get(nums[i + k - 1]) + 1);
            } else {
                hashMap.put(nums[i + k - 1], 1);
                tree.add(nums[i + k - 1]);
            }
            ans[i] = tree.first();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(new Solution239().maxSlidingWindow(nums, 3)));
    }
}
