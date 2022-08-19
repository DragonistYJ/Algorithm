import java.util.*;

/**
 * @author 11214
 * @since 2022/8/19 15:26
 * 368. 最大整除子集
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 */
public class Solution368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        HashMap<Integer, List<Integer>> ansMap = new HashMap<>();

        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        numList.sort(Comparator.comparingInt(o -> o));

        for (Integer num : numList) {
            List<Integer> ans = new ArrayList<>();
            ans.add(num);
            for (Integer key : ansMap.keySet()) {
                if (num % key == 0) {
                    if (ansMap.get(key).size() + 1 > ans.size()) {
                        ans = new ArrayList<>(ansMap.get(key));
                        ans.add(num);
                    }
                }
            }
            ansMap.put(num, ans);
        }

        List<Integer> ans = new ArrayList<>();
        for (Integer key : ansMap.keySet()) {
            if (ansMap.get(key).size() > ans.size()) {
                ans = ansMap.get(key);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution368 solution368 = new Solution368();
        System.out.println(solution368.largestDivisibleSubset(new int[]{1, 2, 4, 8}));
    }
}
