from typing import List


class Solution:
    def __init__(self):
        self.direction = [[0, 1], [0, -1], [1, 0], [-1, 0]]

    def to_zero(self, x: int, y: int, grid: List[List[int]]) -> int:
        grid[x][y] = 0
        ans = 1
        for i in range(4):
            xx = x + self.direction[i][0]
            yy = y + self.direction[i][1]
            if 0 <= xx < len(grid) and 0 <= yy < len(grid[0]) and grid[xx][yy] == 1:
                ans += self.to_zero(xx, yy, grid)
        return ans

    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        """
        给定一个包含了一些 0 和 1 的非空二维数组grid 。
        一个岛屿是由一些相邻的1(代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。
        你可以假设grid的四个边缘都被 0（代表水）包围着。
        找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
        :param grid: [[0,0,0,0,0,0,0,0]]
        :return: 0
        """
        ans = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    ans = max(ans, self.to_zero(i, j, grid))
        return ans


if __name__ == '__main__':
    solution = Solution()
    print(solution.maxAreaOfIsland([[0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0],
                                    [0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0],
                                    [0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0],
                                    [0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0],
                                    [0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0],
                                    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0],
                                    [0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0],
                                    [0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0]]))
