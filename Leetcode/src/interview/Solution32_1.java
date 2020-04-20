package interview;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName Solution32_1
 * @Author 11214
 * @Date 2020/4/12
 * @Description TODO
 */
public class Solution32_1 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            list.add(treeNode.val);
            if (treeNode.left != null) queue.offer(treeNode.left);
            if (treeNode.right != null) queue.offer(treeNode.right);
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
