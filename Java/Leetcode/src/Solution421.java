/**
 * @author yujian
 * @since 2023/7/20 10:58
 */
public class Solution421 {
    static class Node {
        Node[] kids = new Node[2];
    }

    private String to31BitString(int num) {
        String binary = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();
        for (int i = binary.length(); i < 31; i++) {
            sb.append("0");
        }
        sb.append(binary);
        return sb.toString();
    }

    public int findMaximumXOR(int[] nums) {
        int n = nums.length;
        Node root = new Node();
        String[] binaries = new String[n];
        for (int i = 0; i < n; i++) {
            binaries[i] = to31BitString(nums[i]);
        }
        for (int i = 0; i < n; i++) {
            Node curr = root;
            for (int j = 0; j < 31; j++) {
                int k = binaries[i].charAt(j) - '0';
                if (curr.kids[k] == null) {
                    curr.kids[k] = new Node();
                }
                curr = curr.kids[k];
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            Node curr = root;
            int sum = 0;
            for (int j = 0; j < 31; j++) {
                int k = binaries[i].charAt(j) - '0';
                int t = 1 - k;
                if (curr.kids[t] != null) {
                    sum = sum | (1 << (30 - j));
                    curr = curr.kids[t];
                } else {
                    curr = curr.kids[k];
                }
            }
            ans = Math.max(ans, sum);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution421 solution = new Solution421();
        System.out.println(solution.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
    }
}
