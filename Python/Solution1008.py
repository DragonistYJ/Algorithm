from typing import List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def bstFromPreorder(self, preorder: List[int]) -> TreeNode:
        """
        返回与给定前序遍历preorder 相匹配的二叉搜索树（binary search tree）的根结点。
        (回想一下，二叉搜索树是二叉树的一种，其每个节点都满足以下规则，对于node.left的任何后代，值总<node.val，而node.right的任何后代，值总>node.val。
        此外，前序遍历首先显示节点node的值，然后遍历node.left，接着遍历node.right。）
        题目保证，对于给定的测试用例，总能找到满足要求的二叉搜索树。
        :param preorder: [8,5,1,7,10,12]
        :return: [8,5,10,1,7,null,12]
        """
        root = TreeNode(preorder[0])
        index = 1
        while index < len(preorder) and preorder[index] < preorder[0]:
            index += 1
        if index > 1:
            root.left = self.bstFromPreorder(preorder[1:index])
        if index < len(preorder):
            root.right = self.bstFromPreorder(preorder[index:len(preorder)])
        return root
