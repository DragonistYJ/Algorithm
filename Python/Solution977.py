from typing import List


class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        """
        给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
        :param nums: [-4,-1,0,3,10]
        :return: [0,1,9,16,100]
        """
        for i in range(len(nums)):
            nums[i] = nums[i] * nums[i]
        nums.sort()
        return nums


if __name__ == '__main__':
    solution = Solution()
    print(solution.sortedSquares([-4, -1, 0, 3, 10]))
