package competition.week324;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author yujian
 * @since 2022/12/18 11:07
 */
public class Solution6268 {
    private int commonFather(int a, int b) {
        HashSet<Integer> fathers = new HashSet<>();
        fathers.add(a);
        while (a != 1) {
            if (a % 2 == 1) {
                a -= 1;
            }
            fathers.add(a / 2);
            a /= 2;
        }
        while (!fathers.contains(b)) {
            if (b % 2 == 1) {
                b -= 1;
            }
            b /= 2;
        }
        return b;
    }

    private int pathLen(int a, int root) {
        int len = 0;
        while (a != root) {
            if (a % 2 == 1) {
                a -= 1;
            }
            a /= 2;
            len += 1;
        }
        return len;
    }

    public int[] cycleLengthQueries(int n, int[][] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int a = query[0];
            int b = query[1];
            int commonFather = commonFather(a, b);
            int lenA = pathLen(a, commonFather);
            int lenB = pathLen(b, commonFather);
            ans[i] = lenA + lenB + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] queries = new int[][]{{3, 13}};
        System.out.println(Arrays.toString(new Solution6268().cycleLengthQueries(4, queries)));
    }
}
