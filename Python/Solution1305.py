from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def walk_through(self, root: TreeNode) -> List[int]:
        if root is None:
            return []
        left = []
        if root.left is not None:
            left = self.walk_through(root.left)
        right = []
        if root.right is not None:
            right = self.walk_through(root.right)
        return left + [root.val] + right

    def getAllElements(self, root1: TreeNode, root2: TreeNode) -> List[int]:
        """
        给你 root1 和 root2 这两棵二叉搜索树。
        请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
        :param root1: [2,1,4]
        :param root2: [1,0,3]
        :return: [0,1,1,2,3,4]
        """
        list1 = self.walk_through(root1)
        list2 = self.walk_through(root2)
        ans = []
        i = 0
        j = 0
        while i < len(list1) and j < len(list2):
            if list1[i] < list2[j]:
                ans.append(list1[i])
                i += 1
            else:
                ans.append(list2[j])
                j += 1
        while i < len(list1):
            ans.append(list1[i])
            i += 1
        while j < len(list2):
            ans.append(list2[j])
            j += 1
        return ans


if __name__ == '__main__':
    solution = Solution()
    root1 = TreeNode(2)
    root1.left = TreeNode(1)
    root1.right = TreeNode(4)
    root2 = TreeNode(1)
    root2.left = TreeNode(0)
    root2.right = TreeNode(3)
    print(solution.getAllElements(root1, root2))
