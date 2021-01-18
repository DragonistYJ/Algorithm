from typing import List


class Solution:
    def count(self, board, x, y, m, n):
        dead = 0
        live = 0
        direction = [[-1, -1], [-1, 0], [-1, 1], [0, 1], [0, -1], [1, -1], [1, 0], [1, 1]]
        for i in range(8):
            xx = x + direction[i][0]
            yy = y + direction[i][1]
            if 0 <= xx < m and 0 <= yy < n:
                if board[xx][yy] == 0:
                    dead += 1
                else:
                    live += 1
        return dead, live

    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        根据百度百科，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
        给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
        如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
        如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
        如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
        如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
        下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。给你 m x n 网格面板 board 的当前状态，返回下一个状态。
        :param board: [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
        :return: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
        """
        m = len(board)
        n = len(board[0])
        matrix = []
        for i in range(m):
            row = []
            for j in range(n):
                row.append(board[i][j])
            matrix.append(row)
        for i in range(m):
            for j in range(n):
                dead, live = self.count(matrix, i, j, m, n)
                if matrix[i][j] == 1:
                    if live < 2 or live > 3:
                        board[i][j] = 0
                else:
                    if live == 3:
                        board[i][j] = 1


if __name__ == '__main__':
    solution = Solution()
    board = [[0, 1, 0], [0, 0, 1], [1, 1, 1], [0, 0, 0]]
    solution.gameOfLife(board)
    print(board)
