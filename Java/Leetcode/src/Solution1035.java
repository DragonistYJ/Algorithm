/**
 * @author 11214
 * @since 2022/12/4 10:50
 */
public class Solution1035 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] ans = new int[nums1.length][nums2.length];

        ans[0][0] = nums1[0] == nums2[0] ? 1 : 0;
        for (int i = 1; i < nums1.length; i++) {
            if (nums1[i] == nums2[0]) {
                ans[i][0] = 1;
            } else {
                ans[i][0] = ans[i - 1][0];
            }
        }
        for (int i = 1; i < nums2.length; i++) {
            if (nums1[0] == nums2[i]) {
                ans[0][i] = 1;
            } else {
                ans[0][i] = ans[0][i - 1];
            }
        }

        for (int i = 1; i < nums1.length; i++) {
            for (int j = 1; j < nums2.length; j++) {
                ans[i][j] = Math.max(ans[i - 1][j], ans[i][j - 1]);
                if (nums1[i] == nums2[j]) {
                    ans[i][j] = Math.max(ans[i][j], ans[i - 1][j - 1] + 1);
                }
            }
        }

        return ans[nums1.length - 1][nums2.length - 1];
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 5, 1, 2, 5};
        int[] nums2 = new int[]{10, 5, 2, 1, 5, 2};
        System.out.println(new Solution1035().maxUncrossedLines(nums1, nums2));
    }
}
