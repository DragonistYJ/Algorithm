from typing import List


class Solution:
    def luckyNumbers(self, matrix: List[List[int]]) -> List[int]:
        """
        给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
        幸运数是指矩阵中满足同时下列两个条件的元素：
        在同一行的所有元素中最小
        在同一列的所有元素中最大
        :param matrix: [[3,7,8],[9,11,13],[15,16,17]]
        :return: [15]
        """
        ans = []
        for row in matrix:
            min_num = min(row)
            index = row.index(min_num)
            col = []
            for i in range(len(matrix)):
                col.append(matrix[i][index])
            if min_num == max(col):
                ans.append(min_num)
        return ans


if __name__ == '__main__':
    solution = Solution()
    print(solution.luckyNumbers([[3, 7, 8], [9, 11, 13], [15, 16, 17]]))
