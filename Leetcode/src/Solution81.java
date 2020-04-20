/*
NO81 搜索旋转排序数组2
假设按照升序排序的数组在预先未知的某个点上进行了旋转。
( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 */
public class Solution81 {
    public boolean search(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] x = {3, 1};
        System.out.println(new Solution81().search(x, 1));
    }
}
