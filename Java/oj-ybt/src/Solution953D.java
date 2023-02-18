import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author 11214
 * @since 2023/2/18 10:26
 */
public class Solution953D {
    public static void main(String[] args) {
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Scanner sc = new Scanner(System.in);
        StringBuilder start = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            start.append(sc.next());
        }
        StringBuilder end = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            end.append(sc.next());
        }
        String aim = end.toString();

        HashMap<String, Integer> map = new HashMap<>();
        ArrayDeque<StringBuilder> queue = new ArrayDeque<>();
        queue.offer(start);
        map.put(start.toString(), 0);
        while (!queue.isEmpty()) {
            StringBuilder sb = queue.poll();
            String s = sb.toString();
            Integer step = map.get(s);
            if (s.equals(aim)) {
                System.out.println(step);
                break;
            }

            for (int i = 0; i < 16; i++) {
                int x = i / 4;
                int y = i % 4;
                for (int[] direction : directions) {
                    int xx = x + direction[0];
                    int yy = y + direction[1];
                    int j = xx * 4 + yy;
                    if (xx >= 0 && xx < 4 && yy >= 0 && yy < 4 && sb.charAt(i) != sb.charAt(j)) {
                        StringBuilder builder = new StringBuilder(sb);
                        char c = builder.charAt(i);
                        builder.setCharAt(i, builder.charAt(j));
                        builder.setCharAt(j, c);
                        String string = builder.toString();
                        if (!map.containsKey(string)) {
                            map.put(string, step + 1);
                            queue.offer(builder);
                        }
                    }
                }
            }
        }
    }
}
