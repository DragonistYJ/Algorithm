import java.util.*;

/*
NO321 拼接最大数
给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
说明: 请尽可能地优化你算法的时间和空间复杂度。
 */
public class Solution321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0 && nums2.length == 0) return new int[0];
        if (nums1.length == 0) return getMaxList(nums2, k);
        if (nums2.length == 0) return getMaxList(nums1, k);

        int len1 = Math.min(nums1.length, k);
        int len2 = Math.min(nums2.length, k);
        int[] ans = new int[k];
        for (int i = 0; i <= len1; i++) {
            int j = k - i;
            if (len2 < j) continue;
            int[] maxList1 = getMaxList(nums1, i);
            int[] maxList2 = getMaxList(nums2, j);
            int[] combineLists = combineLists(maxList1, maxList2);
            if (aLargeB(combineLists, ans)) {
                ans = combineLists;
            }
        }
        return ans;
    }

    private int[] getMaxList(int[] list, int aim) {
        if (aim == 0) return new int[0];
        Stack<Integer> stack = new Stack<>();
        stack.push(list[0]);
        int todo = list.length - aim;
        for (int i = 1; i < list.length; i++) {
            while (!stack.isEmpty() && list[i] > stack.peek() && todo > 0) {
                todo -= 1;
                stack.pop();
            }
            stack.push(list[i]);
        }
        while (stack.size() > aim) stack.pop();
        int[] ans = new int[aim];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    private int[] combineLists(int[] list1, int[] list2) {
        int[] list = new int[list1.length + list2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < list1.length && j < list2.length) {
            if (aLargeB(Arrays.copyOfRange(list1, i, list1.length), Arrays.copyOfRange(list2, j, list2.length))) {
                list[k] = list1[i];
                i += 1;
                k += 1;
            } else {
                list[k] = list2[j];
                j += 1;
                k += 1;
            }
        }
        while (i < list1.length) {
            list[k] = list1[i];
            i += 1;
            k += 1;
        }
        while (j < list2.length) {
            list[k] = list2[j];
            j += 1;
            k += 1;
        }
        return list;
    }

    private boolean aLargeB(int[] list1, int[] list2) {
        int len = Math.min(list1.length, list2.length);
        for (int i = 0; i < len; i++) {
            if (list1[i] > list2[i]) return true;
            else if (list1[i] < list2[i]) return false;
        }
        return list1.length > list2.length;
    }

    public static void main(String[] args) {
        int[] x = {5, 6, 8};
        int[] y = {6, 4, 0};
        System.out.println(Arrays.toString(new Solution321().maxNumber(x, y, 3)));
    }
}
