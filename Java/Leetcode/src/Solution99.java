import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
NO99 恢复二叉搜索树
二叉搜索树中的两个节点被错误地交换。
请在不改变其结构的情况下，恢复这棵树。
 */
public class Solution99 {
    public void recoverTree(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        getAll(root, values);
        values.sort(Comparator.comparingInt(o -> o));
        preOrder(root, values);
    }

    private void preOrder(TreeNode root, List<Integer> values) {
        if (root == null) return;

        preOrder(root.left, values);
        root.val = values.get(0);
        values.remove(0);
        preOrder(root.right, values);
    }

    private void getAll(TreeNode root, List<Integer> order) {
        if (root == null) return;

        getAll(root.left, order);
        order.add(root.val);
        getAll(root.right, order);
    }

    public static void main(String[] args) {

    }
}
