from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        """
        给定一个整数数组nums和一个目标值target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
        你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
        :param nums: [2, 7, 11, 15]
        :param target: 9
        :return: [0, 1]
        """
        hash_table = {}
        for i in range(len(nums)):
            a = target - nums[i]
            if a in hash_table:
                return [hash_table[a], i]
            else:
                hash_table[nums[i]] = i


if __name__ == '__main__':
    solution = Solution()
    print(solution.twoSum([2, 7, 11, 15], 9))
