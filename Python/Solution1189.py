class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        """
        给你一个字符串text，你需要使用 text 中的字母来拼凑尽可能多的单词"balloon"（气球）。
        字符串text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词"balloon"。
        :param text: loonbalxballpoon
        :return: 2
        """
        letter_map = {}
        for c in text:
            letter_map[c] = letter_map.get(c, 0) + 1
        return min(letter_map.get('b', 0), letter_map.get('a', 0), letter_map.get('l', 0) // 2,
                   letter_map.get('o', 0) // 2, letter_map.get('n', 0))


if __name__ == '__main__':
    solution = Solution()
    print(solution.maxNumberOfBalloons("loonbalxballpoon"))
