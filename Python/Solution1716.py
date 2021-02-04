class Solution:
    def totalMoney(self, n: int) -> int:
        """
        Hercy 想要为购买第一辆车存钱。他 每天 都往力扣银行里存钱。
        最开始，他在周一的时候存入1块钱。从周二到周日，他每天都比前一天多存入1块钱。在接下来每一个周一，他都会比 前一个周一 多存入1块钱。
        给你n，请你返回在第n天结束的时候他在力扣银行总共存了多少块钱。
        :param n: 20
        :return: 96
        """
        money = 1
        week = 1
        s = 0
        while n > 0:
            s += money
            money += 1
            week += 1
            n -= 1
            if week == 8:
                money -= 6
                week = 1
        return s


if __name__ == '__main__':
    solution = Solution()
    print(solution.totalMoney(20))
