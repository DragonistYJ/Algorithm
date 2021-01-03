from typing import List


class Solution:
    def maximumWealth(self, accounts: List[List[int]]) -> int:
        """
        给你一个 m x n 的整数网格 accounts ，其中 accounts[i][j] 是第i位客户在第j家银行托管的资产数量。返回最富有客户所拥有的资产总量 。
        客户的 资产总量 就是他们在各家银行托管的资产数量之和。最富有客户就是 资产总量 最大的客户。
        :param accounts: [[1,5],[7,3],[3,5]]
        :return: 10
        """
        ans = 0
        for account_row in accounts:
            s = sum(account_row)
            ans = max(ans, s)
        return ans


if __name__ == '__main__':
    solution = Solution()
    print(solution.maximumWealth([[1, 5], [7, 3], [3, 5]]))
