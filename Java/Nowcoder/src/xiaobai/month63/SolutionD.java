package xiaobai.month63;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author yujian
 * @since 2022/12/16 19:39
 */
public class SolutionD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Long> costs = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            costs.add(scanner.nextLong());
        }
        costs.sort(Long::compare);
        if (m == 1) {
            System.out.println("Ginger666");
            return;
        }
        int first = 1;
        int second = 1;
        int group = (n - 2) / 3;
        first += 2 * group;
        second += group;
        int reminder = (n - 2) % 3;
        if (reminder == 1) {
            first += 1;
        } else if (reminder == 2) {
            first += 1;
            second += 1;
        }
        Long ans = first * costs.get(0) + second * costs.get(1);
        System.out.println(ans);
    }
}
