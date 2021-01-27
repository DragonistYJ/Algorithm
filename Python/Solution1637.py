from typing import List


class Solution:
    def maxWidthOfVerticalArea(self, points: List[List[int]]) -> int:
        """
        给你n个二维平面上的点 points ，其中points[i] = [xi, yi]，请你返回两点之间内部不包含任何点的最宽垂直面积的宽度。
        垂直面积的定义是固定宽度，而 y 轴上无限延伸的一块区域（也就是高度为无穷大）。 最宽垂直面积为宽度最大的一个垂直面积。
        请注意，垂直区域边上的点不在区域内。
        :param points: [[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]
        :return: 3
        """
        x = []
        for point in points:
            x.append(point[0])
        x.sort()
        gap = 0
        for i in range(len(x) - 1):
            gap = max(gap, x[i] - x[i - 1])
        return gap


if __name__ == '__main__':
    solution = Solution()
    print(solution.maxWidthOfVerticalArea([[3, 1], [9, 0], [1, 0], [1, 4], [5, 3], [8, 8]]))
