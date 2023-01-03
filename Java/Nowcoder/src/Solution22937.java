import java.util.*;

/**
 * @author 11214
 * @since 2023/1/3 15:02
 */
public class Solution22937 {
    private static class Entry {
        private final int value;
        private final int cost;

        public Entry(int value, int cost) {
            this.value = value;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int time = scanner.nextInt();
        int n = scanner.nextInt();
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            entries.add(new Entry(scanner.nextInt(), scanner.nextInt()));
        }
        int[] dp = new int[10010];
        for (Entry entry : entries) {
            for (int i = entry.cost; i <= time; i++) {
                dp[i] = Math.max(dp[i], dp[i - entry.cost] + entry.value);
            }
        }
        System.out.println(dp[time]);
    }
}
