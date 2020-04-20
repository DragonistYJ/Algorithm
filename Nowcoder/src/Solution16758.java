import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName 单词接龙
 * @Author 11214
 * @Date 2020/4/3
 * @Description dfs
 */
public class Solution16758 {
    private static boolean[][] connectable;
    private static int[][] sameLen;
    private static int n;
    private static String[] words;
    private static int[] used;
    private static int ans;

    private static int check(String x, String y) {
        int len1 = x.length();
        int len2 = y.length();
        for (int i = 1; i < Math.min(len1, len2); i++) {
            boolean flag = true;
            for (int j = 0; j < i; j++) {
                if (x.charAt(len1 - i + j) != y.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) return i;
        }
        return 0;
    }

    private static void dfs(int lastIndex, int length) {
        if (length > ans) ans = length;
        for (int i = 0; i < n; i++) {
            if (used[i] == 2) continue;
            if (!connectable[lastIndex][i]) continue;
            used[i] += 1;
            dfs(i, length + words[i].length() - sameLen[lastIndex][i]);
            used[i] -= 1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        words = new String[n];
        connectable = new boolean[n][n];
        sameLen = new int[n][n];
        used = new int[n];
        ans = 0;
        for (int i = 0; i < n; i++) {
            words[i] = scanner.next();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int same = check(words[i], words[j]);
//                int len = Math.min(words[i].length(), words[j].length());
//                for (int k = 0; k < len; k++) {
//                    if (words[i].endsWith(words[j].substring(0, len - k))) {
//                        same = len - k;
//                        break;
//                    }
//                }
                if (same != 0) {
                    connectable[i][j] = true;
                    sameLen[i][j] = same;
                }
            }
        }
        String start = scanner.next();
        for (int i = 0; i < n; i++) {
            if (!words[i].startsWith(start)) continue;
            used[i] += 1;
            dfs(i, words[i].length());
            used[i] -= 1;
        }
        System.out.println(ans);
    }
}
