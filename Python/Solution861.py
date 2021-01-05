from typing import List


class Solution:
    def matrixScore(self, A: List[List[int]]) -> int:
        """
        有一个二维矩阵A 其中每个元素的值为0或1。
        移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
        在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
        返回尽可能高的分数。
        :param A: [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
        :return: 39
        """
        n = len(A)
        m = len(A[0])
        for row in A:
            if row[0] == 0:
                for i in range(m):
                    row[i] = row[i] ^ 1
        sum = pow(2, m - 1) * n
        for i in range(1, m):
            count = 0
            for j in range(n):
                if A[j][i] == 1:
                    count += 1
            sum += pow(2, m - i - 1) * max(count, n - count)
        return sum


if __name__ == '__main__':
    solution = Solution()
    print(solution.matrixScore([[0, 0, 1, 1], [1, 0, 1, 0], [1, 1, 0, 0]]))
