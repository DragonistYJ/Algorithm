package xiaobai.month63;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @author yujian
 * @since 2022/12/16 20:21
 */
public class SolutionC {
    private static int n = 0;
    private static int WIN = 0;
    private static int LOSS = 0;
    private static int DRAW = 0;
    private static HashSet<String> exist;

    public static void check(List<Integer> ds, List<Integer> ys) {
        int win = 0;
        int loss = 0;
        for (int i = 0; i < n; i++) {
            if (ds.get(i) < ys.get(i)) {
                loss += 1;
            } else if (ds.get(i) > ys.get(i)) {
                win += 1;
            }
        }
        if (win > loss) {
            WIN += 1;
        } else if (win < loss) {
            LOSS += 1;
        } else {
            DRAW += 1;
        }
    }

    public static void dfs(List<Integer> ds, List<Integer> ys) {
        check(ds, ys);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ys.get(i).equals(ys.get(j))) {
                    continue;
                }
                int k = ys.get(i);
                ys.set(i, ys.get(j));
                ys.set(j, k);
                String s = ys.toString();
                if (!exist.contains(s)) {
                    exist.add(s);
                    dfs(ds, ys);
                }
                k = ys.get(i);
                ys.set(i, ys.get(j));
                ys.set(j, k);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        List<Integer> ds = new ArrayList<>(n);
        List<Integer> ys = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            ds.add(scanner.nextInt());
        }
        for (int i = 0; i < n; i++) {
            ys.add(scanner.nextInt());
        }
        ds.sort(Integer::compare);
        ys.sort(Integer::compare);
        exist = new HashSet<>();
        exist.add(ys.toString());
        dfs(ds, ys);
        System.out.println(WIN + " " + LOSS + " " + DRAW);
    }
}
