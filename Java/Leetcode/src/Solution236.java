import java.util.ArrayList;
import java.util.List;

/**
 * @author yujian
 * @since 2023/7/26 16:06
 * <p>
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class Solution236 {
    private boolean findPath(TreeNode root, TreeNode p, List<TreeNode> path) {
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root == p) {
            return true;
        }
        if (findPath(root.left, p, path)) {
            return true;
        }
        if (findPath(root.right, p, path)) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = new ArrayList<>();
        findPath(root, p, pathP);
        List<TreeNode> pathQ = new ArrayList<>();
        findPath(root, q, pathQ);
        int idx = 0;
        while (idx < pathP.size() && idx < pathQ.size() && pathP.get(idx) == pathQ.get(idx)) {
            idx += 1;
        }
        return pathP.get(idx - 1);
    }
}
