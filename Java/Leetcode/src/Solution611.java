import java.util.*;

/**
 * @author 11214
 * @since 2022/11/22 9:45
 * <p>
 * 给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
 */
public class Solution611 {
    public int triangleNumber(int[] nums) {
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            if (num != 0) {
                numList.add(num);
            }
        }
        numList.sort(Comparator.comparingInt(o -> o));
        if (numList.size() == 0) {
            return 0;
        }

        Map<Integer, Integer> upperMap = new HashMap<>();
        upperMap.put(numList.get(0), 1);
        for (int i = 1; i < numList.size(); i++) {
            int pre = upperMap.get(numList.get(i - 1));
            for (int j = numList.get(i - 1); j < numList.get(i); j++) {
                upperMap.put(j, pre);
            }
            upperMap.put(numList.get(i), pre + 1);
        }

        int ans = 0;
        for (int i = 0; i < numList.size() - 2; i++) {
            for (int j = i + 1; j < numList.size() - 1; j++) {
                int upper = numList.get(i) + numList.get(j) - 1;
                int n;
                if (upper >= numList.get(numList.size() - 1)) {
                    n = numList.size() - j - 1;
                } else {
                    n = upperMap.get(upper) - j - 1;
                }
                ans += n;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution611().triangleNumber(new int[]{0}));
    }
}
