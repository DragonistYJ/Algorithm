import java.util.*;

/**
 * @author 11214
 * @since 2023/1/6 15:00
 */
public class Solution16706 {
    private static int n;
    private static int k;
    private static int[] nums;
    private static boolean[] visited;
    private static HashMap<Integer, Integer> result;

    public static void dfs(int idx, int sum, int step) {
        if (step == k) {
            result.put(sum, result.getOrDefault(sum, 0) + 1);
            return;
        }
        for (int i = idx; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, sum + nums[i], step + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        nums = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        result = new HashMap<>();
        dfs(0, 0, 0);
        int max = 0;
        for (Integer integer : result.keySet()) {
            max = Math.max(integer, max);
        }
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        for (int i = 3; i <= Math.sqrt(max) + 1; i++) {
            boolean flag = true;
            for (Integer prime : primes) {
                if (i % prime == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                primes.add(i);
            }
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> kv : result.entrySet()) {
            int k = kv.getKey();
            boolean flag = true;
            for (Integer prime : primes) {
                if (prime > Math.sqrt(k)) {
                    break;
                }
                if (k % prime == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans += kv.getValue();
            }
        }
        System.out.println(ans);
    }
}
