from queue import PriorityQueue
from typing import List


class Point:
    def __init__(self, x: int, y: int, val: int):
        self.x = x
        self.y = y
        self.val = val

    def __lt__(self, other):
        return self.val < other.val


class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        """
        给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
        请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
        :param matrix: [[1,5,9],[10,11,13],[12,13,15]]
        :param k: 8
        :return: 13
        """
        n = len(matrix)
        queue = PriorityQueue()
        queue.put(Point(0, 0, matrix[0][0]))
        visited = [[False for _ in range(n)] for _ in range(n)]
        point = None
        while k != 0:
            k -= 1
            point = queue.get()
            xx = point.x + 1
            if xx < n and not visited[xx][point.y]:
                visited[xx][point.y] = True
                queue.put(Point(xx, point.y, matrix[xx][point.y]))
            yy = point.y + 1
            if yy < n and not visited[point.x][yy]:
                visited[point.x][yy] = True
                queue.put(Point(point.x, yy, matrix[point.x][yy]))
        return point.val


if __name__ == '__main__':
    solution = Solution()
    print(solution.kthSmallest([[1, 5, 9], [10, 11, 13], [12, 13, 15]], 9))
