class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def findBottomLeftValue(self, root: TreeNode) -> int:
        """
        给定一个二叉树，在树的最后一行找到最左边的值。
        :param root: [2,1,3]
        :return: 1
        """
        level = [root]
        while True:
            next_level = []
            for node in level:
                if node.left is not None:
                    next_level.append(node.left)
                if node.right is not None:
                    next_level.append(node.right)
            if len(next_level) == 0:
                return level[0].val
            else:
                level = next_level
