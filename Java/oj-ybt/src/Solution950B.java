import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

/**
 * @author 11214
 * @since 2023/2/3 10:59
 */
public class Solution950B {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int) st.nval;
        int[] trees = new int[n];
        st.nextToken();
        int h = (int) st.nval;
        int[][] commands = new int[h][3];
        for (int i = 0; i < h; i++) {
            st.nextToken();
            commands[i][0] = (int) st.nval - 1;
            st.nextToken();
            commands[i][1] = (int) st.nval - 1;
            st.nextToken();
            commands[i][2] = (int) st.nval;
        }
        Arrays.sort(commands, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        int ans = 0;
        for (int[] command : commands) {
            int rangeSum = 0;
            for (int i = command[0]; i <= command[1]; i++) {
                rangeSum += trees[i];
            }
            if (rangeSum >= command[2]) {
                continue;
            }
            ans += command[2] - rangeSum;
            int i = command[1];
            while (rangeSum < command[2]) {
                if (trees[i] == 0) {
                    trees[i] = 1;
                    rangeSum += 1;
                    i -= 1;
                }
            }
        }
        System.out.println(ans);
    }
}
