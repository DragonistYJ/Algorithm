from typing import List


class Solution:
    def findWords(self, words: List[str]) -> List[str]:
        """
        给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
        美式键盘 中：
        第一行由字符 "qwertyuiop" 组成。
        第二行由字符 "asdfghjkl" 组成。
        第三行由字符 "zxcvbnm" 组成。
        :param words: ["Hello","Alaska","Dad","Peace"]
        :return: ["Alaska","Dad"]
        """
        rows = [set("qwertyuiop"), set("asdfghjkl"), set("zxcvbnm")]
        ans = []
        for word in words:
            word_set = set(word.lower())
            if word_set.issubset(rows[0]) or word_set.issubset(rows[1]) or word_set.issubset(rows[2]):
                ans.append(word)
        return ans


if __name__ == '__main__':
    solution = Solution()
    print(solution.findWords(["Hello", "Alaska", "Dad", "Peace"]))
