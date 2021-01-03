from typing import List


class Solution:
    def countConsistentStrings(self, allowed: str, words: List[str]) -> int:
        """
        给你一个由不同字符组成的字符串allowed和一个字符串数组words。如果一个字符串的每一个字符都在 allowed中，就称这个字符串是 一致字符串 。
        请你返回words数组中一致字符串 的数目。
        :param allowed: "ab"
        :param words: ["ad","bd","aaab","baa","badab"]
        :return: 2
        """
        ans = 0
        word_set = set(allowed)
        for word in words:
            flag = True
            for letter in word:
                if letter not in word_set:
                    flag = False
                    break
            if flag:
                ans += 1
        return ans


if __name__ == '__main__':
    solution = Solution()
    print(solution.countConsistentStrings("ab", ["ad", "bd", "aaab", "baa", "badab"]))
