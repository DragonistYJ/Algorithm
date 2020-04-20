import java.util.ArrayList;
import java.util.List;

/*
NO60 第k个排列
给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
"123"
"132"
"213"
"231"
"312"
"321"
给定 n 和 k，返回第 k 个排列。
 */
public class Solution60 {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        int[] tan = new int[n + 1];
        tan[0] = 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
            tan[i] = tan[i - 1] * i;
        }

        int index = k - 1;
        for (int i = n - 1; i > 0; i--) {
            int t = index / tan[i];
            builder.append(nums.get(t));
            nums.remove(t);
            index %= tan[i];
        }
        builder.append(nums.get(0));
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution60().getPermutation(3, 3));
    }
}
