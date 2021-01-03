from typing import List


class Solution:
    def shuffle(self, nums: List[int], n: int) -> List[int]:
        """
        给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
        请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
        :param nums: [2,5,1,3,4,7]
        :param n: 3
        :return: [2,3,5,4,1,7]
        """
        ans = []
        for i in range(n):
            ans.append(nums[i])
            ans.append(nums[i + n])
        return ans


if __name__ == '__main__':
    solution = Solution()
    print(solution.shuffle([2, 5, 1, 3, 4, 7], 3))
