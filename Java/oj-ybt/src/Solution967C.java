import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;

/**
 * @author 11214
 * @since 2023/2/28 10:21
 */
public class Solution967C {
    private static class Segment {
        private final int l;
        private final int r;
        private Segment left;
        private Segment right;
        private long max = 0;

        public Segment(int l, int r) {
            this.l = l;
            this.r = r;
        }

        public static Segment build(int l, int r) {
            if (l == r) {
                return new Segment(l, r);
            }
            int mid = (l + r) >> 1;
            Segment segment = new Segment(l, r);
            segment.left = build(l, mid);
            segment.right = build(mid + 1, r);
            return segment;
        }

        public static void set(Segment segment, int i, long x) {
            if (i <= segment.l && segment.r <= i) {
                segment.max = x;
                return;
            }
            if (segment.l > i || segment.r < i) {
                return;
            }
            set(segment.left, i, x);
            set(segment.right, i, x);
            segment.max = Math.max(segment.left.max, segment.right.max);
        }

        public static long ask(Segment segment, int l, int r) {
            if (l <= segment.l && segment.r <= r) {
                return segment.max;
            }
            if (segment.r < l || segment.l > r) {
                return 0;
            }
            long left = ask(segment.left, l, r);
            long right = ask(segment.right, l, r);
            return Math.max(left, right);
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        st.nextToken();
        int n = (int) st.nval;
        st.nextToken();
        long p = (long) st.nval;
        Segment root = Segment.build(1, 200010);
        int idx = 0;
        long a = 0;
        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        for (int i = 0; i < n; i++) {
            st.nextToken();
            String type = st.sval;
            if (type.equals("A")) {
                st.nextToken();
                long t = (long) st.nval;
                t = (t + a) % p;
                idx += 1;
                Segment.set(root, idx, t);
            } else {
                st.nextToken();
                int t = (int) st.nval;
                a = Segment.ask(root, idx - t + 1, idx);
                writer.write(a + "\n");
            }
        }
        writer.flush();
        writer.close();
    }
}
