package xiaobai.month63;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author yujian
 * @since 2022/12/16 19:23
 */
public class SolutionB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }
        int ans = 0;
        int attack = 2;
        for (int i = 0; i < m; i++) {
            int j = 0;
            while (j < numbers.size()) {
                Integer x = numbers.get(j);
                x -= attack;
                if (x <= 0) {
                    if (x == 0) {
                        attack += 1;
                    }
                    numbers.remove(j);
                } else {
                    numbers.set(j, x);
                    j += 1;
                }
            }
            ans += attack;
        }
        System.out.println(ans);
    }
}
