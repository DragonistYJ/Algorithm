package xiaobai.month63;

import java.util.*;

/**
 * @author yujian
 * @since 2022/12/16 19:01
 */
public class SolutionA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(scanner.nextInt());
        }
        List<Integer> numbers = new ArrayList<>(set);
        if (numbers.size() == 1) {
            System.out.println(numbers.get(0));
            return;
        }
        boolean[] hasZero = new boolean[32];
        for (int i = 0; i < numbers.size(); i++) {
            String s = Integer.toBinaryString(numbers.get(i));
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '0') {
                    hasZero[s.length() - 1 - j] = true;
                }
            }
            for (int j = s.length(); j < 32; j++) {
                hasZero[j] = true;
            }
        }
        int ans = 0;
        int t = 1;
        for (int i = 0; i < 32; i++) {
            if (!hasZero[i]) {
                ans += t;
            }
            t *= 2;
        }
        System.out.println(ans);
    }
}
