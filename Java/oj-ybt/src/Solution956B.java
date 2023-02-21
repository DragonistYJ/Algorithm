import java.util.Scanner;

/**
 * @author 11214
 * @since 2023/2/21 11:53
 */
public class Solution956B {
    private static class Node {
        private final Node[] nodes = new Node[2];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Node root = new Node();
        for (int num : nums) {
            Node temp = root;
            for (int i = 30; i >= 0; i--) {
                int k = (num >> i) & 1;
                if (temp.nodes[k] == null) {
                    temp.nodes[k] = new Node();
                }
                temp = temp.nodes[k];
            }
        }

        int ans = 0;
        for (int num : nums) {
            Node temp = root;
            int res = 0;
            for (int i = 30; i >= 0; i--) {
                int k = (num >> i) & 1;
                int aim = 1 - k;
                if (temp.nodes[aim] == null) {
                    temp = temp.nodes[1 - aim];
                } else {
                    res = res + (1 << i);
                    temp = temp.nodes[aim];
                }
            }
            ans = Math.max(ans, res);
        }

        System.out.println(ans);
    }
}
