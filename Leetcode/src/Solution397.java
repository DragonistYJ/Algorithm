import java.util.HashMap;

/**
 * @ClassName Solution397
 * @Author 11214
 * @Date 2020/6/5
 * @Description 整数替换
 * 给定一个正整数 n，你可以做如下操作：
 * 1. 如果 n 是偶数，则用 n / 2替换 n。
 * 2. 如果 n 是奇数，则可以用 n + 1或n - 1替换 n。
 * n 变为 1 所需的最小替换次数是多少？
 */
public class Solution397 {
    private long recursion(long n, HashMap<Long, Long> memory) {
        long t;
        if (n % 2 == 0) {
            if (memory.containsKey(n / 2)) {
                t = memory.get(n / 2) + 1;
            } else {
                t = recursion(n / 2, memory) + 1;
            }
        } else {
            long add;
            if (memory.containsKey(n + 1)) {
                add = memory.get(n + 1) + 1;
            } else {
                add = recursion(n + 1, memory) + 1;
            }
            long sub;
            if (memory.containsKey(n - 1)) {
                sub = memory.get(n - 1) + 1;
            } else {
                sub = recursion(n - 1, memory) + 1;
            }
            t = Math.min(add, sub);
        }
        memory.put(n, t);
        return t;
    }

    public int integerReplacement(int n) {
        HashMap<Long, Long> memory = new HashMap<>();
        memory.put(1L, 0L);
        memory.put(2L, 1L);
        memory.put(3L, 2L);
        memory.put(4L, 2L);
        if (n <= 4) return Math.toIntExact(memory.get((long) n));
        return (int) recursion(n, memory);
    }

    public static void main(String[] args) {
        System.out.println(new Solution397().integerReplacement(2147483647));
    }
}
