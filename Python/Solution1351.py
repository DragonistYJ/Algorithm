from typing import List


class Solution:
    def countNegatives(self, grid: List[List[int]]) -> int:
        """
        给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。
        请你统计并返回 grid 中 负数 的数目。
        :param grid: [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
        :return: 8
        """
        n = len(grid[0])
        ans = 0
        for row in grid:
            for index, number in enumerate(row):
                if number < 0:
                    ans += n - index
                    break
        return ans


if __name__ == '__main__':
    solution = Solution()
    print(solution.countNegatives([[4, 3, 2, -1], [3, 2, 1, -1], [1, 1, -1, -2], [-1, -1, -2, -3]]))
