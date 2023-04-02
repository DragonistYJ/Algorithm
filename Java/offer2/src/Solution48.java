import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 11214
 * @since 2023/4/2 10:10
 */
public class Solution48 {
    public class Codec {
        class Entry {
            int val;
            int left;
            int right;

            public Entry(int val) {
                this.val = val;
            }
        }

        private List<Entry> dfsSerialize(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<Entry> left = dfsSerialize(root.left);
            List<Entry> right = dfsSerialize(root.right);
            Entry entry = new Entry(root.val);
            if (left.size() > 0) {
                Entry e = left.get(0);
                entry.left = e.left + e.right + 1;
            }
            if (right.size() > 0) {
                Entry e = right.get(0);
                entry.right = e.left + e.right + 1;
            }
            ArrayList<Entry> res = new ArrayList<>();
            res.add(entry);
            res.addAll(left);
            res.addAll(right);
            return res;
        }

        public String serialize(TreeNode root) {
            List<Entry> entries = dfsSerialize(root);
            StringBuilder sb = new StringBuilder();
            for (Entry entry : entries) {
                sb.append(entry.val);
                sb.append(',');
                sb.append(entry.left);
                sb.append(',');
                sb.append(entry.right);
                sb.append(";");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        }


        private TreeNode dfsDeserialize(List<String> list) {
            String token = list.get(0);
            String[] split = token.split(",");
            TreeNode node = new TreeNode();
            node.val = Integer.parseInt(split[0]);
            int leftNum = Integer.parseInt(split[1]);
            if (leftNum != 0) {
                node.left = dfsDeserialize(list.subList(1, 1 + leftNum));
            }
            int rightNum = Integer.parseInt(split[2]);
            if (rightNum != 0) {
                node.right = dfsDeserialize(list.subList(1 + leftNum, 1 + leftNum + rightNum));
            }
            return node;
        }

        public TreeNode deserialize(String data) {
            if (data.length() == 0) {
                return null;
            }
            String[] split = data.split(";");
            List<String> list = new ArrayList<>();
            Collections.addAll(list, split);
            return dfsDeserialize(list);
        }
    }
}
