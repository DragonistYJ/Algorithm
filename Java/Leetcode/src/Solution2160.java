import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author 11214
 * @since 2022/11/20 10:16
 * <p>
 * 给你一个四位 正 整数 num 。请你使用 num 中的 数位 ，将 num 拆成两个新的整数 new1 和 new2 。new1 和 new2 中可以有 前导 0 ，且 num 中 所有 数位都必须使用。
 * <p>
 * 比方说，给你 num = 2932 ，你拥有的数位包括：两个 2 ，一个 9 和一个 3 。一些可能的 [new1, new2] 数对为 [22, 93]，[23, 92]，[223, 9] 和 [2, 329] 。
 * 请你返回可以得到的 new1 和 new2 的 最小 和。
 */
public class Solution2160 {
    public int minimumSum(int num) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            nums.add(num % 10);
            num = num / 10;
        }
        nums.sort(Comparator.comparingInt(o -> o));
        return nums.get(0) * 10 + nums.get(1) * 10 + nums.get(2) + nums.get(3);
    }

    public static void main(String[] args) {
        System.out.println(new Solution2160().minimumSum(2392));
    }
}
