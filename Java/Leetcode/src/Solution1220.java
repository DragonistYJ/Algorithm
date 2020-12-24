/*
NO1220 统计元音字母序列的数目
给你一个整数 n，请你帮忙统计一下我们可以按下述规则形成多少个长度为 n 的字符串：

字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'）
每个元音 'a' 后面都只能跟着 'e'
每个元音 'e' 后面只能跟着 'a' 或者是 'i'
每个元音 'i' 后面 不能 再跟着另一个 'i'
每个元音 'o' 后面只能跟着 'i' 或者是 'u'
每个元音 'u' 后面只能跟着 'a'
由于答案可能会很大，所以请你返回 模 10^9 + 7 之后的结果。
 */
public class Solution1220 {
    public int countVowelPermutation(int n) {
        int mod = 1000000000 + 7;
        int a = 1;
        int e = 1;
        int i = 1;
        int o = 1;
        int u = 1;
        for (int j = 2; j <= n; j++) {
            int aa = ((e + i) % mod + u) % mod;
            int ee = (a + i) % mod;
            int ii = (e + o) % mod;
            int oo = (i) % mod;
            int uu = (i + o) % mod;
            a = aa;
            e = ee;
            i = ii;
            o = oo;
            u = uu;
        }

        return ((((a + e) % mod + i) % mod + o) % mod + u) % mod;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1220().countVowelPermutation(144));
    }
}
