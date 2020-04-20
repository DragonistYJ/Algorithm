import java.util.Scanner;

/**
 * @ClassName 锦标赛
 * @Author 11214
 * @Date 2020/4/3
 * @Description DFS
 */
public class Solution13223 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int beauty = scanner.nextInt();
        int ans = 1;
        for (int i = 0; i < n - 1; i++) {
            int t = scanner.nextInt();
            if (t <= beauty) ans += 1;
        }
        System.out.println((int) (Math.log(ans) / Math.log(2)));
    }
}
