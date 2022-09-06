/**
 * @author yujian
 * @since 2022/9/6 10:13
 * 给你一个下标从 0 开始的字符串 expression ，格式为 "<num1>+<num2>" ，其中 <num1> 和 <num2> 表示正整数。
 * 请你向 expression 中添加一对括号，使得在添加之后， expression仍然是一个有效的数学表达式，并且计算后可以得到最小可能值。
 * 左括号 必须 添加在 '+' 的左侧，而右括号必须添加在 '+' 的右侧。
 * 返回添加一对括号后形成的表达式expression，且满足expression计算得到最小可能值。如果存在多个答案都能产生相同结果，返回任意一个答案。
 * 生成的输入满足：expression 的原始值和添加满足要求的任一对括号之后 expression 的值，都符合 32-bit 带符号整数范围。
 */
public class Solution2232 {
    public String minimizeResult(String expression) {
        int add = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+') {
                add = i;
                break;
            }
        }
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        String a = expression.substring(0, add);
        String b = expression.substring(add + 1);
        for (int i = 0; i < a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                int al = -1;
                int ar;
                if (i != 0) {
                    al = Integer.parseInt(a.substring(0, i));
                }
                ar = Integer.parseInt(a.substring(i));
                int bl;
                int br = -1;
                bl = Integer.parseInt(b.substring(0, j));
                if (j != b.length()) {
                    br = Integer.parseInt(b.substring(j));
                }

                int ans = ar + bl;
                if (al != -1) {
                    ans *= al;
                }
                if (br != -1) {
                    ans *= br;
                }
                if (ans < min) {
                    min = ans;
                    left = i;
                    right = j;
                }
            }
        }
        right += a.length() + 1;
        return expression.substring(0, left) + "(" + expression.substring(left, right) + ")" + expression.substring(right);
    }

    public static void main(String[] args) {
        System.out.println(new Solution2232().minimizeResult("12+30"));
    }
}
