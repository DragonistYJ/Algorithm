import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author: YuJian
 * @Datetime: 2020/8/15 12:00
 * @Description 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。
 * 格雷编码序列必须以 0 开头。
 */
public class Solution89 {
    private List<Integer> ans;

    private void dfs(List<Integer> path, StringBuilder builder, HashSet<Integer> used, int num) {
        if (ans != null) return;
        if (path.size() == num) {
            ans = new ArrayList<>(path);
            return;
        }

        for (int i = builder.length() - 1; i >= 0; i--) {
            char c = builder.charAt(i);
            builder.setCharAt(i, c == '0' ? '1' : '0');
            Integer integer = Integer.valueOf(builder.toString(), 2);
            if (!used.contains(integer)) {
                used.add(integer);
                path.add(integer);
                dfs(path, builder, used, num);
                path.remove(path.size() - 1);
                used.remove(integer);
            }
            builder.setCharAt(i, c);
        }
    }

    public List<Integer> grayCode(int n) {
        List<Integer> path = new ArrayList<>();
        path.add(0);
        HashSet<Integer> used = new HashSet<>();
        used.add(0);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(0);
        }
        dfs(path, builder, used, BigInteger.valueOf(2).pow(n).intValue());
        return ans;
    }
}
