from typing import List


class Solution:
    def maxCoins(self, piles: List[int]) -> int:
        """
        有 3n 堆数目不一的硬币，你和你的朋友们打算按以下方式分硬币：
        每一轮中，你将会选出 任意 3 堆硬币（不一定连续）。
        Alice 将会取走硬币数量最多的那一堆。
        你将会取走硬币数量第二多的那一堆。
        Bob 将会取走最后一堆。
        重复这个过程，直到没有更多硬币。
        给你一个整数数组 piles ，其中 piles[i] 是第 i 堆中硬币的数目。
        返回你可以获得的最大硬币数目。
        :param piles: [2,4,1,2,7,8]
        :return: 9
        """
        piles.sort()
        n = len(piles)
        index = n - 2
        ans = 0
        for i in range(n // 3):
            ans += piles[index]
            index -= 2
        return ans


if __name__ == '__main__':
    solution = Solution()
    print(solution.maxCoins([2, 4, 1, 2, 7, 8]))
