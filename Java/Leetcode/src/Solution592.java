import java.util.ArrayList;
import java.util.List;

/*
NO592 分数加减运算
给定一个表示分数加减运算表达式的字符串，你需要返回一个字符串形式的计算结果。 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1。
 */
public class Solution592 {
    public String fractionAddition(String expression) {
        if (expression.length() == 0) return "0/1";
        String exp;
        if (expression.startsWith("-")) {
            exp = "0/1" + expression;
        } else {
            exp = "0/1+" + expression;
        }
        List<Long> numerators = new ArrayList<>();
        List<Long> denominators = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        int index = 0;
        while (index < exp.length()) {
            StringBuilder numerator = new StringBuilder();
            while (Character.isDigit(exp.charAt(index))) {
                numerator.append(exp.charAt(index));
                index += 1;
            }
            numerators.add(Long.valueOf(numerator.toString()));
            index += 1;
            StringBuilder denominator = new StringBuilder();
            while (index < exp.length() && Character.isDigit(exp.charAt(index))) {
                denominator.append(exp.charAt(index));
                index += 1;
            }
            denominators.add(Long.valueOf(denominator.toString()));
            if (index == exp.length()) break;
            ops.add(exp.charAt(index));
            index += 1;
        }

        long denominator = 1;
        for (Long aLong : denominators) {
            denominator *= aLong;
        }
        for (int i = 0; i < numerators.size(); i++) {
            numerators.set(i, numerators.get(i) * denominator / denominators.get(i));
        }
        long numerator = numerators.get(0);
        for (int i = 1; i < numerators.size(); i++) {
            if (ops.get(i - 1) == '-') numerator -= numerators.get(i);
            else numerator += numerators.get(i);
        }

        if (numerator == 0) return "0/1";
        long gcd = gcd(Math.abs(numerator), denominator);
        numerator /= gcd;
        denominator /= gcd;
        return numerator + "/" + denominator;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long c = a % b;
            a = b;
            b = c;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new Solution592().fractionAddition("1/3-1/2"));
    }
}
