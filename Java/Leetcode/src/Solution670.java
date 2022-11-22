import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 11214
 * @since 2022/11/22 10:06
 * <p>
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 */
public class Solution670 {
    public int maximumSwap(int num) {
        List<Integer> list = new ArrayList<>();
        while (num != 0) {
            list.add(num % 10);
            num /= 10;
        }
        Collections.reverse(list);

        for (int i = 0; i < list.size() - 1; i++) {
            int k = i;
            int max = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) > max) {
                    max = list.get(j);
                    k = j;
                }
            }
            if (list.get(i) != max) {
                int temp = list.get(i);
                list.set(i, list.get(k));
                list.set(k, temp);
                break;
            }
        }

        int ans = 0;
        for (Integer integer : list) {
            ans = ans * 10 + integer;
        }
        return ans;
    }
}
