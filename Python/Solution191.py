from collections import Counter


class Solution:
    def hammingWeight(self, n: int) -> int:
        """
        编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
        提示：
        请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
        在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的示例3中，输入表示有符号整数 -3。
        进阶：
        如果多次调用这个函数，你将如何优化你的算法？
        :param n: 00000000000000000000000000001011
        :return: 3
        """
        s = bin(n).replace("0b", "")
        counter = Counter(s)
        return counter["1"]


if __name__ == '__main__':
    solution = Solution()
    print(solution.hammingWeight(13))
