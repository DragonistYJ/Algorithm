from typing import List


class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        """
        给你一个长度为n的整数数组nums，其中n>1，返回输出数组output，其中output[i]等于nums中除nums[i]之外其余各元素的乘积。
        :param nums: [1,2,3,4]
        :return: [24,12,8,6]
        """
        left = [1]
        for i in range(len(nums) - 1):
            left.append(left[i] * nums[i])
        right = [1]
        for i in range(len(nums) - 1):
            right.append(right[i] * nums[len(nums) - i - 1])
        right.reverse()
        ans = []
        for i in range(len(nums)):
            ans.append(left[i] * right[i])
        return ans


if __name__ == '__main__':
    solution = Solution()
    print(solution.productExceptSelf([1, 2, 3, 4]))
