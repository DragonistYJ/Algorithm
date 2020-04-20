/*
NO949 给定数字能组成的最大时间
给定一个由 4 位数字组成的数组，返回可以设置的符合 24 小时制的最大时间。
最小的 24 小时制时间是 00:00，而最大的是 23:59。从 00:00 （午夜）开始算起，过得越久，时间越大。
以长度为 5 的字符串返回答案。如果不能确定有效时间，则返回空字符串。
 */
public class Solution949 {
    public String largestTimeFromDigits(int[] A) {
        String ans = "";
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j == i) continue;
                for (int k = 0; k < 4; k++) {
                    if (k == i || k == j) continue;
                    for (int l = 0; l < 4; l++) {
                        if (l == i || l == j || l == k) continue;
                        if (isAvailable(A[i], A[j], A[k], A[l])) {
                            String s = makeString(A[i], A[j], A[k], A[l]);
                            if (ans.equals("")) ans = s;
                            else if (ans.compareTo(s) < 0) ans = s;
                        }
                    }
                }
            }
        }
        return ans;
    }

    private String makeString(int a, int b, int c, int d) {
        return String.valueOf(a) + b + ':' + c + d;
    }

    private boolean isAvailable(int a, int b, int c, int d) {
        int hour = a * 10 + b;
        int minute = c * 10 + 1;
        return hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59;
    }

    public static void main(String[] args) {
        int[] x = {5, 5, 5, 5};
        System.out.println(new Solution949().largestTimeFromDigits(x));
    }
}
