/*
No1342 5311 将数字变成0的操作次数
给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
 */
public class Solution1342 {
    public int numberOfSteps(int num) {
        int ans = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            ans += 1;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
