import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 11214
 * @since 2022/11/21 10:11
 * <p>
 * 当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
 * 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
 */
public class Solution738 {
    private List<Integer> find(List<Integer> list) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1 || list.get(i) <= list.get(i + 1)) {
                ans.add(list.get(i));
            } else {
                ans.add(list.get(i) - 1);
                for (int j = i + 1; j < list.size(); j++) {
                    ans.add(9);
                }
                break;
            }
        }
        return ans;
    }

    private boolean check(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public int monotoneIncreasingDigits(int n) {
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(n % 10);
            n = n / 10;
        }
        Collections.reverse(list);

        while (!check(list)) {
            list = find(list);
        }

        int res = 0;
        for (Integer an : list) {
            res = res * 10 + an;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution738().monotoneIncreasingDigits(770));
    }
}
