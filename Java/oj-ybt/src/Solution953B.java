import java.util.*;

/**
 * @author 11214
 * @since 2023/2/18 9:50
 */
public class Solution953B {
    private static final HashMap<Integer, String> visited = new HashMap<>();
    private static final ArrayDeque<Integer> queue = new ArrayDeque<>();

    public static void check(int[] arr, String status, String operation) {
        int sum = 0;
        for (int i = 0; i < 8; i++) {
            sum *= 10;
            sum += arr[i];
        }
        if (!visited.containsKey(sum)) {
            visited.put(sum, status + operation);
            queue.offer(sum);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aim = 0;
        for (int i = 0; i < 8; i++) {
            aim *= 10;
            aim += sc.nextInt();
        }

        int[] origin = new int[8];
        int[] a = new int[8];
        int[] b = new int[8];
        int[] c = new int[8];
        queue.offer(12345678);
        visited.put(12345678, "");
        while (!queue.isEmpty()) {
            int val = queue.poll();
            String status = visited.get(val);

            if (val == aim) {
                System.out.println(status.length());
                System.out.println(status);
                break;
            }

            for (int i = 0; i < 8; i++) {
                origin[7 - i] = val % 10;
                val /= 10;
            }

            System.arraycopy(origin, 0, a, 0, 8);
            for (int i = 0; i < 4; i++) {
                int k = a[i];
                a[i] = a[7 - i];
                a[7 - i] = k;
            }
            check(a, status, "A");

            System.arraycopy(origin, 0, b, 0, 8);
            int k = b[3];
            b[3] = b[2];
            b[2] = b[1];
            b[1] = b[0];
            b[0] = k;
            k = b[4];
            b[4] = b[5];
            b[5] = b[6];
            b[6] = b[7];
            b[7] = k;
            check(b, status, "B");

            System.arraycopy(origin, 0, c, 0, 8);
            k = c[1];
            c[1] = c[6];
            c[6] = c[5];
            c[5] = c[2];
            c[2] = k;
            check(c, status, "C");
        }
    }
}
