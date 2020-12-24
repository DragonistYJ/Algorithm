package interview;

/**
 * @ClassName Solution46
 * @Author 11214
 * @Date 2020/4/13
 * @Description TODO
 */
public class Solution46 {
    public int translateNum(int num) {
        if (num <= 9) return 1;
        if (num <= 25) return 2;
        if (num <= 99) return 1;

        String number = String.valueOf(num);
        int a = number.charAt(0) - '0';
        int b = number.charAt(1) - '0';
        if (a > 2 || (a == 2 && b >= 6) || a == 0)
            return translateNum(Integer.parseInt(number.substring(1)));
        else
            return translateNum(Integer.parseInt(number.substring(1))) + translateNum(Integer.parseInt(number.substring(2)));
    }

    public static void main(String[] args) {
        System.out.println(new Solution46().translateNum(12258));
    }
}
