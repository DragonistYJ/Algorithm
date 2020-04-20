import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName 选择困难症
 * @Author 11214
 * @Date 2020/4/3
 * @Description DFS
 */
public class Solution13594 {
    private static List<List<Long>> things;
    private static long m;
    private static int n;
    private static long ans;

    private static void dfs(long sum, int step) {
        if (step == n) {
            if (sum > m) ans += 1;
            return;
        }
        if (sum > m) {
            long tmp = 1;
            for (int i = step; i < n; i++) {
                tmp = tmp * (things.get(i).size() + 1);
            }
            ans += tmp;
            return;
        }
        for (int i = 0; i < things.get(step).size(); i++) {
            dfs(sum + things.get(step).get(i), step + 1);
        }
        dfs(sum, step + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        things = new ArrayList<>();
        while (scanner.hasNext()) {
            things.clear();
            ans = 0;
            n = scanner.nextInt();
            m = scanner.nextLong();
            for (int i = 0; i < n; i++) {
                List<Long> list = new ArrayList<>();
                int a = scanner.nextInt();
                for (int j = 0; j < a; j++) {
                    list.add(scanner.nextLong());
                }
                things.add(list);
            }
            dfs(0, 0);
            System.out.println(ans);
        }
    }
}
