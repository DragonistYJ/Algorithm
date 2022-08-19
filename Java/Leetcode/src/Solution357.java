import java.util.ArrayList;
import java.util.List;

/**
 * @author 11214
 * @since 2022/8/19 15:00
 * 357. 统计各位数字都不同的数字个数
 * 给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10^n。
 */
public class Solution357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 10;
        }

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(9);
        for (int i = 1; i < n; i++) {
            numbers.add(numbers.get(numbers.size() - 1) * (10 - i));
        }

        return numbers.stream().reduce(Integer::sum).get();
    }

    public static void main(String[] args) {
        Solution357 solution357 = new Solution357();
        System.out.println(solution357.countNumbersWithUniqueDigits(3));
    }
}
