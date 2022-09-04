import java.util.*;
import java.util.AbstractMap.SimpleEntry;

public class Solution559 {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int ans = 1;
        List<SimpleEntry<Node, Integer>> list = new LinkedList<>();
        list.add(new SimpleEntry<>(root, 1));

        while (!list.isEmpty()) {
            SimpleEntry<Node, Integer> pair = list.get(0);
            list.remove(0);
            Node node = pair.getKey();
            int deep = pair.getValue();
            ans = Math.max(deep, ans);
            for (Node child : node.children) {
                list.add(new SimpleEntry<>(child, deep + 1));
            }
        }

        return ans;
    }
}
