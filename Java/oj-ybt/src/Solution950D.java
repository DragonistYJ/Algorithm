import java.io.*;
import java.util.*;

/**
 * @author 11214
 * @since 2023/2/2 14:31
 */
public class Solution950D {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int) st.nval;
        long[][] times = new long[n][4];
        for (int i = 0; i < n; i++) {
            st.nextToken();
            times[i][0] = (long) st.nval;
        }
        for (int i = 0; i < n; i++) {
            st.nextToken();
            times[i][1] = (long) st.nval;
        }
        for (int i = 0; i < n; i++) {
            times[i][2] = times[i][0] - times[i][1] < 0 ? -1 : 1;
            times[i][3] = i + 1;
        }
        Arrays.sort(times, ((o1, o2) -> {
            if (o1[2] != o2[2]) {
                return Long.compare(o1[2], o2[2]);
            } else {
                if (o1[2] == -1) {
                    return Long.compare(o1[0], o2[0]);
                } else {
                    return Long.compare(o2[1], o1[1]);
                }
            }
        }));

        long m1 = 0;
        long m2 = 0;
        for (long[] time : times) {
            m1 += time[0];
            if (m1 >= m2) {
                m2 = m1 + time[1];
            } else {
                m2 += time[1];
            }
        }

        System.out.println(Math.max(m1, m2));
        for (int i = 0; i < times.length; i++) {
            System.out.print(times[i][3]);
            if (i != times.length - 1) {
                System.out.print(" ");
            }
        }
    }
}
