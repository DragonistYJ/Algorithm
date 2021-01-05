class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def mergeInBetween(self, list1: ListNode, a: int, b: int, list2: ListNode) -> ListNode:
        """
        给你两个链表list1 和list2，它们包含的元素分别为n 个和m个。
        请你将list1中第a个节点到第b个节点删除，并将list2接在被删除节点的位置。
        :param list1: [0,1,2,3,4,5]
        :param a: 3
        :param b: 4
        :param list2: [1000000,1000001,1000002]
        :return: [0,1,2,1000000,1000001,1000002,5]
        """
        index = list1
        for i in range(a - 1):
            index = index.next
        begin = index
        for i in range(a, b + 1):
            index = index.next
        end = index.next
        index = list2
        while index.next is not None:
            index = index.next
        begin.next = list2
        index.next = end
        return list1


if __name__ == '__main__':
    solution = Solution()
