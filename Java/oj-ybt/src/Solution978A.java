import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 11214
 * @since 2023/3/4 16:53
 */
public class Solution978A {
    private static final boolean[] shift = new boolean[50000];
    private static final long[] primes = new long[50000];
    private static int primeCount = 0;

    private static void prepare() {
        double upper = Math.sqrt(Math.pow(2, 31));
        for (int i = 2; i <= upper; i++) {
            if (!shift[i]) {
                primes[primeCount] = i;
                primeCount += 1;
            }
            for (int j = 0; primes[j] * i <= upper; j++) {
                shift[(int) (primes[j] * i)] = true;
                if (i % primes[j] == 0) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        prepare();

        boolean[] nums;
        long[] mins = new long[2];
        long[] maxs = new long[2];
        List<Long> list = new ArrayList<>(100000);
        while (st.nextToken() != StreamTokenizer.TT_EOF) {
            long left = (long) st.nval;
            st.nextToken();
            long right = (long) st.nval;
            int count = (int) (right - left + 1);
            nums = new boolean[count];
            for (int i = 0; i < primeCount && i <= right; i++) {
                long prime = primes[i];
                long lower = (long) Math.ceil(1.0 * left / prime);
                long upper = right / prime;
                for (long j = Math.max(2, lower); j <= upper; j++) {
                    nums[(int) (j * prime - left)] = true;
                }
            }
            list.clear();
            for (int i = 0; i < count; i++) {
                if (!nums[i]) {
                    list.add(i + left);
                }
            }

            if (list.size() < 2) {
                System.out.println("There are no adjacent primes.");
                continue;
            }

            long min = Integer.MAX_VALUE;
            long max = Integer.MIN_VALUE;
            for (int i = 0; i < list.size() - 1; i++) {
                long diff = list.get(i + 1) - list.get(i);
                if (diff < min) {
                    min = diff;
                    mins[0] = list.get(i);
                    mins[1] = list.get(i + 1);
                }
                if (diff > max) {
                    max = diff;
                    maxs[0] = list.get(i);
                    maxs[1] = list.get(i + 1);
                }
            }
            System.out.println(mins[0] + "," + mins[1] + " are closest, " + maxs[0] + "," + maxs[1] + " are most distant.");
        }
    }
}
