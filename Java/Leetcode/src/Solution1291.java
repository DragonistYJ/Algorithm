import java.util.ArrayList;
import java.util.List;

/**
 * 顺次数
 * 我们定义「顺次数」为：每一位上的数字都比前一位上的数字大 1 的整数。
 * 请你返回由 [low, high] 范围内所有顺次数组成的 有序 列表（从小到大排序）。
 */
public class Solution1291 {
    private List<Integer> construct(int len) {
        List<Integer> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) builder.append(i);

        for (int i = len; i < 10; i++) {
            builder.deleteCharAt(0);
            builder.append(i);
            list.add(Integer.valueOf(builder.toString()));
        }

        return list;
    }

    public List<Integer> sequentialDigits(int low, int high) {
        int lowBits = 0;
        int t = low;
        while (t != 0) {
            lowBits += 1;
            t /= 10;
        }
        int highBits = 0;
        t = high;
        while (t != 0) {
            highBits += 1;
            t /= 10;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = lowBits; i <= highBits; i++) {
            list.addAll(construct(i));
        }

        list.removeIf(integer -> integer < low || integer > high);

        return list;
    }


    public static void main(String[] args) {
        System.out.println(new Solution1291().sequentialDigits(1000, 13000));
    }
}
