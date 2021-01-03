from typing import List


class Solution:
    def numIdenticalPairs(self, nums: List[int]) -> int:
        """
        给你一个整数数组 nums 。
        如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
        返回好数对的数目。
        :param nums: [1,2,3,1,1,3]
        :return: 4
        """
        num_map = {}
        for num in nums:
            num_map[num] = num_map.get(num, 0) + 1
        ans = 0
        for num in num_map:
            ans += (num_map[num] - 1) * num_map[num] // 2
        return ans


if __name__ == '__main__':
    solution = Solution()
    print(solution.numIdenticalPairs([1, 2, 3, 1, 1, 3]))
