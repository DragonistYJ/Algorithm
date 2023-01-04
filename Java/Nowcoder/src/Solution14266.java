import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author 11214
 * @since 2023/1/4 11:24
 */
public class Solution14266 {
    private static class Entry {
        private final int memory;
        private final int speed;

        public Entry(int memory, int speed) {
            this.memory = memory;
            this.speed = speed;
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer sc = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        sc.nextToken();
        int n = (int) sc.nval;
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sc.nextToken();
            int memory = (int) sc.nval;
            sc.nextToken();
            int speed = (int) sc.nval;
            Entry entry = new Entry(memory, speed);
            entries.add(entry);
        }
        entries.sort(Comparator.comparingInt(o -> o.memory));

        List<Integer> maxSpeeds = new ArrayList<>();
        maxSpeeds.add(0);
        for (int i = entries.size() - 2; i >= 0; i--) {
            maxSpeeds.add(Math.max(maxSpeeds.get(maxSpeeds.size() - 1), entries.get(i + 1).speed));
        }
        Collections.reverse(maxSpeeds);

        int ans = 0;
        for (int i = 0; i < maxSpeeds.size() - 1; i++) {
            if (entries.get(i).speed < maxSpeeds.get(i)) {
                ans += 1;
            }
        }
        System.out.println(ans);
    }
}
