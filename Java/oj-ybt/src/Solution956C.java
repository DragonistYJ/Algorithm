import java.util.Scanner;

/**
 * @author 11214
 * @since 2023/2/22 9:58
 */
public class Solution956C {
    private static class Node {
        private final Node[] nodes = new Node[2];
    }

    private static Node root = new Node();

    private static void addNum(int num) {
        Node point = root;
        for (int i = 30; i >= 0; i--) {
            int k = (num >> i) & 1;
            if (point.nodes[k] == null) {
                point.nodes[k] = new Node();
            }
            point = point.nodes[k];
        }
    }

    private static int find(int num) {
        Node point = root;
        int res = 0;
        for (int i = 30; i >= 0; i--) {
            int k = (num >> i) & 1;
            int aim = 1 - k;
            if (point.nodes[aim] != null) {
                point = point.nodes[aim];
                res += 1 << i;
            } else {
                point = point.nodes[k];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int sum = nums[0];
        int[] lMax = new int[n];
        lMax[0] = sum;
        for (int i = 1; i < n; i++) {
            sum = sum ^ nums[i];
            addNum(nums[i]);
            lMax[i] = Math.max(Math.max(lMax[i - 1], find(sum)), sum);
        }

        root = new Node();
        sum = nums[n - 1];
        int[] rMax = new int[n];
        rMax[n - 1] = sum;
        for (int i = n - 2; i >= 0; i--) {
            sum = sum ^ nums[i];
            addNum(nums[i]);
            rMax[i] = Math.max(Math.max(rMax[i + 1], find(sum)), sum);
        }

        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, lMax[i] + rMax[i + 1]);
        }
        System.out.println(ans);
    }
}
