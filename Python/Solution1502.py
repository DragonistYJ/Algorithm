from typing import List


class Solution:
    def canMakeArithmeticProgression(self, arr: List[int]) -> bool:
        """
        给你一个数字数组 arr 。
        如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。
        如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。
        :param arr: [3,5,1]
        :return: true
        """
        if len(arr) == 2:
            return True

        arr.sort()
        flag = True
        for i in range(2, len(arr)):
            if arr[i] - arr[i - 1] != arr[1] - arr[0]:
                flag = False
                break
        return flag


if __name__ == '__main__':
    solution = Solution()
    print(solution.canMakeArithmeticProgression([3, 5, 1]))
