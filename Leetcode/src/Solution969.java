import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
NO969 煎饼排序
给定数组 A，我们可以对其进行煎饼翻转：我们选择一些正整数 k <= A.length，然后反转 A 的前 k 个元素的顺序。
我们要执行零次或多次煎饼翻转（按顺序一次接一次地进行）以完成对数组 A 的排序。
返回能使 A 排序的煎饼翻转操作所对应的 k 值序列。任何将数组排序且翻转次数在 10 * A.length 范围内的有效答案都将被判断为正确。
 */
public class Solution969 {
    public List<Integer> pancakeSort(int[] A) {
        int n = A.length;
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) {
            order[i] = i + 1;
        }
        Arrays.sort(order, (o1, o2) -> A[o2 - 1] - A[o1 - 1]);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            ans.add(order[i]);
            ans.add(n - i);
            int pos = order[i];
            for (int j = i; j < n; j++) {
                if (order[j] <= pos) {
                    order[j] = pos - order[j] + 1;
                }
                if (order[j] <= n - i) {
                    order[j] = n - i + 1 - order[j];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] number = new int[]{3, 2, 4, 1};
        System.out.println(new Solution969().pancakeSort(number));
    }
}
