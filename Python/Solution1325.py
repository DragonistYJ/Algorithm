class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def removeLeafNodes(self, root: TreeNode, target: int) -> TreeNode:
        """
        给你一棵以root为根的二叉树和一个整数target，请你删除所有值为target的叶子节点 。
        注意，一旦删除值为target的叶子节点，它的父节点就可能变成叶子节点；如果新叶子节点的值恰好也是target，那么这个节点也应该被删除。
        也就是说，你需要重复此过程直到不能继续删除。
        :param root: [1,2,3,2,null,2,4]
        :param target: 2
        :return: [1,null,3,null,4]
        """
        if root.left is not None:
            root.left = self.removeLeafNodes(root.left, target)
        if root.right is not None:
            root.right = self.removeLeafNodes(root.right, target)
        if root.left is None and root.right is None and root.val == target:
            return None
        else:
            return root
