import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution707
 * @Author 11214
 * @Date 2020/6/26
 * @Description 设计链表
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 * 在链表类中实现这些功能：
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第index个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 */
public class Solution707 {
    private static class MyLinkedList {
        private final List<Integer> list;

        public MyLinkedList() {
            list = new ArrayList<>();
        }

        public int get(int index) {
            if (index < 0 || index >= list.size()) return -1;
            return list.get(index);
        }

        public void addAtHead(int val) {
            list.add(0, val);
        }

        public void addAtTail(int val) {
            list.add(val);
        }

        public void addAtIndex(int index, int val) {
            if (index < 0) list.add(0, val);
            else if (index <= list.size()) list.add(index, val);
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= list.size()) return;
            list.remove(index);
        }
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(2);
        list.addAtIndex(1, 1);
    }
}
