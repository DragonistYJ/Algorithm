/**
 * @author yujian
 * @since 2022/9/10 10:46
 * 给定一个单链表的头节点head，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差不超过 1。
 */
public class Solution109 {
    private TreeNode construct(ListNode head, int n) {
        if (n == 0) {
            return null;
        }
        if (n == 1) {
            return new TreeNode(head.val);
        }

        ListNode temp = head;
        int k = n / 2;
        for (int i = 0; i <= k - 1; i++) {
            temp = temp.next;
        }
        TreeNode left = construct(head, k);
        TreeNode right = construct(temp.next, n - k - 1);
        TreeNode root = new TreeNode(temp.val);
        root.left = left;
        root.right = right;
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            n += 1;
        }
        return construct(head, n);
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(-10);
        ListNode node2 = new ListNode(-3);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(new Solution109().sortedListToBST(node1));
    }
}
