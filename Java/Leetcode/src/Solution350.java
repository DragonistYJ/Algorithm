import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
NO350 两个数组的交集
给定两个数组，编写一个函数来计算它们的交集。
 */
public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : nums1) {
            if (hashMap.containsKey(i)) {
                hashMap.put(i, hashMap.get(i) + 1);
            } else {
                hashMap.put(i, 1);
            }
        }
        List<Integer> ansList = new ArrayList<>();
        for (int i : nums2) {
            if (!hashMap.containsKey(i) || hashMap.get(i) == 0) continue;
            ansList.add(i);
            hashMap.put(i, hashMap.get(i) - 1);
        }
        int[] ans = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] x = {4, 9, 5};
        int[] y = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(new Solution350().intersect(x, y)));
    }
}
