import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 11214
 * @since 2023/2/7 11:39
 */
public class Solution951C {
    private static int[][] coefficients;

    private static List<double[]> addRange(List<double[]> ranges, double[] range1, double[] range2) {
        List<double[]> temp = new ArrayList<>();
        if (range1 != null) {
            for (double[] range : ranges) {
                double left = Math.max(range[0], range1[0]);
                double right = Math.min(range[1], range1[1]);
                if (left < right) {
                    temp.add(new double[]{left, right});
                }
            }
        }
        if (range2 != null) {
            for (double[] range : ranges) {
                double left = Math.max(range[0], range2[0]);
                double right = Math.min(range[1], range2[1]);
                if (left < right) {
                    temp.add(new double[]{left, right});
                }
            }
        }
        return temp;
    }

    private static boolean check(double upper) {
        List<double[]> ranges = new ArrayList<>();
        ranges.add(new double[]{0, 1000});
        for (int[] coefficient : coefficients) {
            // 一次函数
            if (coefficient[0] == 0) {
                if (coefficient[1] == 0) {
                    if (coefficient[2] > upper) {
                        return false;
                    }
                } else {
                    double x = (upper - coefficient[2]) / coefficient[1];
                    if (coefficient[1] > 0) {
                        ranges = addRange(ranges, new double[]{0, x}, null);
                    } else {
                        ranges = addRange(ranges, new double[]{x, 1000}, null);
                    }
                }
            } else {
                // 二次函数
                double bb4ac = coefficient[1] * coefficient[1] - 4 * coefficient[0] * (coefficient[2] - upper);
                if (bb4ac < 0) {
                    // 无根
                    if (coefficient[0] > 0) {
                        return false;
                    }
                } else {
                    // 有根
                    double leftRoot = (-coefficient[1] - Math.sqrt(bb4ac)) / (2.0 * coefficient[0]);
                    double rightRoot = (-coefficient[1] + Math.sqrt(bb4ac)) / (2.0 * coefficient[0]);
                    if (coefficient[0] < 0) {
                        double[] range1 = leftRoot < 0 ? null : new double[]{0, leftRoot};
                        double[] range2 = rightRoot > 1000 ? null : new double[]{rightRoot, 1000};
                        ranges = addRange(ranges, range1, range2);
                    } else {
                        ranges = addRange(ranges, new double[]{leftRoot, rightRoot}, null);
                    }
                }
            }

            if (ranges.size() == 0) {
                return false;
            }
        }
        return ranges.size() != 0;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        st.nextToken();
        int t = (int) st.nval;
        while (t-- > 0) {
            // 输入
            st.nextToken();
            int n = (int) st.nval;
            coefficients = new int[n][3];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    st.nextToken();
                    coefficients[i][j] = (int) st.nval;
                }
            }

            // 找最大最小值
            double min = Integer.MAX_VALUE;
            double max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int[] coefficient = coefficients[i];
                min = Math.min(min, coefficient[2]);
                max = Math.max(max, coefficient[2]);
                double a = coefficient[0] * 1000000 + coefficient[1] * 1000 + coefficient[2];
                min = Math.min(min, a);
                max = Math.max(max, a);
                if (coefficient[0] != 0) {
                    a = (-coefficient[1] * 1.0) / (2.0 * coefficient[0]);
                    a = coefficient[0] * a * a + coefficient[1] * a + coefficient[2];
                    min = Math.min(min, a);
                    max = Math.max(max, a);
                }
            }

            while (max - min > 1e-5) {
                double mid = (min + max) / 2.0;
                if (check(mid)) {
                    max = mid;
                } else {
                    min = mid;
                }
            }
            BigDecimal decimal = new BigDecimal(min).setScale(4, RoundingMode.HALF_UP);
            System.out.println(decimal);
        }
    }
}
