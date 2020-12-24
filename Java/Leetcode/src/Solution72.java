/*
NO72 编辑距离
给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
你可以对一个单词进行如下三种操作：
1. 插入一个字符
2. 删除一个字符
3. 替换一个字符
 */
public class Solution72 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m == 0) return n;
        if (n == 0) return m;

        int[][] steps = new int[m][n];
        if (word1.charAt(0) == word2.charAt(0)) steps[0][0] = 0;
        else steps[0][0] = 1;
        int index = 1;
        while (index < n && word1.charAt(0) != word2.charAt(index)) {
            steps[0][index] = steps[0][index - 1] + 1;
            index += 1;
        }
        if (index < n) steps[0][index] = steps[0][index - 1];
        index += 1;
        while (index < n) {
            steps[0][index] = steps[0][index - 1] + 1;
            index += 1;
        }
        index = 1;
        while (index < m && word2.charAt(0) != word1.charAt(index)) {
            steps[index][0] = steps[index - 1][0] + 1;
            index += 1;
        }
        if (index < m) steps[index][0] = steps[index - 1][0];
        index += 1;
        while (index < m) {
            steps[index][0] = steps[index - 1][0] + 1;
            index += 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    steps[i][j] = 1 + Math.min(steps[i - 1][j], Math.min(steps[i][j - 1], steps[i - 1][j - 1] - 1));
                } else {
                    steps[i][j] = 1 + Math.min(steps[i - 1][j], Math.min(steps[i][j - 1], steps[i - 1][j - 1]));
                }
            }
        }
        return steps[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution72().minDistance("intention", "execution"));
    }
}
