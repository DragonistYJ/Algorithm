import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution559 {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int ans = 1;
        List<Pair<Node, Integer>> list = new LinkedList<>();
        list.add(new Pair<>(root, 1));

        while (!list.isEmpty()) {
            Pair<Node, Integer> pair = list.get(0);
            list.remove(0);
            Node node = pair.getKey();
            int deep = pair.getValue();
            ans = Math.max(deep, ans);
            for (Node child : node.children) {
                list.add(new Pair<>(child, deep + 1));
            }
        }

        return ans;
    }
}
