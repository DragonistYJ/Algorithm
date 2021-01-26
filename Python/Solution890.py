from typing import List


class Solution:
    def create_pattern(self, word: str) -> List[int]:
        position_map = {}
        index = 0
        pattern_list = []

        for c in word:
            if c in position_map:
                pattern_list.append(position_map[c])
            else:
                pattern_list.append(index)
                position_map[c] = index
                index += 1
        return pattern_list

    def findAndReplacePattern(self, words: List[str], pattern: str) -> List[str]:
        """
        你有一个单词列表words和一个模式pattern，你想知道 words 中的哪些单词与模式匹配。
        如果存在字母的排列 p，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
        （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
        返回 words 中与给定模式匹配的单词列表。
        你可以按任何顺序返回答案。
        :param words: ["abc","deq","mee","aqq","dkd","ccc"]
        :param pattern: "abb"
        :return: ["mee","aqq"]
        """
        pattern_list = self.create_pattern(pattern)

        ans = []
        for word in words:
            word_list = self.create_pattern(word)
            if pattern_list == word_list:
                ans.append(word)

        return ans


if __name__ == '__main__':
    solution = Solution()
    print(solution.findAndReplacePattern(["abc", "deq", "mee", "aqq", "dkd", "ccc"], "abb"))
