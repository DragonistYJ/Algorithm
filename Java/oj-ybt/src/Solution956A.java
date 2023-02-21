import java.io.IOException;
import java.util.Scanner;

/**
 * @author 11214
 * @since 2023/2/21 11:01
 */
public class Solution956A {
    private static class Node {
        private boolean isEnd = false;
        private final Node[] children = new Node[10];
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            sc.nextLine();
            Node root = new Node();
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                String s = sc.nextLine();
                if (flag) {
                    continue;
                }

                Node node = root;
                for (int j = 0; j < s.length(); j++) {
                    int c = s.charAt(j) - '0';
                    if (node.isEnd || (j == s.length() - 1 && node.children[c] != null)) {
                        flag = true;
                        break;
                    }

                    if (node.children[c] == null) {
                        node.children[c] = new Node();
                    }
                    node = node.children[c];
                    if (j == s.length() - 1) {
                        node.isEnd = true;
                    }
                }

                if (flag) {
                    System.out.println("NO");
                }
            }

            if (!flag) {
                System.out.println("YES");
            }
        }
    }
}
