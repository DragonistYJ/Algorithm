/*
NO654 最大二叉树
给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：

二叉树的根是数组中的最大元素。
左子树是通过数组中最大值左边部分构造出的最大二叉树。
右子树是通过数组中最大值右边部分构造出的最大二叉树。
通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 */
public class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(0, nums.length - 1, nums);
    }

    private TreeNode construct(int left, int right, int[] nums) {
        if (left == right) {
            return new TreeNode(nums[left]);
        } else if (right < left) {
            return null;
        }

        int index = left;
        int max = nums[left];
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode node = new TreeNode(nums[index]);
        node.left = construct(left, index - 1, nums);
        node.right = construct(index + 1, right, nums);
        return node;
    }

    public static void main(String[] args) {
        int[] x = {3, 2, 1, 6, 0, 5};
        System.out.println(new Solution654().constructMaximumBinaryTree(x));
    }
}
