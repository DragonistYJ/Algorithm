class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def __init__(self):
        self.step = 0

    def kthSmallest(self, root: TreeNode, k: int) -> int:
        """
        给定一个二叉搜索树，编写一个函数kthSmallest来查找其中第k个最小的元素。
        说明：你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
        :param root: [5,3,6,2,4,null,null,1]
        :param k: 3
        :return: 3
        """
        ans = 0
        if root.left is not None and self.step < k:
            ans = self.kthSmallest(root.left, k)

        if self.step < k:
            self.step += 1
            ans = root.val

        if root.right is not None and self.step < k:
            ans = self.kthSmallest(root.right, k)

        return ans


if __name__ == '__main__':
    solution = Solution()
    root = TreeNode(1)
    root.right = TreeNode(2)
    print(solution.kthSmallest(root, 2))
