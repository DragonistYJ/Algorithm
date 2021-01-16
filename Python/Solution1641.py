class Solution:
    def countVowelStrings(self, n: int) -> int:
        """
        给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。
        字符串s按字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。
        :param n: 2
        :return: 15
        """
        row = [1] * n
        for i in range(2, 6):
            temp = [i]
            for j in range(1, n):
                temp.append(row[j] + temp[j - 1])
            row = temp
        return row[n - 1]


if __name__ == '__main__':
    solution = Solution()
    print(solution.countVowelStrings(33))
