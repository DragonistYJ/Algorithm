from typing import List


class Solution:
    def findLucky(self, arr: List[int]) -> int:
        """
        在整数数组中，如果一个整数的出现频次和它的数值大小相等，我们就称这个整数为「幸运数」。
        给你一个整数数组 arr，请你从中找出并返回一个幸运数。
        如果数组中存在多个幸运数，只需返回 最大 的那个。
        如果数组中不含幸运数，则返回 -1 。
        :param arr: [2,2,3,4]
        :return: 2
        """
        hash_map = {}
        for a in arr:
            hash_map[a] = hash_map.get(a, 0) + 1
        res = -1
        for key in hash_map:
            if key == hash_map[key]:
                res = max(res, key)
        return res


if __name__ == '__main__':
    solution = Solution()
    print(solution.findLucky([2, 2, 3, 3, 3, 4]))
