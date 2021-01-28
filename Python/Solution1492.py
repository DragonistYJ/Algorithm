class Solution:
    def kthFactor(self, n: int, k: int) -> int:
        """
        给你两个正整数n 和k。
        如果正整数 i 满足 n % i == 0 ，那么我们就说正整数 i 是整数 n的因子。
        考虑整数 n的所有因子，将它们 升序排列。请你返回第 k个因子。如果 n的因子数少于k，请你返回 -1。
        :param n: 1000
        :param k: 3
        :return: 4
        """
        index = 0
        for i in range(1, n + 1):
            if n % i == 0:
                index += 1
            if index == k:
                return i
        return -1


if __name__ == '__main__':
    solution = Solution()
    print(solution.kthFactor(1000, 3))
