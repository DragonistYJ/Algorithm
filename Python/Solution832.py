from typing import List


class Solution:
    def flipAndInvertImage(self, A: List[List[int]]) -> List[List[int]]:
        """
        给定一个二进制矩阵A，我们想先水平翻转图像，然后反转图像并返回结果。
        水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转[1, 1, 0]的结果是[0, 1, 1]。
        反转图片的意思是图片中的0全部被1替换，1全部被0替换。例如，反转[0, 1, 1]的结果是[1, 0, 0]。
        :param A: [[1,1,0],[1,0,1],[0,0,0]]
        :return: [[1,0,0],[0,1,0],[1,1,1]]
        """
        n = len(A[0])
        for row in A:
            for i in range(n // 2):
                k = row[i]
                row[i] = row[n - i - 1]
                row[n - i - 1] = k
                row[i] = row[i] ^ 1
                row[n - i - 1] = row[n - i - 1] ^ 1
            if n % 2 == 1:
                row[n // 2] = row[n // 2] ^ 1
        return A


if __name__ == '__main__':
    solution = Solution()
    print(solution.flipAndInvertImage([[1, 1, 0], [1, 0, 1], [0, 0, 0]]))
