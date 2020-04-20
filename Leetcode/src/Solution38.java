import java.util.List;

/*
NO38 外观数列
「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
1.     1
2.     11
3.     21
4.     1211
5.     111221
1 被读作  "one 1"  ("一个一") , 即 11。
11 被读作 "two 1s" ("两个一"）, 即 21。
21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
注意：整数序列中的每一项将表示为一个字符串。
 */
public class Solution38 {
    public String countAndSay(int n) {
        StringBuilder ans = new StringBuilder("1");
        for (int i = 2; i <= n; i++) {
            String tmp = ans.toString();
            ans = new StringBuilder();
            char c = tmp.charAt(0);
            int sum = 1;
            for (int j = 1; j < tmp.length(); j++) {
                if (tmp.charAt(j) == c) {
                    sum += 1;
                } else {
                    ans.append(sum);
                    ans.append(c);
                    c = tmp.charAt(j);
                    sum = 1;
                }
            }
            ans.append(sum);
            ans.append(c);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution38().countAndSay(2));
    }
}
