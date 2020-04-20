import java.util.Arrays;

/*
NO899 有序队列
给出了一个由小写字母组成的字符串 S。然后，我们可以进行任意次数的移动。
在每次移动中，我们选择前 K 个字母中的一个（从左侧开始），将其从原位置移除，并放置在字符串的末尾。
返回我们在任意次数的移动之后可以拥有的按字典顺序排列的最小字符串。
 */
public class Solution899 {
    public String orderlyQueue(String S, int K) {
        if (K == 1) {
            String ans = S;
            for (int i = 1; i < S.length(); i++) {
                String tmp = S.substring(i) + S.substring(0, i);
                if (tmp.compareTo(ans) < 0) ans = tmp;
            }
            return ans;
        } else {
            char[] chars = S.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution899().orderlyQueue("baaca", 1));
    }
}
