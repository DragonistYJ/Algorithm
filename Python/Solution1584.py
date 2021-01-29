from typing import List


class IntersectionUnion:
    def __init__(self, n):
        self.roots = [i for i in range(n)]

    def find(self, x):
        if self.roots[x] == x:
            return x
        else:
            self.roots[x] = self.find(self.roots[x])
            return self.roots[x]

    def union(self, x, y):
        self.roots[self.find(y)] = self.find(x)

    def is_together(self, x, y):
        if self.find(x) == self.find(y):
            return True
        else:
            return False


class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        """
        给你一个points数组，表示 2D 平面上的一些点，其中points[i] = [xi, yi]。
        连接点[xi, yi] 和点[xj, yj]的费用为它们之间的 曼哈顿距离：|xi - xj| + |yi - yj|，其中|val|表示val的绝对值。
        请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有一条简单路径时，才认为所有点都已连接。
        :param points: [[0,0],[2,2],[3,10],[5,2],[7,0]]
        :return: 20
        """
        graph = []
        for i in range(len(points)):
            for j in range(i + 1, len(points)):
                graph.append((abs(points[i][0] - points[j][0]) + abs(points[i][1] - points[j][1]), i, j))
        graph.sort()

        iu = IntersectionUnion(len(points))
        ans = 0
        num = 0
        for dist, i, j in graph:
            if num == len(points) - 1:
                break
            if not iu.is_together(i, j):
                num += 1
                ans += dist
                iu.union(i, j)
        return ans


if __name__ == '__main__':
    solution = Solution()
    print(solution.minCostConnectPoints(
        [[15, 14], [-7, -1], [-19, 16], [5, -6], [-14, 18], [-10, 0], [17, -1], [-4, 4], [-15, 14], [15, -8]]))
