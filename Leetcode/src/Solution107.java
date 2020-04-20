import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
NO107 二叉树的层次遍历
给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 */
public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        List<TreeNode> levels = new ArrayList<>();
        levels.add(root);
        while (!levels.isEmpty()) {
            List<TreeNode> tmp = new ArrayList<>(levels);
            List<Integer> oneAns = new ArrayList<>();
            levels.clear();
            for (TreeNode node : tmp) {
                if (node.left != null) levels.add(node.left);
                if (node.right != null) levels.add(node.right);
                oneAns.add(node.val);
            }
            ans.add(oneAns);
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {

    }
}
