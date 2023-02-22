import java.util.HashSet;
import java.util.Scanner;

/**
 * @author 11214
 * @since 2023/2/22 9:35
 */
public class Solution956D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        boolean flag = false;
        HashSet<String> set = new HashSet<>(128);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (s.equals("9")) {
                set.clear();
                if (!flag) {
                    System.out.println("Set " + t + " is immediately decodable");
                }
                flag = false;
                t += 1;
            }
            if (flag) {
                continue;
            }

            for (int i = 1; i <= s.length(); i++) {
                String substring = s.substring(0, i);
                if (set.contains(substring)) {
                    System.out.println("Set " + t + " is not immediately decodable");
                    flag = true;
                }
            }
            set.add(s);
        }
    }
}
