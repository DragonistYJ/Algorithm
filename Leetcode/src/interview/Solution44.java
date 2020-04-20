package interview;

/**
 * @ClassName Solution44
 * @Author 11214
 * @Date 2020/4/12
 * @Description TODO
 */
public class Solution44 {
    public int findNthDigit(int n) {
        if (n < 10) return n;
        long digits = 1;
        long base = 9;
        int m = n;
        while (m > base * digits) {
            m -= base * digits;
            base *= 10;
            digits += 1;
        }
        long number = 1;
        for (int i = 1; i < digits; i++) {
            number *= 10;
        }
        number += m / digits;
        long bit = m % digits;
        if (bit == 0) {
            bit = digits;
            number -= 1;
        }

        for (long i = bit; i < digits; i++) {
            number /= 10;
        }
        return (int)number % 10;
    }

    public static void main(String[] args) {
        System.out.println(new Solution44().findNthDigit(1000000000));
    }
}
