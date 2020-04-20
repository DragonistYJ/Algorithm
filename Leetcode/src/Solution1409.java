import java.util.Arrays;

/**
 * @ClassName 查询带键的排列
 * @Author 11214
 * @Date 2020/4/18
 * @Description 给你一个待查数组 queries ，数组中的元素为 1 到 m 之间的正整数。 请你根据以下规则处理所有待查项 queries[i]（从 i=0 到 i=queries.length-1）：
 * 一开始，排列 P=[1,2,3,...,m]。
 * 对于当前的 i ，请你找出待查项 queries[i] 在排列 P 中的位置（下标从 0 开始），然后将其从原位置移动到排列 P 的起始位置（即下标为 0 处）。注意， queries[i] 在 P 中的位置就是 queries[i] 的查询结果。
 * 请你以数组形式返回待查数组  queries 的查询结果。
 */
public class Solution1409 {
    public int[] processQueries(int[] queries, int m) {
        int[] nums = new int[m];
        for (int i = 0; i < m; i++) {
            nums[i] = i + 1;
        }
        int n = queries.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int j = 0;
            while (nums[j] != queries[i]) j++;
            ans[i] = j;
            int t = nums[j];
            while (j > 0) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[0] = t;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {7, 5, 5, 8, 3};
        System.out.println(Arrays.toString(new Solution1409().processQueries(nums, 8)));
    }
}
