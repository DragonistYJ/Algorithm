import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName Solution327
 * @Author 11214
 * @Date 2020/4/16
 * @Description TODO
 */
public class Solution327 {
    private class Tree {
        private int l;
        private int r;
        private int sum;
        private Tree left;
        private Tree right;

        public Tree(int l, int r, int sum) {
            this.l = l;
            this.r = r;
            this.sum = sum;
        }
    }

    private Tree construct(int[] nums, int l, int r) {
        if (l == r) {
            return new Tree(l, r, nums[l]);
        }
        Tree tree = new Tree(l, r, 0);
        int mid = (l + r) / 2;
        Tree left = construct(nums, l, mid);
        Tree right = construct(nums, mid + 1, r);
        tree.sum = left.sum + right.sum;
        tree.left = left;
        tree.right = right;
        return tree;
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums.length == 0) return 0;
        Tree root = construct(nums, 0, nums.length - 1);
        int count = 0;
        Queue<Tree> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Tree tree = queue.poll();
            if (lower <= tree.sum && tree.sum <= upper) count += 1;
            if (tree.left != null) queue.offer(tree.left);
            if (tree.right != null) queue.offer(tree.right);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {0, -3, -3, 1, 1, 2};
        System.out.println(new Solution327().countRangeSum(nums, 3, 5));
    }
}
