/**
 * @ClassName Solution1247
 * @Author 11214
 * @Date 2020/6/3
 * @Description 交换字符使得字符串相同
 * 有两个长度相同的字符串 s1 和 s2，且它们其中 只含有 字符 "x" 和 "y"，你需要通过「交换字符」的方式使这两个字符串相同。
 * 每次「交换字符」的时候，你都可以在两个字符串中各选一个字符进行交换。
 * 交换只能发生在两个不同的字符串之间，绝对不能发生在同一个字符串内部。也就是说，我们可以交换 s1[i] 和 s2[j]，但不能交换 s1[i] 和 s1[j]。
 * 最后，请你返回使 s1 和 s2 相同的最小交换次数，如果没有方法能够使得这两个字符串相同，则返回 -1 。
 */
public class Solution1247 {
    public int minimumSwap(String s1, String s2) {
        int x = 0, y = 0;
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == s2.charAt(i)) continue;
            if (s1.charAt(i) == 'x') {
                x += 1;
            } else {
                y += 1;
            }
        }
        if ((x + y) % 2 != 0) return -1;

        if (x % 2 == 0) return (x + y) / 2;
        else return (x + y) / 2 + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1247().minimumSwap("xy", "xy"));
    }
}
