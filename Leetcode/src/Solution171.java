/*
NO171 Excel列表序号
给定一个Excel表格中的列名称，返回其相应的列序号。
 */
public class Solution171 {
    public int titleToNumber(String s) {
        int exp = 1;
        int ans = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int num = s.charAt(i) - 'A' + 1;
            ans += num * exp;
            exp = exp * 26;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution171().titleToNumber("A"));
    }
}
