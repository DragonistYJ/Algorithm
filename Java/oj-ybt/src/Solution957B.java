import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * @author 11214
 * @since 2023/2/24 11:43
 */
public class Solution957B {
    private static class Node {
        private char c;
        private Node parent;
        private Node fail;
        private final Node[] kids = new Node[4];
        private int deep;
        private boolean visited = false;

        @Override
        public String toString() {
            return c + "";
        }

        public static int charVal(char c) {
            if (c == 'E') {
                return 0;
            } else if (c == 'S') {
                return 1;
            } else if (c == 'W') {
                return 2;
            } else {
                return 3;
            }
        }

        public static Node addWord(Node root, String s) {
            Node node = root;
            for (int i = 0; i < s.length(); i++) {
                int c = Node.charVal(s.charAt(i));
                if (node.kids[c] == null) {
                    node.kids[c] = new Node();
                    node.kids[c].c = s.charAt(i);
                    node.kids[c].deep = i + 1;
                }
                node.kids[c].parent = node;
                node = node.kids[c];
            }
            return node;
        }

        public static void makeFail(Node root) {
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
                    Node node = parent.kids[i];
                    if (node == null) {
                        continue;
                    }
                    Node fail = node.parent.fail;
                    while (fail.kids[i] == null && fail != root) {
                        fail = fail.fail;
                    }
                    node.fail = fail.kids[i] == null ? fail : fail.kids[i];
                    deque.offer(node);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String target = sc.next();
        Node root = new Node();
        root.fail = root;
        root.parent = root;
        root.visited = true;
        Node[] lastPositions = new Node[m];
        for (int i = 0; i < m; i++) {
            lastPositions[i] = Node.addWord(root, sc.next());
        }
        Node.makeFail(root);

        // 标记节点可达
        Node node = root;
        int i = 0;
        while (i < target.length()) {
            int c = Node.charVal(target.charAt(i));
            if (node.kids[c] != null) {
                node = node.kids[c];
                Node t = node;
                // 如果该节点可达，则它的所有fail可达
                while (t != root) {
                    t.visited = true;
                    t = t.fail;
                }
                i += 1;
            } else {
                if (node == root) {
                    i += 1;
                } else {
                    node = node.fail;
                }
            }
        }

        for (Node lastPosition : lastPositions) {
            while (!lastPosition.visited) {
                lastPosition = lastPosition.parent;
            }
            System.out.println(lastPosition.deep);
        }
    }
}
