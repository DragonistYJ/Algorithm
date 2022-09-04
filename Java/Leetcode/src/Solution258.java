/**
 * @author yujian
 * @since 2022/9/4 15:58
 * <p>
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
 */
public class Solution258 {
    public int addDigits(int num) {
        while (num >= 10) {
            int k = num;
            num = 0;
            while (k != 0) {
                num += k % 10;
                k /= 10;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new Solution258().addDigits(38));
    }
}
