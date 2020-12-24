import java.util.ArrayList;
import java.util.List;

/*
NO43 字符串相乘
给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 */
public class Solution43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int len1 = num1.length();
        List<Integer> list1 = new ArrayList<>();
        for (int i = len1 - 1; i >= 0; i--) {
            list1.add(num1.charAt(i) - '0');
        }
        int len2 = num2.length();
        List<Integer> list2 = new ArrayList<>();
        for (int i = len2 - 1; i >= 0; i--) {
            list2.add(num2.charAt(i) - '0');
        }
        List<Integer> list3 = new ArrayList<>();
        for (int i = 0; i < len1 + len2; i++) {
            list3.add(0);
        }
        for (int i = 0; i < len1; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                tmp.add(0);
            }
            int carry = 0;
            for (int j = 0; j < len2; j++) {
                int mul = list1.get(i) * list2.get(j) + carry;
                tmp.add(mul % 10);
                carry = mul / 10;
            }
            if (carry != 0) tmp.add(carry);
            carry = 0;
            for (int j = 0; j < tmp.size(); j++) {
                int add = list3.get(j) + tmp.get(j) + carry;
                list3.set(j, add % 10);
                carry = add / 10;
            }
            if (carry != 0) list3.set(tmp.size(), list3.get(tmp.size()) + carry);
        }

        while (list3.get(list3.size() - 1) == 0) list3.remove(list3.size() - 1);
        if (list3.get(list3.size() - 1) >= 10) {
            list3.set(list3.size() - 1, list3.get(list3.size() - 1) - 10);
            list3.add(1);
        }
        StringBuilder builder = new StringBuilder();
        for (int i = list3.size() - 1; i >= 0; i--) {
            builder.append(list3.get(i));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution43().multiply("0", "0"));
    }
}
