from typing import List


class Solution:
    def selfDividingNumbers(self, left: int, right: int) -> List[int]:
        """
        自除数是指可以被它包含的每一位数除尽的数。
        例如，128 是一个自除数，因为128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
        还有，自除数不允许包含 0 。
        给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
        :param left: 1
        :param right: 22
        :return: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
        """
        ans = []
        for i in range(left, right + 1):
            factors = []
            k = i
            while k != 0:
                factors.append(k % 10)
                k //= 10

            flag = True
            for factor in factors:
                if factor == 0 or i % factor != 0:
                    flag = False
                    break
            if flag:
                ans.append(i)
        return ans


if __name__ == '__main__':
    solution = Solution()
    print(solution.selfDividingNumbers(1, 22))
