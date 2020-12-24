class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        """
        给出两个非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
        如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
        您可以假设除了数字 0 之外，这两个数都不会以 0开头。
        :param l1: 2 -> 4 -> 3
        :param l2: 5 -> 6 -> 4
        :return: 7 -> 0 -> 8
        """
        bit = 1
        n1 = 0
        while l1 is not None:
            n1 = n1 + l1.val * bit
            l1 = l1.next
            bit *= 10

        bit = 1
        n2 = 0
        while l2 is not None:
            n2 = n2 + l2.val * bit
            l2 = l2.next
            bit *= 10

        n3 = n1 + n2
        l3 = ListNode()
        head = l3
        while n3 != 0:
            node = ListNode(n3 % 10)
            head.next = node
            head = node
            n3 //= 10

        if head == l3:
            return ListNode()
        return l3.next


if __name__ == '__main__':
    node1 = ListNode(2)
    node1.next = ListNode(4)
    node1.next.next = ListNode(9)
    node2 = ListNode(5)
    node2.next = ListNode(6)
    node2.next.next = ListNode(4)
    node2.next.next.next = ListNode(9)

    solution = Solution()
    print(solution.addTwoNumbers(node1, node2))
