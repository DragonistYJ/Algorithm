import java.util.ArrayList;
import java.util.List;

/*
NO842 将数组拆分成斐波那契数列
给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
形式上，斐波那契式序列是一个非负整数列表 F，且满足：
0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
F.length >= 3；
对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
返回从 S 拆分出来的所有斐波那契式的序列块，如果不能拆分则返回 []。
 */
public class Solution842 {
    public List<Integer> splitIntoFibonacci(String S) {
        int len = S.length();
        if (len < 3) return new ArrayList<>();
        for (int i = 1; i < Math.min(11, len); i++) {
            for (int j = i + 1; j < Math.min(i + 11, len); j++) {
                List<Integer> ans = new ArrayList<>();
                String first = S.substring(0, i);
                String second = S.substring(i, j);
                if (first.startsWith("0") && first.length() > 1) continue;
                if (second.startsWith("0") && second.length() > 1) continue;

                long t = Long.parseLong(first);
                if (t > Integer.MAX_VALUE) break;
                t = Long.parseLong(second);
                if (t > Integer.MAX_VALUE) break;
                int a = Integer.parseInt(first);
                int b = Integer.parseInt(second);
                ans.add(a);
                ans.add(b);
                String tmp = S.substring(j);
                boolean flag = true;
                while (tmp.length() != 0) {
                    t = a + b;
                    if (t > Integer.MAX_VALUE) {
                        flag = false;
                        break;
                    }
                    int c = a + b;
                    a = b;
                    b = c;
                    String cc = Integer.toString(c);
                    if (tmp.startsWith(cc)) {
                        ans.add(c);
                        tmp = tmp.substring(cc.length());
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (flag) return ans;
            }
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        System.out.println(new Solution842().splitIntoFibonacci("214748364721474836422147483641"));
    }
}
