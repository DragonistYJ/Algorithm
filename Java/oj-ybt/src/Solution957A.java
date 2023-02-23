import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;

/**
 * @author 11214
 * @since 2023/2/23 9:33
 */
public class Solution957A {
    /**
     * 暴力搜索，能过
     */
    public static void method1() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            HashMap<String, Integer> candidates = new HashMap<>();
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String s = sc.next().toLowerCase();
                candidates.put(s, candidates.getOrDefault(s, 0) + 1);
            }

            int ans = 0;
            String document = sc.next().toLowerCase();
            for (Map.Entry<String, Integer> kv : candidates.entrySet()) {
                if (document.contains(kv.getKey())) {
                    ans += kv.getValue();
                }
            }
            System.out.println(ans);
        }
    }

    private static class Node {
        private Node father;
        private Node fail;
        private final Node[] kids = new Node[26];
        private final HashSet<Integer> exists = new HashSet<>();
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        st.nextToken();
        int t = (int) st.nval;
        while (t-- > 0) {
            HashMap<String, Integer> candidates = new HashMap<>();
            st.nextToken();
            int n = (int) st.nval;
            // 建树
            Node root = new Node();
            root.father = root;
            root.fail = root;
            for (int i = 0; i < n; i++) {
                st.nextToken();
                String s = st.sval;
                candidates.put(s, candidates.getOrDefault(s, 0) + 1);
                Node node = root;
                for (int j = 0; j < s.length(); j++) {
                    int c = s.charAt(j) - 'a';
                    if (node.kids[c] == null) {
                        node.kids[c] = new Node();
                    }
                    node.kids[c].father = node;
                    node = node.kids[c];
                }
                node.exists.add(s.length());
            }
            // fail指针
            ArrayDeque<Node> deque = new ArrayDeque<>();
            // 第一层（非root）的fail指向root
            for (Node kid : root.kids) {
                if (kid == null) {
                    continue;
                }
                kid.fail = root;
                deque.offer(kid);
            }
            while (!deque.isEmpty()) {
                Node father = deque.poll();
                for (int i = 0; i < father.kids.length; i++) {
                    Node node = father.kids[i];
                    if (node == null) {
                        continue;
                    }
                    Node fail = node.father.fail;
                    // 递归fail，找到第一个满足的
                    while (fail.kids[i] == null && fail != root) {
                        fail = fail.fail;
                    }
                    node.fail = fail.kids[i] == null ? fail : fail.kids[i];
                    node.exists.addAll(node.fail.exists);
                    deque.offer(node);
                }
            }

            int ans = 0;
            st.nextToken();
            String document = st.sval;
            HashSet<String> words = new HashSet<>();
            Node node = root;
            for (int i = 0; i < document.length(); i++) {
                int c = document.charAt(i) - 'a';
                if (node.kids[c] != null) {
                    node = node.kids[c];
                    for (Integer exist : node.exists) {
                        String substring = document.substring(i - exist + 1, i + 1);
                        if (!words.contains(substring)) {
                            words.add(substring);
                            ans += candidates.get(substring);
                        }
                    }
                } else if (node != root) {
                    node = node.fail;
                    i--;
                }
            }

            System.out.println(ans);
        }
    }
}
