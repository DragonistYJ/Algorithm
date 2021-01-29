class Solution:
    def minFlips(self, target: str) -> int:
        """
        房间中有 n 个灯泡，编号从 0 到 n-1 ，自左向右排成一行。最开始的时候，所有的灯泡都是 关 着的。
        请你设法使得灯泡的开关状态和 target 描述的状态一致，其中 target[i] 等于 1 第 i 个灯泡是开着的，等于 0 意味着第 i 个灯是关着的。
        有一个开关可以用于翻转灯泡的状态，翻转操作定义如下：
        选择当前配置下的任意一个灯泡（下标为 i ）
        翻转下标从 i 到 n-1 的每个灯泡
        翻转时，如果灯泡的状态为 0 就变为 1，为 1 就变为 0 。
        返回达成 target 描述的状态所需的 最少 翻转次数。
        :param target: "001011101"
        :return: 5
        """
        ans = 0
        while len(target) != 0:
            if target[0] == "0":
                target = target[1:]
                continue
            ans += 2
            while len(target) != 0 and target[0] == "1":
                target = target[1:]
            if len(target) == 0:
                ans -= 1

        return ans


if __name__ == '__main__':
    solution = Solution()
    print(solution.minFlips("00101110100"))
