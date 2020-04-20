import java.util.ArrayList;
import java.util.Comparator;

/*
NO215 数组中的第k大元素
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素
 */
public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>(nums.length);
        for (int num : nums) {
            list.add(num);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        return list.get(k - 1);
    }

    public static void main(String[] args) {
        int[] n = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(new Solution215().findKthLargest(n, 4));
    }
}
