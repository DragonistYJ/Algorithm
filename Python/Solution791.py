from collections import Counter


class Solution:
    def customSortString(self, S: str, T: str) -> str:
        """
        字符串S和 T 只包含小写字符。在S中，所有字符只会出现一次。
        S已经根据某种规则进行了排序。我们要根据S中的字符顺序对T进行排序。更具体地说，如果S中x在y之前出现，那么返回的字符串中x也应出现在y之前。
        返回任意一种符合条件的字符串T。
        :param S: "cba"
        :param T: "abcd"
        :return: "cbad"
        """
        t_counter = Counter(T)
        ans = ""
        for c in S:
            if c in t_counter:
                ans += c * t_counter[c]
                t_counter[c] = 0
        for c in t_counter:
            if t_counter[c] != 0:
                ans += c * t_counter[c]
        return ans


if __name__ == '__main__':
    solution = Solution()
    print(solution.customSortString("cba", "abcd"))
