class Solution:
    def reverseWords(self, s: str) -> str:
        """
        给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
        :param s: "Let's take LeetCode contest"
        :return: "s'teL ekat edoCteeL tsetnoc"
        """
        words = s.split()
        reverse_words = []
        for word in words:
            chars = list(word)
            chars.reverse()
            reverse_words.append("".join(chars))
        return " ".join(reverse_words)


if __name__ == '__main__':
    solution = Solution()
    print(solution.reverseWords("Let's take LeetCode contest"))
