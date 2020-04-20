import java.util.ArrayList;
import java.util.List;

/*
NO1302 层数最深叶子节点的和
给你一棵二叉树，请你返回层数最深的叶子节点的和
 */
public class Solution1302 {
    public int deepestLeavesSum(TreeNode root) {
        List<TreeNode> nextLayer = new ArrayList<>();
        nextLayer.add(root);
        boolean flag = true;
        while (flag) {
            flag = false;
            List<TreeNode> tmp = new ArrayList<>(nextLayer);
            nextLayer.clear();
            for (TreeNode node : tmp) {
                if (node.left != null) {
                    nextLayer.add(node.left);
                    flag = true;
                }
                if (node.right != null) {
                    nextLayer.add(node.right);
                    flag = true;
                }
            }
            if (!flag) {
                nextLayer.addAll(tmp);
            }
        }
        int sum = 0;
        for (TreeNode node : nextLayer) {
            sum += node.val;
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
