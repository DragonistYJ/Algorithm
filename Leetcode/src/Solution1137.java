/**
 * @ClassName Solution1137
 * @Author 11214
 * @Date 2020/4/20
 * @Description TODO
 */
public class Solution1137 {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int a = 1;
        int b = 1;
        int c = 0;
        while (n > 2) {
            int d = a + b + c;
            c = b;
            b = a;
            a = d;
            n--;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1137().tribonacci(25));
    }
}
