import java.util.ArrayDeque;

/**
 * @author 11214
 * @since 2023/3/31 14:54
 */
public class Solution36 {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (String token : tokens) {
            if (Character.isDigit(token.charAt(token.length() - 1))) {
                deque.offerLast(Integer.valueOf(token));
            } else {
                Integer b = deque.pollLast();
                Integer a = deque.pollLast();
                switch (token) {
                    case "+":
                        deque.offerLast(a + b);
                        break;
                    case "-":
                        deque.offerLast(a - b);
                        break;
                    case "*":
                        deque.offerLast(a * b);
                        break;
                    case "/":
                        deque.offerLast(a / b);
                }
            }
        }
        return deque.pollLast();
    }

    public static void main(String[] args) {
        System.out.println(new Solution36().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
