from typing import List


class Solution:
    def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
        """
        给你一个数组candies和一个整数extraCandies，其中candies[i]代表第 i 个孩子拥有的糖果数目。
        对每一个孩子，检查是否存在一种方案，将额外的extraCandies个糖果分配给孩子们之后，此孩子有 最多的糖果。注意，允许有多个孩子同时拥有 最多的糖果数目。
        :param candies: [2,3,5,1,3]
        :param extraCandies: 3
        :return: [true,true,true,false,true]
        """
        max_num = max(candies)
        ans = []
        for candy in candies:
            if candy + extraCandies >= max_num:
                ans.append(True)
            else:
                ans.append(False)
        return ans


if __name__ == '__main__':
    solution = Solution()
    print(solution.kidsWithCandies([2, 3, 5, 1, 3], 3))
