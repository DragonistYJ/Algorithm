from typing import List


class Solution:
    def __init__(self):
        self.already = []

    def check(self, s: str) -> bool:
        for i in range(len(s) // 2):
            if s[i] != s[len(s) - i - 1]:
                return False
        return True

    def partition(self, s: str) -> List[List[str]]:
        """
        给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
        返回 s 所有可能的分割方案。
        :param s: "aab"
        :return: [["aa","b"],["a","a","b"]]
        """
        ans = []
        if self.check(s):
            ans.append(self.already.copy() + [s])
        for i in range(1, len(s)):
            left = s[0:i]
            if self.check(left):
                self.already.append(left)
                ans += self.partition(s[i:])
                self.already = self.already[0:len(self.already) - 1]
        return ans


if __name__ == '__main__':
    solution = Solution()
    print(solution.partition("aabaa"))
