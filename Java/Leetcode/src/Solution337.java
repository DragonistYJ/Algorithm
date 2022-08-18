import java.util.HashMap;

/**
 * @author 11214
 * @since 2022/8/18 19:18
 * Leetcode 337 打家劫舍 III
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为root。
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 */
public class Solution337 {
    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> maxValueMap = new HashMap<>();
        dfs(root, maxValueMap);
        return maxValueMap.get(root);
    }

    public int dfs(TreeNode root, HashMap<TreeNode, Integer> maxValueMap) {
        if (root == null) {
            return 0;
        }
        if (maxValueMap.containsKey(root)) {
            return maxValueMap.get(root);
        }

        int a = dfs(root.left, maxValueMap) + dfs(root.right, maxValueMap);
        int b = root.val;
        if (root.left != null) {
            b += dfs(root.left.left, maxValueMap) + dfs(root.left.right, maxValueMap);
        }
        if (root.right != null) {
            b += dfs(root.right.left, maxValueMap) + dfs(root.right.right, maxValueMap);
        }
        int ans = Math.max(a, b);
        maxValueMap.put(root, ans);
        return ans;
    }
}
