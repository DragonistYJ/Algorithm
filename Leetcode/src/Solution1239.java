import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Solution1239
 * @Author 11214
 * @Date 2020/6/5
 * @Description 串联字符串的最大长度
 * 给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。
 * 请返回所有可行解 s 中最长长度。
 */
public class Solution1239 {
    private int max = 0;

    private int bits(int x) {
        int sum = 0;
        while (x != 0) {
            if ((x & 1) == 1) sum += 1;
            x = x >> 1;
        }
        return sum;
    }

    private void dfs(List<Integer> numbers, int temp, int index) {
        if (bits(temp) > bits(max)) max = temp;
        for (int i = index; i < numbers.size(); i++) {
            if ((numbers.get(i) & temp) == 0) {
                dfs(numbers, numbers.get(i) | temp, i + 1);
            }
        }
    }

    public int maxLength(List<String> arr) {
        int n = arr.size();
        List<Integer> numbers = new ArrayList<>();
        for (String value : arr) {
            int bit = 0;
            boolean flag = true;
            for (int j = 0; j < value.length(); j++) {
                int temp = 1 << (value.charAt(j) - 'a');
                if ((bit & temp) != 0) {
                    flag = false;
                    break;
                }
                bit = bit | temp;
            }
            if (flag) numbers.add(bit);
        }
        dfs(numbers, 0, 0);
        return bits(max);
    }

    public static void main(String[] args) {
        String[] strings = {"yy", "r", "xxx", "ers"};
        List<String> list = new ArrayList<>(Arrays.asList(strings));
        System.out.println(new Solution1239().maxLength(list));
    }
}
