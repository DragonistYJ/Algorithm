/*
NO67 二进制和
给定两个二进制字符串，返回他们的和（用二进制表示）。
输入为非空字符串且只包含数字 1 和 0。
 */
public class Solution67 {
    public String addBinary(String a, String b) {
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 && j >= 0) {
            int sum = a.charAt(i) - '0' + b.charAt(j) - '0' + carry;
            carry = sum / 2;
            ans.append(sum % 2);
            i -= 1;
            j -= 1;
        }
        while (i >= 0) {
            int sum = a.charAt(i) - '0' + carry;
            carry = sum / 2;
            ans.append(sum % 2);
            i -= 1;
        }
        while (j >= 0) {
            int sum = b.charAt(j) - '0' + carry;
            carry = sum / 2;
            ans.append(sum % 2);
            j -= 1;
        }
        if (carry == 1) ans.append(1);
        ans.reverse();

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution67().addBinary("1010", "1011"));
    }
}
