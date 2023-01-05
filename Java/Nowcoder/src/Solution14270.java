import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author 11214
 * @since 2023/1/5 19:48
 */
public class Solution14270 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(s);
        for (int i = 1; i < s.length(); i++) {
            Set<String> set = new HashSet<>();
            for (int j = 0; j < s.length() - i + 1; j++) {
                String substring = s.substring(j, j + i);
                set.add(substring);
            }
            if (set.size() < (1 << i)) {
                System.out.println(i);
                break;
            }
        }
    }
}
