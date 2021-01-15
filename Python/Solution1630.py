from typing import List


class Solution:
    def checkArithmeticSubarrays(self, nums: List[int], l: List[int], r: List[int]) -> List[bool]:
        """
        给你一个由 n 个整数组成的数组 nums，和两个由 m 个整数组成的数组 l 和 r，后两个数组表示 m 组范围查询，其中第 i 个查询对应范围 [l[i], r[i]]。
        所有数组的下标都是 从 0 开始 的。
        返回 boolean 元素构成的答案列表 answer 。
        如果子数组 nums[l[i]], nums[l[i]+1], ... , nums[r[i]] 可以 重新排列 形成 等差数列 ，answer[i] 的值就是 true；
        否则answer[i] 的值就是 false 。
        :param nums: [4,6,5,9,3,7]
        :param l: [0,0,2]
        :param r: [2,3,5]
        :return: [true,false,true]
        """
        ans = []
        m = len(l)
        for i in range(m):
            sub_nums = nums[l[i]:r[i] + 1]
            sub_nums.sort()
            flag = True
            for j in range(2, len(sub_nums)):
                if sub_nums[j] - sub_nums[j - 1] != sub_nums[1] - sub_nums[0]:
                    flag = False
                    break
            ans.append(flag)
        return ans


if __name__ == '__main__':
    solution = Solution()
    print(solution.checkArithmeticSubarrays([4, 6, 5, 9, 3, 7], [0, 0, 2], [2, 3, 5]))
