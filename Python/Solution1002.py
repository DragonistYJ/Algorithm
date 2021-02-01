from collections import Counter
from typing import List


class Solution:
    def commonChars(self, A: List[str]) -> List[str]:
        """
        给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
        你可以按任意顺序返回答案。
        :param A: ["bella","label","roller"]
        :return: ["e","l","l"]
        """
        ans = Counter(A[0])
        for i in range(1, len(A)):
            temp = Counter(A[i])
            ans = ans & temp
        result = []
        for key in ans.keys():
            result += [key] * ans[key]
        return result


if __name__ == '__main__':
    solution = Solution()
    print(solution.commonChars(["bella", "label", "roller"]))
