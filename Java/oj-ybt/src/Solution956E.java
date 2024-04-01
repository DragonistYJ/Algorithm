import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 11214
 * @since 2023/2/22 10:59
 */
public class Solution956E {
    private static class Node {
        private char c;
        private Node parent;
        private Node fail;
        private Node[] kids = new Node[26];
        private ArrayList<Integer> exists = new ArrayList<>();
    }

    private static Node root = new Node();

    public static void main(String[] args) {
        root.parent = root;
        root.fail = root;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            Node node = root;
            for (int j = 0; j < s.length(); j++) {
                int c = s.charAt(j) - 'a';
                if (node.kids[c] == null) {
                    node.kids[c] = new Node();
                    node.kids[c].c = s.charAt(j);
                }
                node.kids[c].parent = node;
                node = node.kids[c];
            }
            if (!node.exists.contains(s.length())) {
                node.exists.add(s.length());
            }
        }

        ArrayDeque<Node> deque = new ArrayDeque<>();
        for (Node kid : root.kids) {
            if (kid != null) {
                kid.fail = root;
                deque.offer(kid);
            }
        }
        while (!deque.isEmpty()) {
            Node parent = deque.poll();
            for (int i = 0; i < parent.kids.length; i++) {
                if (parent.kids[i] == null) {
                    continue;
                }
                Node node = parent.kids[i];
                Node fail = node.parent.fail;
                while (fail.kids[i] == null && fail != root) {
                    fail = fail.fail;
                }
                node.fail = fail.kids[i] == null ? fail : fail.kids[i];
                for (Integer exist : node.fail.exists) {
                    if (!node.exists.contains(exist)) {
                        node.exists.add(exist);
                    }
                }
                deque.offer(node);
            }
        }


        while (m-- > 0) {
            String s = sc.next();
            Node node = root;
            int ans = 0;
            for (int i = 0; i < s.length(); i++) {
                int c = s.charAt(i) - 'a';
                if (node.kids[c] != null) {
                    node = node.kids[c];
                    boolean flag = false;
                    if (node.exists.size() != 0) {
                        for (int exist : node.exists) {
                            if (ans + exist >= i) {
                                ans = i;
                                flag = true;
                                break;
                            }
                        }
                        if (!flag) {
                            break;
                        }
                    }
                } else if (node != root) {
                    node = node.fail;
                    i--;
                }
            }
            System.out.println(ans == 0 ? 0 : ans + 1);
        }
    }
}
