from functools import cmp_to_key
from typing import List


def custom_cmp(a, b):
    if a[1] > b[1]:
        return 1
    elif a[1] < b[1]:
        return -1
    else:
        if a[0] < b[0]:
            return 1
        elif a[0] > b[0]:
            return -1
        else:
            return 0


class Solution:
    def frequencySort(self, nums: List[int]) -> List[int]:
        """
        给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
        请你返回排序后的数组。
        :param nums: [1,1,2,2,2,3]
        :return: [3,1,1,2,2,2]
        """
        number_map = {}
        for num in nums:
            number_map[num] = number_map.get(num, 0) + 1
        number_list = []
        for num in number_map:
            number_list.append((num, number_map[num]))
        number_list.sort(key=cmp_to_key(custom_cmp))
        ans = []
        for num in number_list:
            for _ in range(num[1]):
                ans.append(num[0])
        return ans


if __name__ == '__main__':
    solution = Solution()
    print(solution.frequencySort([2, 2, 2, 1, 1, 3, 4]))
