import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;

/**
 * @author 11214
 * @since 2023/2/24 9:40
 */
public class Solution957C {
    private static class Node {
        private char c;
        private Node parent;
        private Node fail;
        private final Node[] kids = new Node[26];
        private int exist = 0;

        @Override
        public String toString() {
            return c + "";
        }

        public static void addWord(Node root, String s) {
            Node node = root;
            for (int i = 0; i < s.length(); i++) {
                int c = s.charAt(i) - 'a';
                if (node.kids[c] == null) {
                    node.kids[c] = new Node();
                    node.kids[c].c = s.charAt(i);
                }
                node.kids[c].parent = node;
                node = node.kids[c];
            }
            node.exist = s.length();
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

    public static void main(String[] args) throws IOException {
        Node root = new Node();
        root.parent = root;
        root.fail = root;

        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        st.nextToken();
        String target = st.sval;
        st.nextToken();
        int n = (int) st.nval;
        for (int i = 0; i < n; i++) {
            st.nextToken();
            Node.addWord(root, st.sval);
        }
        Node.makeFail(root);

        int idx = 0;
        Node node = root;
        int[] chars = new int[target.length()];
        Node[] caches = new Node[target.length()];
        int top = 0;
        while (idx < target.length()) {
            int c = target.charAt(idx) - 'a';
            if (node.kids[c] != null) {
                node = node.kids[c];
                chars[top] = c;
                caches[top] = node;
                top += 1;
                idx += 1;
                if (node.exist != 0) {
                    top -= node.exist;
                    node = top < 1 ? root : caches[top - 1];
                }
            } else {
                if (node == root) {
                    idx += 1;
                    chars[top] = c;
                    caches[top] = node;
                    top += 1;
                } else {
                    node = node.fail;
                }
            }
        }

        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        for (int i = 0; i < top; i++) {
            writer.write((char) (chars[i] + 'a'));
        }
        writer.write("\n");
        writer.flush();
        writer.close();
    }
}
