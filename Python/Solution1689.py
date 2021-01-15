class Solution:
    def minPartitions(self, n: str) -> int:
        """
        如果一个十进制数字不含任何前导零，且每一位上的数字不是 0 就是 1 ，那么该数字就是一个 十-二进制数。
        例如，101 和 1100 都是 十-二进制数，而 112 和 3001 不是。
        给你一个表示十进制整数的字符串 n ，返回和为 n 的 十-二进制数 的最少数目。
        :param n: 32
        :return: 3
        """
        ans = 0
        for c in n:
            ans = max(ans, int(c))
        return ans


if __name__ == '__main__':
    solution = Solution()
    print(solution.minPartitions("32"))
