from functools import cmp_to_key
from typing import List


class Solution:
    def twoCitySchedCost(self, costs: List[List[int]]) -> int:
        """
        公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，飞往 B 市的费用为 costs[i][1]。
        返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。
        :param costs: [[10,20],[30,200],[400,50],[30,20]]
        :return: 110
        """
        cost_sum = 0
        for cost in costs:
            cost_sum += cost[0]
        costs.sort(key=cmp_to_key(lambda x, y: (x[1] - x[0]) - (y[1] - y[0])))
        for i in range(len(costs) // 2):
            cost_sum -= costs[i][0] - costs[i][1]
        return cost_sum


if __name__ == '__main__':
    solution = Solution()
    print(solution.twoCitySchedCost([[10, 20], [30, 200], [400, 50], [30, 20]]))
