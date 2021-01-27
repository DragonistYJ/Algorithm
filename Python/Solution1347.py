from collections import Counter


class Solution:
    def minSteps(self, s: str, t: str) -> int:
        """
        给你两个长度相等的字符串s和t。每一个步骤中，你可以选择将t中的任一字符替换为另一个字符。
        返回使t成为s的字母异位词的最小步骤数。
        字母异位词指字母相同，但排列不同（也可能相同）的字符串。
        :param s: "leetcode"
        :param t: "practice"
        :return: 5
        """
        s_counter = Counter(s)
        t_counter = Counter(t)
        intersection = t_counter - s_counter
        ans = 0
        for c in intersection:
            ans += intersection[c]
        return ans


if __name__ == '__main__':
    solution = Solution()
    print(solution.minSteps("leetcode", "practice"))
