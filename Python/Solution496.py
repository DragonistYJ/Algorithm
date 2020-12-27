from typing import List


class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        """
        给定两个没有重复元素的数组nums1和nums2，其中nums1是nums2的子集。找到nums1中每个元素在nums2中的下一个比其大的值。
        nums1中数字x的下一个更大元素是指x在nums2中对应位置的右边的第一个比x大的元素。如果不存在，对应位置输出 - 1 。
        :param nums1: [4,1,2]
        :param nums2: [1,3,4,2]
        :return: [-1,3,-1]
        """
        ans_map = {}
        for i, num in enumerate(nums2):
            ans_map[nums2[i]] = -1
            for j in range(i + 1, len(nums2)):
                if nums2[j] > nums2[i]:
                    ans_map[nums2[i]] = nums2[j]
                    break
        ans = []
        for num in nums1:
            ans.append(ans_map[num])
        return ans


if __name__ == '__main__':
    solution = Solution()
    print(solution.nextGreaterElement([2, 4], [1, 2, 3, 4]))
