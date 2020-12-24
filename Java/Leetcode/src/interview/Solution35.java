package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName Solution35
 * @Author 11214
 * @Date 2020/4/11
 * @Description TODO
 */
public class Solution35 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        List<Node> list = new ArrayList<>();
        HashMap<Node, Node> hashMap = new HashMap<>();
        hashMap.put(null, null);
        Node temp = head;
        while (temp != null) {
            hashMap.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            hashMap.get(temp).next = hashMap.get(temp.next);
            hashMap.get(temp).random = hashMap.get(temp.random);
            temp = temp.next;
        }
        return hashMap.get(head);
    }
}
