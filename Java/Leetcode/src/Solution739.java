import java.util.Arrays;
import java.util.Stack;

/**
 * @ClassName Solution739
 * @Author 11214
 * @Date 2020/6/1
 * @Description TODO
 */
public class Solution739 {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        Stack<Integer> temperature = new Stack<>();
        Stack<Integer> index = new Stack<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (temperature.isEmpty()) {
                temperature.push(T[i]);
                index.push(i);
            } else if (T[i] <= temperature.peek()) {
                temperature.push(T[i]);
                index.push(i);
            } else {
                while (!temperature.isEmpty() && T[i] > temperature.peek()) {
                    ans[index.peek()] = i - index.peek();
                    temperature.pop();
                    index.pop();
                }
                temperature.push(T[i]);
                index.push(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(new Solution739().dailyTemperatures(T)));
    }
}
