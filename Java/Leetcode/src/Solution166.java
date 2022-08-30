import java.util.HashMap;
import java.util.Map;

/**
 * @author 11214
 * @since 2022/8/29 10:31
 * 给定两个整数，分别表示分数的分子numerator 和分母 denominator，以字符串形式返回小数 。
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 * 如果存在多个答案，只需返回 任意一个 。
 * 对于所有给定的输入，保证 答案字符串的长度小于 104
 */
public class Solution166 {
    public String fractionToDecimal(int numerator, int denominator) {
        long n = numerator;
        long d = denominator;
        long integer = n / d;
        n -= integer * d;
        if (n == 0) {
            return String.valueOf(integer);
        }

        StringBuilder builder = new StringBuilder();
        if (n * d < 0) {
            builder.append("-");
        }
        integer = Math.abs(integer);
        n = Math.abs(n);
        d = Math.abs(d);
        builder.append(integer);
        builder.append(".");
        Map<Long, Integer> numeratorMap = new HashMap<>();
        numeratorMap.put(n, builder.length());
        int position = builder.length() + 1;
        while (n != 0) {
            n *= 10;
            integer = n / d;
            builder.append(integer);
            n -= integer * d;
            if (numeratorMap.containsKey(n)) {
                builder.insert(numeratorMap.get(n), "(");
                builder.append(")");
                break;
            } else {
                numeratorMap.put(n, position);
                position += 1;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution166 solution166 = new Solution166();
        System.out.println(solution166.fractionToDecimal(-1, -2147483648));
    }
}
