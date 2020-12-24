import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName Solution1145
 * @Author 11214
 * @Date 2020/6/6
 * @Description 二叉树着色游戏
 * 有两位极客玩家参与了一场「二叉树着色」的游戏。游戏中，给出二叉树的根节点 root，树上总共有 n 个节点，且 n 为奇数，其中每个节点上的值从 1 到 n 各不相同。
 * 游戏从「一号」玩家开始（「一号」玩家为红色，「二号」玩家为蓝色），最开始时，
 * 「一号」玩家从 [1, n] 中取一个值 x（1 <= x <= n）；
 * 「二号」玩家也从 [1, n] 中取一个值 y（1 <= y <= n）且 y != x。
 * 「一号」玩家给值为 x 的节点染上红色，而「二号」玩家给值为 y 的节点染上蓝色。
 * 之后两位玩家轮流进行操作，每一回合，玩家选择一个他之前涂好颜色的节点，将所选节点一个 未着色 的邻节点（即左右子节点、或父节点）进行染色。
 * 如果当前玩家无法找到这样的节点来染色时，他的回合就会被跳过。
 * 若两个玩家都没有可以染色的节点时，游戏结束。着色节点最多的那位玩家获得胜利 ✌️。
 * 现在，假设你是「二号」玩家，根据所给出的输入，假如存在一个 y 值可以确保你赢得这场游戏，则返回 true；若无法获胜，就请返回 false。
 */
public class Solution1145 {
    private int countNodes(TreeNode root) {
        if (root == null) return 0;
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left + right + 1;
    }

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        TreeNode first = null;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.val == x) {
                first = poll;
                break;
            }
            if (poll.left != null) queue.offer(poll.left);
            if (poll.right != null) queue.offer(poll.right);
        }

        assert first != null;
        int left = countNodes(first.left);
        int right = countNodes(first.right);
        int other = n - left - right - 1;
        return (left > n - left) || (right > n - right) || (other > n - other);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        treeNode4.left = treeNode8;
        treeNode4.right = treeNode9;
        TreeNode treeNode10 = new TreeNode(10);
        TreeNode treeNode11 = new TreeNode(11);
        treeNode5.left = treeNode10;
        treeNode5.right = treeNode11;
        System.out.println(new Solution1145().btreeGameWinningMove(treeNode1, 11, 3));
    }
}
