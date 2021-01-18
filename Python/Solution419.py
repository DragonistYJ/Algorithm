from typing import List


class Solution:
    def countBattleships(self, board: List[List[str]]) -> int:
        """
        给定一个二维的甲板， 请计算其中有多少艘战舰。战舰用'X'表示，空位用'.'表示。你需要遵守以下规则：
        给你一个有效的甲板，仅由战舰或者空位组成。
        战舰只能水平或者垂直放置。换句话说,战舰只能由1xN(1行, N列)组成，或者Nx1(N行, 1列)组成，其中N可以是任意大小。
        两艘战舰之间至少有一个水平或垂直的空位分隔-即没有相邻的战舰。
        :param board: [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
        :return: 2
        """
        ans = 0
        n = len(board)
        m = len(board[0])
        for i in range(n):
            for j in range(m):
                if board[i][j] == "X" and (i == 0 or board[i - 1][j] == ".") and (j == 0 or board[i][j - 1] == "."):
                    ans += 1
        return ans


if __name__ == '__main__':
    solution = Solution()
    print(solution.countBattleships([["X", ".", ".", "X"], [".", ".", ".", "X"], [".", ".", ".", "X"]]))
