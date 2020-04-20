/*
NO33 搜索旋转排序数组
 */
public class Solution33 {
    public int search(int[] nums, int target) {
        int start = -1;
        int len = nums.length;
        if (len == 0) return -1;
        if (len == 1) return nums[0] == target ? 0 : -1;
        int left = 0;
        int right = len - 1;
        if (nums[0] >= nums[len - 1]) {
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] > nums[mid + 1]) {
                    start = mid;
                    break;
                }
                if (nums[mid] >= nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        left = 0;
        right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int trueMid = (mid + start + 1) % len;
            if (nums[trueMid] == target) return trueMid;
            if (nums[trueMid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] x = {1, 3};
        System.out.println(new Solution33().search(x, 1));
    }
}
