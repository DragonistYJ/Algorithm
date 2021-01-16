from typing import List


class Solution:
    def numTeams(self, rating: List[int]) -> int:
        """
        n 名士兵站成一排。每个士兵都有一个 独一无二 的评分 rating 。
        每 3 个士兵可以组成一个作战单位，分组规则如下：
        从队伍中选出下标分别为 i、j、k 的 3 名士兵，他们的评分分别为 rating[i]、rating[j]、rating[k]
        作战单位需满足： rating[i] < rating[j] < rating[k] 或者 rating[i] > rating[j] > rating[k] ，其中0<=i<j<k<n
        请你返回按上述条件可以组建的作战单位数量。每个士兵都可以是多个作战单位的一部分。
        :param rating: [2,5,3,4,1]
        :return: 3
        """
        ans = 0
        for i in range(1, len(rating) - 1):
            left_less = 0
            left_more = 0
            for j in range(0, i):
                if rating[j] < rating[i]:
                    left_less += 1
                else:
                    left_more += 1
            right_less = 0
            right_more = 0
            for j in range(i + 1, len(rating)):
                if rating[j] > rating[i]:
                    right_more += 1
                else:
                    right_less += 1
            ans += left_less * right_more
            ans += left_more * right_less
        return ans


if __name__ == '__main__':
    solution = Solution()
    print(solution.numTeams([2, 5, 3, 4, 1]))
