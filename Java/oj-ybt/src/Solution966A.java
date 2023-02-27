import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;

/**
 * @author 11214
 * @since 2023/2/27 10:13
 */
public class Solution966A {
    private static long[] nums;

    private static class Segment {
        private final int l;
        private final int r;
        private Segment left;
        private Segment right;
        private long max;

        public Segment(int l, int r) {
            this.l = l;
            this.r = r;
        }

        public static Segment build(int l, int r) {
            if (l == r) {
                Segment segment = new Segment(l, r);
                segment.max = nums[l - 1];
                return segment;
            }
            int mid = (l + r) >> 1;
            Segment segment = new Segment(l, r);
            segment.left = build(l, mid);
            segment.right = build(mid + 1, r);
            segment.max = Math.max(segment.left.max, segment.right.max);
            return segment;
        }

        public static long ask(Segment segment, int l, int r) {
            if (l <= segment.l && segment.r <= r) {
                return segment.max;
            }
            if (segment.r < l || segment.l > r) {
                return Long.MIN_VALUE;
            }
            long left = ask(segment.left, l, r);
            long right = ask(segment.right, l, r);
            return Math.max(left, right);
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        OutputStreamWriter writer = new OutputStreamWriter(System.out);

        st.nextToken();
        int n = (int) st.nval;
        st.nextToken();
        int m = (int) st.nval;

        nums = new long[n];
        for (int i = 0; i < n; i++) {
            st.nextToken();
            nums[i] = (long) st.nval;
        }
        Segment root = Segment.build(1, n);
        for (int i = 0; i < m; i++) {
            st.nextToken();
            int l = (int) st.nval;
            st.nextToken();
            int r = (int) st.nval;
            long max = Segment.ask(root, l, r);
            writer.write(max + "\n");
        }
        writer.flush();
        writer.close();
    }
}
