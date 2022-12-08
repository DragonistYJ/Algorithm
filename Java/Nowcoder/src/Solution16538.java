import java.util.Scanner;

/**
 * @author 11214
 * @since 2022/12/8 11:45
 * <p>
 * 试计算在区间1 到n 的所有整数中，数字x（0 ≤ x ≤ 9）共出现了多少次？
 * 例如，在1到11 中，即在1、2、3、4、5、6、7、8、9、10、11 中，数字1 出现了4 次。
 */
public class Solution16538 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int range = scanner.nextInt();
        int n = scanner.nextInt();

        int ans = 0;
        for (int i = 1; i < range; i++) {
            int k = i;
            while (k != 0) {
                int j = k % 10;
                if (j == n) {
                    ans += 1;
                }
                k /= 10;
            }
        }
        System.out.println(ans);
    }
}
