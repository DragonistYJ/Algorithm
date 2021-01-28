class Solution:
    def minOperations(self, n: int) -> int:
        """
        存在一个长度为 n 的数组 arr ，其中 arr[i] = (2 * i) + 1 （ 0 <= i < n ）。
        一次操作中，你可以选出两个下标，记作 x 和 y （ 0 <= x, y < n ）并使 arr[x] 减去 1 、arr[y] 加上 1 （即 arr[x] -=1 且 arr[y] += 1 ）。
        最终的目标是使数组中的所有元素都 相等 。题目测试用例将会 保证 ：在执行若干步操作后，数组中的所有元素最终可以全部相等。
        给你一个整数 n，即数组的长度。请你返回使数组 arr 中所有元素相等所需的 最小操作数 。
        :param n: 6
        :return: 9
        """
        ans = 0
        for i in range(n // 2):
            ans += n - (i * 2 + 1)
        return ans


if __name__ == '__main__':
    solution = Solution()
    print(solution.minOperations(3))
