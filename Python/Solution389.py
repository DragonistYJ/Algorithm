from collections import Counter


class Solution:
    def findTheDifference(self, s: str, t: str) -> str:
        """
        给定两个字符串 s 和 t，它们只包含小写字母。
        字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
        请找出在 t 中被添加的字母。
        :param s: "abcd"
        :param t: "abcde"
        :return: e
        """
        t_counter = Counter(t)
        s_counter = Counter(s)
        keys = (t_counter - s_counter).keys()
        return next(iter(keys))


if __name__ == '__main__':
    solution = Solution()
    print(solution.findTheDifference("abcd", "abced"))
