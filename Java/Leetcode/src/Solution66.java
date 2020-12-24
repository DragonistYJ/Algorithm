import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
NO66 加一
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class Solution66 {
    public int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>(digits.length + 1);
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            carry = sum / 10;
            list.add(sum % 10);
        }
        if (carry == 1) list.add(1);
        int l = list.size();
        int[] ans = new int[l];
        for (int i = 0; i < l; i++) {
            ans[l - i - 1] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] x = {9, 9, 9};
        System.out.println(Arrays.toString(new Solution66().plusOne(x)));
    }
}
