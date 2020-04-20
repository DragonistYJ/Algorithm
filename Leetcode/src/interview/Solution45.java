package interview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName Solution45
 * @Author 11214
 * @Date 2020/4/12
 * @Description TODO
 */
public class Solution45 {
    public String minNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        list.sort((o1, o2) -> {
            String s1 = o1 + o2;
            String s2 = o2 + o1;
            return s1.compareTo(s2);
        });
        StringBuilder builder = new StringBuilder();
        for (String s : list) {
            builder.append(s);
        }
        return builder.toString();
    }
}
