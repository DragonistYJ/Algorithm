package interview;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName Solution32_3
 * @Author 11214
 * @Date 2020/4/12
 * @Description TODO
 */
public class Solution32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        int level = 0;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            level += 1;
            List<Integer> list = new ArrayList<>();
            ArrayDeque<TreeNode> temp = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                TreeNode treeNode = queue.pollFirst();
                list.add(treeNode.val);
                if (treeNode.left != null) temp.offer(treeNode.left);
                if (treeNode.right != null) temp.offer(treeNode.right);
            }
            if (level % 2 == 0) {
                int i = 0;
                int j = list.size() - 1;
                while (i < j) {
                    int k = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, k);
                    i += 1;
                    j -= 1;
                }
            }
            ans.add(list);
            queue.addAll(temp);
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;
        System.out.println(new Solution32_3().levelOrder(node1));
    }
}
