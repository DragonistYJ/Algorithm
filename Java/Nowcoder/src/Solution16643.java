import java.util.*;

/**
 * @author 11214
 * @since 2023/1/3 15:33
 */
public class Solution16643 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long x = scanner.nextLong();
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        List<Long> list = new ArrayList<>(map.keySet());
        list.sort((Long::compare));
        for (Long key : list) {
            System.out.println(key + " " + map.get(key));
        }
    }
}
