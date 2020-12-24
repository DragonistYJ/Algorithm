import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/*
NO1106 解析布尔表达式
给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。
有效的表达式需遵循以下约定：
"t"，运算结果为 True
"f"，运算结果为 False
"!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT）
"&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND）
"|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR）
 */
public class Solution1106 {
    public boolean parseBoolExpr(String expression) {
        if (expression.equals("f")) return false;
        if (expression.equals("t")) return true;
        String replaceExp = expression.replaceAll(",", "");
        return parse(replaceExp);
    }

    private boolean parse(String exp) {
        if (exp.equals("f")) return false;
        if (exp.equals("t")) return true;

        int len = exp.length();
        if (exp.startsWith("!")) {
            return !parse(exp.substring(2, exp.length() - 1));
        } else {
            char c = exp.charAt(0);
            List<Boolean> answers = new ArrayList<>();
            Stack<Integer> left = new Stack<>();
            for (int i = 2; i < len - 1; i++) {
                if (exp.charAt(i) == '(') left.push(i);
                else if (exp.charAt(i) == ')') {
                    Integer pop = left.pop();
                    if (left.isEmpty()) answers.add(parse(exp.substring(pop - 1, i + 1)));
                }
            }
            if (answers.size() == 0) {
                for (int i = 2; i < len - 1; i++) {
                    answers.add(parse(exp.substring(i, i + 1)));
                }
            }

            boolean ans;
            if (c == '|') {
                ans = false;
                for (Boolean answer : answers) {
                    ans = ans | answer;
                }
            } else {
                ans = true;
                for (Boolean answer : answers) {
                    ans = ans & answer;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution1106().parseBoolExpr("|(&(t,t,t),!(t))"));
    }
}
