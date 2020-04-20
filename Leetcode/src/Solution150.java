import java.util.Stack;

/*
150 逆波兰表达式求值
根据逆波兰表示法，求表达式的值。
有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
说明：
整数除法只保留整数部分。
给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 */
public class Solution150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            Integer integer1;
            Integer integer2;
            switch (token) {
                case "+":
                    integer1 = stack.pop();
                    integer2 = stack.pop();
                    stack.push(integer1 + integer2);
                    break;
                case "-":
                    integer1 = stack.pop();
                    integer2 = stack.pop();
                    stack.push(integer2 - integer1);
                    break;
                case "*":
                    integer1 = stack.pop();
                    integer2 = stack.pop();
                    stack.push(integer1 * integer2);
                    break;
                case "/":
                    integer1 = stack.pop();
                    integer2 = stack.pop();
                    stack.push(integer2 / integer1);
                    break;
                default:
                    stack.push(Integer.valueOf(token));
                    break;
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String[] s = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new Solution150().evalRPN(s));
    }
}
