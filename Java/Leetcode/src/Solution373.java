import java.util.*;

/**
 * @author yujian
 * @since 2022/9/10 11:23
 * 给定两个以 升序排列 的整数数组 nums1 和 nums2,以及一个整数k。
 * 定义一对值(u,v)，其中第一个元素来自nums1，第二个元素来自 nums2。
 * 请找到和最小的 k个数对(u1,v1), (u2,v2) ... (uk,vk)。
 */
public class Solution373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]);
        for (int i = 0; i < nums1.length; i++) {
            queue.offer(new int[]{i, 0});
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int[] poll = queue.poll();
            if (poll == null) {
                break;
            }
            List<Integer> list = new ArrayList<>();
            list.add(nums1[poll[0]]);
            list.add(nums2[poll[1]]);
            ans.add(list);
            if (poll[1] + 1 < nums2.length) {
                queue.offer(new int[]{poll[0], poll[1] + 1});
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution373().kSmallestPairs(
                new int[]{1, 7, 11},
                new int[]{2, 4, 6},
                3
        ));
    }
}
