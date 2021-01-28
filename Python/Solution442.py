from typing import List


class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        """
        给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
        找到所有出现两次的元素。
        你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
        :param nums: [4,3,2,7,8,2,3,1]
        :return: [2,3]
        """
        ans = []
        for num in nums:
            index = abs(num) - 1
            if nums[index] < 0:
                ans.append(abs(index + 1))
            nums[index] = -nums[index]
        return ans


if __name__ == '__main__':
    solution = Solution()
    print(solution.findDuplicates([4, 3, 2, 7, 8, 2, 3, 1]))
