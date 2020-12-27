class Solution:
    def trailingZeroes(self, n: int) -> int:
        """
        给定一个整数 n，返回 n! 结果尾数中零的数量。
        3! = 6, 尾数中没有零。
        :param n: 3
        :return: 0
        """
        two = 0
        five = 0
        for i in range(2, n + 1):
            k = i
            while k % 2 == 0:
                two += 1
                k /= 2
            while k % 5 == 0:
                five += 1
                k /= 5
        return min(two, five)


if __name__ == '__main__':
    solution = Solution()
    print(solution.trailingZeroes(5))
