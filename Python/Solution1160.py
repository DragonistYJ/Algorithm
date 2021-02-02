from collections import Counter
from typing import List


class Solution:
    def countCharacters(self, words: List[str], chars: str) -> int:
        """
        给你一份『词汇表』（字符串数组）words和一张『字母表』（字符串）chars。
        假如你可以用chars中的『字母』（字符）拼写出words中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
        注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
        返回词汇表words中你掌握的所有单词的 长度之和。
        :param words: ["cat","bt","hat","tree"]
        :param chars: "atach"
        :return: 6
        """
        counter = Counter(chars)
        ans = 0
        for word in words:
            word_counter = Counter(word)
            flag = True
            for key in word_counter:
                if counter[key] < word_counter[key]:
                    flag = False
                    break
            if flag:
                ans += len(word)

        return ans


if __name__ == '__main__':
    solution = Solution()
    print(solution.countCharacters(["cat", "bt", "hat", "tree"], "atach"))
