import java.util.ArrayList;
import java.util.List;

/**
 * @author 11214
 * @since 2022/8/19 19:33
 * 95. 不同的二叉搜索树 II
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同二叉搜索树 。可以按 任意顺序 返回答案。
 */
public class Solution95 {
    public List<TreeNode> generateTrees(int n) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        return dfs(nums);
    }

    public List<TreeNode> dfs(List<Integer> nums) {
        if (nums.size() == 0) {
            List<TreeNode> trees = new ArrayList<>();
            trees.add(null);
            return trees;
        }

        List<TreeNode> trees = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> left = nums.subList(0, i);
            List<TreeNode> leftTrees = dfs(left);
            List<Integer> right = nums.subList(i + 1, nums.size());
            List<TreeNode> rightTrees = dfs(right);

            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(nums.get(i));
                    root.left = leftTree;
                    root.right = rightTree;
                    trees.add(root);
                }
            }
        }
        return trees;
    }

    public static void main(String[] args) {
        Solution95 solution95 = new Solution95();
        List<TreeNode> trees = solution95.generateTrees(3);
        for (TreeNode tree : trees) {
            System.out.println(tree);
        }
    }
}
