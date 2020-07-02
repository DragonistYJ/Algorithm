import java.util.HashMap;
import java.util.HashSet;

/**
 * 优美的排列
 * 假设有从 1 到 N 的 N 个整数，如果从这 N 个数字中成功构造出一个数组，使得数组的第 i 位 (1 <= i <= N) 满足如下两个条件中的一个，我们就称这个数组为一个优美的排列。条件：
 * 第 i 位的数字能被 i 整除
 * i 能被第 i 位上的数字整除
 * 现在给定一个整数 N，请问可以构造多少个优美的排列？
 */
public class Solution526 {
    private int dfs(int index, int N, HashSet<Integer> used, HashMap<String, Integer> memory) {
        String s = used.toString();
        if (memory.containsKey(s)) return memory.get(s);

        if (used.size() == N) return 1;

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if (!used.contains(i) && (index % i == 0 || i % index == 0)) {
                used.add(i);
                sum += dfs(index + 1, N, used, memory);
                used.remove(i);
            }
        }
        memory.put(s, sum);
        return sum;
    }

    public int countArrangement(int N) {
        return dfs(1, N, new HashSet<>(), new HashMap<>());
    }

    public static void main(String[] args) {
        System.out.println(new Solution526().countArrangement(15));
    }
}
