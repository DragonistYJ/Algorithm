import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 为运算表达式设计优先级
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 */
public class Solution241 {
    private List<Integer> numList;
    private List<Character> operatorList;
    private ArrayList[][] memo;

    private int calc(int num1, int num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            default:
                return num1 * num2;
        }
    }

    private List<Integer> rec(int start, int end) {
        if (memo[start][end] != null) {
            return memo[start][end];
        }

        if (start == end) {
            memo[start][end] = new ArrayList<>(Collections.singleton(numList.get(start)));
            return memo[start][end];
        }

        ArrayList ansList = new ArrayList<>();
        for (int i = start; i < end; i++) {
            List<Integer> leftList = rec(start, i);
            List<Integer> rightList = rec(i + 1, end);
            for (Integer leftNum : leftList) {
                for (Integer rightNum : rightList) {
                    ansList.add(calc(leftNum, rightNum, operatorList.get(i)));
                }
            }
        }

        memo[start][end] = ansList;
        return ansList;
    }

    // 拆分成数字和运算符两个数组
    private void splitString(String str) {
        numList = new ArrayList<>();
        operatorList = new ArrayList<>();
        int num = 0;
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                numList.add(num);
                operatorList.add(c);
                num = 0;
            } else {
                num *= 10;
                num += c - '0';
            }
        }

        numList.add(num);
    }

    public List<Integer> diffWaysToCompute(String input) {
        splitString(input);
        int len = numList.size();
        memo = new ArrayList[len][len];
        return rec(0, len - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution241().diffWaysToCompute("2*3-4*5"));
    }
}
