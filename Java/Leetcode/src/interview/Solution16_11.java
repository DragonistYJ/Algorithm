package interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * @ClassName Solution16_11
 * @Author 11214
 * @Date 2020/4/20
 * @Description TODO
 */
public class Solution16_11 {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[0];
        TreeSet<Integer> set = new TreeSet<>(Comparator.comparingInt(o -> o));
        for (int i = 0; i <= k; i++) {
            set.add(shorter * (k - i) + longer * i);
        }
        int[] ans = new int[set.size()];
        int index = 0;
        for (Integer integer : set) {
            ans[index++] = integer;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution16_11().divingBoard(1, 1, 0)));
    }
}
