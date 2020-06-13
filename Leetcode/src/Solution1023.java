import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution1023
 * @Author 11214
 * @Date 2020/6/12
 * @Description 驼峰式匹配
 * 如果我们可以将小写字母插入模式串 pattern 得到待查询项 query，那么待查询项与给定模式串匹配。（我们可以在任何位置插入每个字符，也可以插入 0 个字符。）
 * 给定待查询列表 queries，和模式串 pattern，返回由布尔值组成的答案列表 answer。只有在待查项 queries[i] 与模式串 pattern 匹配时， answer[i] 才为 true，否则为 false。
 */
public class Solution1023 {
    private boolean compare(String query, String pattern) {
        int len1 = query.length();
        int len2 = pattern.length();
        if (len1 < len2) return false;
        int i = 0;
        int j = 0;
        while (i < len1 && j < len2) {
            if (query.charAt(i) == pattern.charAt(j)) {
                i += 1;
                j += 1;
            } else if (Character.isUpperCase(query.charAt(i))) {
                return false;
            } else {
                i += 1;
            }
        }
        while (i < len1) {
            if (Character.isUpperCase(query.charAt(i))) return false;
            i += 1;
        }
        return j >= len2;
    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        int n = queries.length;
        List<Boolean> ans = new ArrayList<>();
        for (String query : queries) {
            ans.add(compare(query, pattern));
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] queries = {"FoBar", "CounterPick", "ControlPanel"};
        System.out.println(new Solution1023().camelMatch(queries, "FoBaT"));
    }
}
