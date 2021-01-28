from typing import List


class Solution:
    def spiralMatrixIII(self, R: int, C: int, r0: int, c0: int) -> List[List[int]]:
        """
        在R行C列的矩阵上，我们从(r0, c0)面朝东面开始
        这里，网格的西北角位于第一行第一列，网格的东南角位于最后一行最后一列。
        现在，我们以顺时针按螺旋状行走，访问此网格中的每个位置。
        每当我们移动到网格的边界之外时，我们会继续在网格之外行走（但稍后可能会返回到网格边界）。
        最终，我们到过网格的所有R * C个空间。
        按照访问顺序返回表示网格位置的坐标列表。
        :param R: 5
        :param C: 6
        :param r0: 1
        :param c0: 4
        :return: [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]
        """
        ans = [[r0, c0]]
        direction = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        dir_index = 0
        step_length = 1
        while len(ans) < R * C:
            for j in range(dir_index, dir_index + 2):
                for _ in range(step_length):
                    r0 += direction[j][0]
                    c0 += direction[j][1]
                    if 0 <= r0 < R and 0 <= c0 < C:
                        ans.append([r0, c0])
            dir_index = (dir_index + 2) % 4
            step_length += 1
        return ans


if __name__ == '__main__':
    solution = Solution()
    print(solution.spiralMatrixIII(5, 6, 1, 4))
