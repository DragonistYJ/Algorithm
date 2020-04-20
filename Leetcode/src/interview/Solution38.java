package interview;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @ClassName Solution38
 * @Author 11214
 * @Date 2020/4/13
 * @Description TODO
 */
public class Solution38 {
    private void permute(StringBuilder builder, HashSet<String> ans, boolean[] visited, String s) {
        if (builder.length() == s.length()) {
            ans.add(builder.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                builder.append(s.charAt(i));
                permute(builder, ans, visited, s);
                builder.deleteCharAt(builder.length() - 1);
                visited[i] = false;
            }
        }
    }

    public String[] permutation(String s) {
        boolean[] visited = new boolean[s.length()];
        HashSet<String> ans = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        permute(builder, ans, visited, s);
        String[] strings = new String[ans.size()];
        int index = 0;
        for (String an : ans) {
            strings[index] = an;
            index += 1;
        }
        return strings;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution38().permutation("abc")));
    }
}
