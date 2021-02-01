from typing import List


class Solution:
    def heightChecker(self, heights: List[int]) -> int:
        """
        学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
        请你返回能让所有学生以 非递减 高度排列的最小必要移动人数。
        注意，当一组学生被选中时，他们之间可以以任何可能的方式重新排序，而未被选中的学生应该保持不动。
        :param heights: [1,1,4,2,1,3]
        :return: 3
        """
        heights_copy = heights.copy()
        heights_copy.sort()
        ans = 0
        for index, num in enumerate(heights):
            if num != heights_copy[index]:
                ans += 1
        return ans


if __name__ == '__main__':
    solution = Solution()
    print(solution.heightChecker([1, 1, 4, 2, 1, 3]))
