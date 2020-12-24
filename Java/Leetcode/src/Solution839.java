import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
NO839 相似字符串组
如果我们交换字符串 X 中的两个不同位置的字母，使得它和字符串 Y 相等，那么称 X 和 Y 两个字符串相似。如果这两个字符串本身是相等的，那它们也是相似的。
例如，"tars" 和 "rats" 是相似的 (交换 0 与 2 的位置)； "rats" 和 "arts" 也是相似的，但是 "star" 不与 "tars"，"rats"，或 "arts" 相似。
总之，它们通过相似性形成了两个关联组：{"tars", "rats", "arts"} 和 {"star"}。注意，"tars" 和 "arts" 是在同一组中，即使它们并不相似。形式上，对每个组而言，要确定一个单词在组中，只需要这个词和该组中至少一个单词相似。
我们给出了一个不包含重复的字符串列表 A。列表中的每个字符串都是 A 中其它所有字符串的一个字母异位词。请问 A 中有多少个相似字符串组？
 */
public class Solution839 {
    int n;

    private boolean isSim(String s1, String s2) {
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) tmp += 1;
            if (tmp > 2) return false;
        }
        return true;
    }

    private int root(int[] group, int i) {
        while (group[i] != i) {
            group[i] = group[group[i]];
            i = group[i];
        }
        return i;
    }

    public int numSimilarGroups(String[] A) {
        n = A[0].length();
        int[] group = new int[A.length];
        for (int i = 0; i < group.length; i++) {
            group[i] = i;
        }
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (isSim(A[i], A[j])) {
                    group[root(group, i)] = root(group, j);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < group.length; i++) {
            if (group[i] == i) {
                ans += 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] s = {"tars","rats","arts","star"};
        System.out.println(new Solution839().numSimilarGroups(s));
    }
}
