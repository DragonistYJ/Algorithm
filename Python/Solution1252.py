from typing import List


class Solution:
    def oddCells(self, n: int, m: int, indices: List[List[int]]) -> int:
        """
        给你一个n行m列的矩阵，最开始的时候，每个单元格中的值都是 0。
        另有一个索引数组indices，indices[i] = [ri, ci]中的ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
        你需要将每对[ri, ci]指定的行和列上的所有单元格的值加 1。
        请你在执行完所有indices指定的增量操作后，返回矩阵中 「奇数值单元格」 的数目。
        :param n: 2
        :param m: 3
        :param indices: [[0,1],[1,1]]
        :return: 6
        """
        matrix = [[0] * m for _ in range(n)]
        for index in indices:
            row = index[0]
            col = index[1]
            for i in range(m):
                matrix[row][i] += 1
            for i in range(n):
                matrix[i][col] += 1
        ans = 0
        for i in range(n):
            for j in range(m):
                if matrix[i][j] % 2 == 1:
                    ans += 1
        return ans


if __name__ == '__main__':
    solution = Solution()
    print(solution.oddCells(2, 3, [[0, 1], [1, 1]]))
