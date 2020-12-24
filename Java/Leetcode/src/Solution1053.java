import java.util.Arrays;

/*
NO1053 交换一次的先前排列
给你一个正整数的数组 A（其中的元素不一定完全不同），请你返回可在 一次交换（交换两数字 A[i] 和 A[j] 的位置）后得到的、按字典序排列小于 A 的最大可能排列。
如果无法这么操作，就请返回原数组。
 */
public class Solution1053 {
    public int[] prevPermOpt1(int[] A) {
        int len = A.length;
        if (len == 0) return new int[0];
        int[] copy = Arrays.copyOf(A, len);
        for (int i = len - 1; i >= 1; i--) {
            if (copy[i] < copy[i - 1]) {
                int index = i;
                int max = copy[i];
                for (int j = i; j < len; j++) {
                    if (copy[j] > max && copy[j] < copy[i - 1]) {
                        max = copy[j];
                        index = j;
                    }
                }
                int tmp = copy[i - 1];
                copy[i - 1] = copy[index];
                copy[index] = tmp;
                break;
            }
        }
        return copy;
    }

    public static void main(String[] args) {
        int[] x = {3, 1, 1, 3};
        System.out.println(Arrays.toString(new Solution1053().prevPermOpt1(x)));
    }
}
