import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName Solution894
 * @Author 11214
 * @Date 2020/4/21
 * @Description TODO
 */
public class Solution894 {
    private HashMap<Integer, List<TreeNode>> hashMap = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int N) {
        if (!hashMap.containsKey(N)) {
            List<TreeNode> list = new ArrayList<>();
            if (N == 1) {
                list.add(new TreeNode(0));
            } else if (N % 2 == 1) {
                for (int i = 0; i < N; i++) {
                    int j = N - i - 1;
                    for (TreeNode left : allPossibleFBT(i)) {
                        for (TreeNode right : allPossibleFBT(j)) {
                            TreeNode node = new TreeNode(0);
                            node.left = left;
                            node.right = right;
                            list.add(node);
                        }
                    }
                }
            }
            hashMap.put(N, list);
        }

        return hashMap.get(N);
    }

    public static void main(String[] args) {
        List<TreeNode> treeNodes = new Solution894().allPossibleFBT(7);
        for (TreeNode treeNode : treeNodes) {
            System.out.println(treeNode);
        }
    }
}
