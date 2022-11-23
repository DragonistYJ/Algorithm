import java.util.HashMap;

/**
 * @author 11214
 * @since 2022/11/23 11:04
 * <p>
 * 森林中有未知数量的兔子。提问其中若干只兔子 "还有多少只兔子与你（指被提问的兔子）颜色相同?" ，将答案收集到一个整数数组 answers 中，其中 answers[i] 是第 i 只兔子的回答。
 * 给你数组 answers ，返回森林中兔子的最少数量。
 */
public class Solution781 {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int answer : answers) {
            numMap.put(answer, numMap.getOrDefault(answer, 0) + 1);
        }
        int ans = 0;
        for (Integer num : numMap.keySet()) {
            ans += (num + 1) * Math.ceil(numMap.get(num) * 1.0 / (num + 1));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] answers = new int[]{1, 1, 1, 2, 2};
        System.out.println(new Solution781().numRabbits(answers));
    }
}
