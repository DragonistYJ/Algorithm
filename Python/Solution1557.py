from typing import List


class Solution:
    def findSmallestSetOfVertices(self, n: int, edges: List[List[int]]) -> List[int]:
        """
        给你一个 有向无环图， n个节点编号为 0到 n-1，以及一个边数组 edges，其中 edges[i] = [fromi, toi]表示一条从点fromi到点toi的有向边。
        找到最小的点集使得从这些点出发能到达图中所有点。题目保证解存在且唯一。
        你可以以任意顺序返回这些节点编号。
        :param n: 6
        :param edges: [[0,1],[0,2],[2,5],[3,4],[4,2]]
        :return: [0,3]
        """
        in_degree = [0 for _ in range(n)]
        for edge in edges:
            in_degree[edge[1]] += 1
        ans = []
        for point in range(n):
            if in_degree[point] == 0:
                ans.append(point)
        return ans


if __name__ == '__main__':
    solution = Solution()
    print(solution.findSmallestSetOfVertices(6, [[0, 1], [0, 2], [2, 5], [3, 4], [4, 2]]))
