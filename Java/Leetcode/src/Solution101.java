import java.util.ArrayList;
import java.util.List;

/*
NO101 对称二叉树
给定一个二叉树，检查它是否是镜像对称的。
例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 */
public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        list.add(root);

        while (!list.isEmpty()) {
            List<TreeNode> tmp = new ArrayList<>(list);
            list.clear();
            int i = 0;
            int j = tmp.size() - 1;
            while (i < j) {
                if (tmp.get(i) == null && tmp.get(j) != null) return false;
                if (tmp.get(i) != null && tmp.get(j) == null) return false;
                if (tmp.get(i) == null && tmp.get(j) == null) {
                    i += 1;
                    j -= 1;
                    continue;
                }
                if (tmp.get(i).val != tmp.get(j).val) return false;
                i += 1;
                j -= 1;
            }
            for (TreeNode node : tmp) {
                if (node == null) continue;
                list.add(node.left);
                list.add(node.right);
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
