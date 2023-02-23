import java.util.*;

/**
 * @author 11214
 * @since 2023/2/23 16:34
 */
public class Solution957D {
    private static class Node {
        private Node parent;
        private Node fail;
        private final Node[] kids = new Node[26];
        private final List<Integer> exists = new ArrayList<>();
    }

    private static final Node root = new Node();

    public static void main(String[] args) {
        root.fail = root;
        root.parent = root;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> words = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            words.add(sc.next());
        }

        for (String word : words) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                if (node.kids[c] == null) {
                    node.kids[c] = new Node();
                }
                node.kids[c].parent = node;
                node = node.kids[c];
            }
            if (!node.exists.contains(word.length())) {
                node.exists.add(word.length());
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
                Node kid = parent.kids[i];
                if (kid == null) {
                    continue;
                }
                Node fail = kid.parent.fail;
                while (fail.kids[i] == null && fail != root) {
                    fail = fail.fail;
                }
                kid.fail = fail.kids[i] == null ? root : fail.kids[i];
                for (Integer exist : kid.fail.exists) {
                    if (!kid.exists.contains(exist)) {
                        kid.exists.add(exist);
                    }
                }
                deque.offer(kid);
            }
        }

        HashMap<String, Integer> ans = new HashMap<>();
        for (String word : words) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                if (node.kids[c] != null) {
                    node = node.kids[c];
                    for (int exist : node.exists) {
                        String substring = word.substring(i - exist + 1, i + 1);
                        ans.put(substring, ans.getOrDefault(substring, 0) + 1);
                    }
                } else if (node != root) {
                    node = node.fail;
                    i--;
                }
            }
        }
        for (String word : words) {
            System.out.println(ans.get(word));
        }
    }
}
