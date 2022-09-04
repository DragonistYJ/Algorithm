import java.util.ArrayList;
import java.util.List;

/**
 * @author yujian
 * @since 2022/9/4 16:16
 * <p>
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点。
 */
public class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root.left == null && root.right == null) {
            List<String> paths = new ArrayList<>();
            paths.add(String.valueOf(root.val));
            return paths;
        }

        List<String> paths = new ArrayList<>();
        if (root.left != null) {
            List<String> leftPaths = binaryTreePaths(root.left);
            for (String leftPath : leftPaths) {
                paths.add(root.val + "->" + leftPath);
            }
        }
        if (root.right != null) {
            List<String> rightPaths = binaryTreePaths(root.right);
            for (String rightPath : rightPaths) {
                paths.add(root.val + "->" + rightPath);
            }
        }
        return paths;
    }
}
