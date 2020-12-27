class Solution:
    def countPrimes(self, n: int) -> int:
        """
        统计所有小于非负整数 n 的质数的数量，小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7
        :param n: 10
        :return: 4
        """
        if n < 3:
            return 0
        if n == 3:
            return 1
        ans = 0
        numbers = [True] * n
        for i in range(2, n):
            if numbers[i]:
                ans += 1
            for j in range(i + i, n, i):
                numbers[j] = False
        return ans


if __name__ == '__main__':
    solution = Solution()
    print(solution.countPrimes(10))
