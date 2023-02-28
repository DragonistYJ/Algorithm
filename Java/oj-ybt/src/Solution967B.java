import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;

/**
 * @author 11214
 * @since 2023/2/27 20:48
 */
public class Solution967B {
    private static class Segment {
        private final int l;
        private final int r;
        private Segment left;
        private Segment right;
        private long sum;
        private long lazy;

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


        public static void pushDown(Segment segment) {
            if (segment.lazy != 0) {
                segment.left.lazy += segment.lazy;
                segment.left.sum += (segment.left.r - segment.left.l + 1) * segment.lazy;
                segment.right.lazy += segment.lazy;
                segment.right.sum += (segment.right.r - segment.right.l + 1) * segment.lazy;
                segment.lazy = 0;
            }
        }

        public static void add(Segment segment, int l, int r, long x) {
            if (l <= segment.l && segment.r <= r) {
                segment.sum += (segment.r - segment.l + 1) * x;
                if (segment.left != null && segment.right != null) {
                    segment.lazy += x;
                }
                return;
            }
            if (segment.l > r || segment.r < l) {
                return;
            }
            pushDown(segment);
            add(segment.left, l, r, x);
            add(segment.right, l, r, x);
            segment.sum = segment.left.sum + segment.right.sum;
        }

        public static long ask(Segment segment, int l, int r) {
            if (l <= segment.l && segment.r <= r) {
                return segment.sum;
            }
            if (segment.r < l || segment.l > r) {
                return 0;
            }
            pushDown(segment);
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
        Segment root = Segment.build(nums, 1, n);
        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        for (int i = 0; i < m; i++) {
            st.nextToken();
            int type = (int) st.nval;
            st.nextToken();
            int l = (int) st.nval;
            st.nextToken();
            int r = (int) st.nval;
            if (type == 1) {
                st.nextToken();
                long x = (long) st.nval;
                Segment.add(root, l, r, x);
            } else {
                long ask = Segment.ask(root, l, r);
                writer.write(ask + "\n");
            }
        }
        writer.flush();
        writer.close();
    }
}
