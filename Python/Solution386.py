from typing import List


class Solution:
    def go_deep(self, base: int, n: int, ans: List[int]):
        for i in range(10):
            x = base * 10 + i
            if x <= n:
                ans.append(x)
                self.go_deep(x, n, ans)

    def lexicalOrder(self, n: int) -> List[int]:
        """
        给定一个整数n, 返回从1到n的字典顺序。
        例如，给定 n =13，返回[1,10,11,12,13,2,3,4,5,6,7,8,9]。
        请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据n小于等于5,000,000。
        :param n: 13
        :return: [1,10,11,12,13,2,3,4,5,6,7,8,9]
        """
        ans = []
        for i in range(1, 10):
            if i <= n:
                ans.append(i)
                self.go_deep(i, n, ans)
        return ans


if __name__ == '__main__':
    solution = Solution()
    print(solution.lexicalOrder(13))
