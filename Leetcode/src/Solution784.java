import java.util.ArrayList;
import java.util.List;

/*
NO784 字母大小写全排列
给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 */
public class Solution784 {
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<>();
        ans.add("");
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (Character.isDigit(c)) {
                for (int j = 0; j < ans.size(); j++) {
                    ans.set(j, ans.get(j) + c);
                }
            } else if (Character.isLowerCase(c)) {
                List<String> tmp = new ArrayList<>(ans);
                for (int j = 0; j < tmp.size(); j++) {
                    ans.set(j, tmp.get(j) + c);
                    ans.add(tmp.get(j) + Character.toUpperCase(c));
                }
            } else if (Character.isUpperCase(c)) {
                List<String> tmp = new ArrayList<>(ans);
                for (int j = 0; j < tmp.size(); j++) {
                    ans.set(j, tmp.get(j) + c);
                    ans.add(tmp.get(j) + Character.toLowerCase(c));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution784().letterCasePermutation("12345"));
    }
}
