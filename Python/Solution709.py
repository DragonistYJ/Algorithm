class Solution:
    def toLowerCase(self, str: str) -> str:
        """
        实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
        :param str: Hello
        :return: hello
        """
        return str.lower()


if __name__ == '__main__':
    solution = Solution()
    print(solution.toLowerCase("Hello"))
