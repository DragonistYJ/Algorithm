from typing import List


class Solution:
    def singleNumber(self, nums: List[int]) -> List[int]:
        """
        给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
        :param nums: [1,2,1,3,2,5]
        :return: [3,5]
        """
        zero = 0
        for num in nums:
            zero = zero ^ num
        right_one = zero & (-zero)
        x = 0
        for num in nums:
            if num & right_one == 0:
                x = x ^ num
        return [x, zero ^ x]


if __name__ == '__main__':
    solution = Solution()
    print(solution.singleNumber([1, 2, 1, 3, 2, 5]))
