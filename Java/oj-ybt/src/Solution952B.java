import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author 11214
 * @since 2023/2/15 10:10
 */
public class Solution952B {
    private static int ans = Integer.MAX_VALUE;
    private static int m;

    public static void dfs(int preR, int preH, int remind, int step, int area) {
        if (area > ans) {
            return;
        }
        if (step == 0) {
            ans = area;
            return;
        }

        int minV = (int) Math.ceil(1.0 * remind / step);
        for (int r = step; r <= Math.min(preR - 1, remind); r++) {
            int minH = (int) Math.ceil(1.0 * minV / (r * r));
            if (step == 1) {
                if (minH * r * r == remind && minH < preH) {
                    int a = 2 * r * minH;
                    // 只有一层
                    if (step == m) {
                        a += r * r;
                    }
                    dfs(r, minH, remind - minH, 0, area + a);
                }
            } else {
                for (int h = Math.max(minH, step); h <= Math.min(preH - 1, remind); h++) {
                    int v = r * r * h;
                    if (v >= remind) {
                        continue;
                    }
                    int a = 2 * r * h;
                    if (step == m) {
                        a += r * r;
                    }
                    dfs(r, h, remind - v, step - 1, area + a);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        st.nextToken();
        int n = (int) st.nval;
        st.nextToken();
        m = (int) st.nval;
        dfs(Integer.MAX_VALUE, Integer.MAX_VALUE, n, m, 0);
        System.out.println(ans);
    }
}
