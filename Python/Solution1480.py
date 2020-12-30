from typing import List


class Solution:
    def runningSum(self, nums: List[int]) -> List[int]:
        """
        给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
        请返回 nums 的动态和。
        :param nums: [1,2,3,4]
        :return: [1,3,6,10]
        """
        ans = []
        reminder = 0
        for num in nums:
            reminder += num
            ans.append(reminder)
        return ans


if __name__ == '__main__':
    solution = Solution()
    print(solution.runningSum([1, 2, 3, 4]))
