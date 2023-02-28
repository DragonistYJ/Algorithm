import java.io.*;

/**
 * @author 11214
 * @since 2023/2/27 20:33
 */
public class Solution967A {
    private static class Segment {
        private final int l;
        private final int r;
        private Segment left;
        private Segment right;
        private long sum;

        public Segment(int l, int r) {
            this.l = l;
            this.r = r;
        }

        public static Segment build(long[] nums, int l, int r) {
            if (l == r) {
                Segment segment = new Segment(l, r);
                segment.sum = nums[l - 1];
                return segment;
            }
            int mid = (l + r) >> 1;
            Segment segment = new Segment(l, r);
            segment.left = build(nums, l, mid);
            segment.right = build(nums, mid + 1, r);
            segment.sum = segment.left.sum + segment.right.sum;
            return segment;
        }

        public static void add(Segment segment, int i, long x) {
            if (segment.l == segment.r) {
                if (segment.l == i) {
                    segment.sum += x;
                }
                return;
            }
            if (segment.l > i || segment.r < i) {
                return;
            }
            segment.sum += x;
            add(segment.left, i, x);
            add(segment.right, i, x);
        }

        public static long ask(Segment segment, int l, int r) {
            if (l <= segment.l && segment.r <= r) {
                return segment.sum;
            }
            if (segment.r < l || segment.l > r) {
                return 0;
            }
            long left = ask(segment.left, l, r);
            long right = ask(segment.right, l, r);
            return left + right;
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        st.nextToken();
        int n = (int) st.nval;
        st.nextToken();
        int m = (int) st.nval;
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            st.nextToken();
            nums[i] = (long) st.nval;
        }
        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        Segment root = Segment.build(nums, 1, n);
        for (int i = 0; i < m; i++) {
            st.nextToken();
            int type = (int) st.nval;
            st.nextToken();
            int x = (int) st.nval;
            st.nextToken();
            int y = (int) st.nval;
            if (type == 1) {
                Segment.add(root, x, y);
            } else {
                long ask = Segment.ask(root, x, y);
                writer.write(ask + "\n");
            }
        }
        writer.flush();
        writer.close();
    }
}
