import java.util.HashSet;
import java.util.Scanner;

/**
 * @author 11214
 * @since 2023/2/20 9:31
 */
public class Solution954B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            if (line.startsWith("add ")) {
                String book = line.substring(4);
                set.add(book);
            } else {
                String book = line.substring(5);
                System.out.println(set.contains(book) ? "yes" : "no");
            }
        }
    }
}
