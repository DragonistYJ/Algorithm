/**
 * @author 11214
 * @since 2023/3/7 19:53
 */
public class Solution2 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int la = a.length() - 1;
        int lb = b.length() - 1;
        int c = 0;
        while (la >= 0 && lb >= 0) {
            int x = a.charAt(la) - '0' + b.charAt(lb) - '0' + c;
            c = x / 2;
            x = x % 2;
            sb.insert(0, x);
            la -= 1;
            lb -= 1;
        }
        while (la >= 0) {
            int x = a.charAt(la) - '0' + c;
            c = x / 2;
            x = x % 2;
            sb.insert(0, x);
            la -= 1;
        }
        while (lb >= 0) {
            int x = b.charAt(lb) - '0' + c;
            c = x / 2;
            x = x % 2;
            sb.insert(0, x);
            lb -= 1;
        }
        if (c != 0) {
            sb.insert(0, c);
        }
        return sb.toString();
    }
}
