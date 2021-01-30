class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def maxLevelSum(self, root: TreeNode) -> int:
        """
        给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
        请你找出层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
        :param root: [1,7,0,7,-8,null,null]
        :return: 2
        """
        ans = 1
        index = 1
        max_val = root.val
        roots = [root]
        while len(roots) != 0:
            nexts = []
            s = 0
            for node in roots:
                s += node.val
                if node.left is not None:
                    nexts.append(node.left)
                if node.right is not None:
                    nexts.append(node.right)
            if s > max_val:
                ans = index
                max_val = s
            roots = nexts
            index += 1
        return ans
