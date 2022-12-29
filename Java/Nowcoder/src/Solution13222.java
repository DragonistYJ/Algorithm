import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 11214
 * @since 2022/12/29 14:46
 * <p>
 * 美团外卖的品牌代言人袋鼠先生最近正在进行音乐研究。他有两段音频，每段音频是一个表示音高的序列。现在袋鼠先生想要在第二段音频中找出与第一段音频最相近的部分。
 * 具体地说，就是在第二段音频中找到一个长度和第一段音频相等且是连续的子序列，使得它们的 difference 最小。两段等长音频的 difference 定义为：
 * difference = SUM((a[i] - b[i])2 )(1 ≤ i ≤ n),其中SUM()表示求和
 * 其中 n 表示序列长度，a[i], b[i]分别表示两段音频的音高。现在袋鼠先生想要知道，difference的最小值是多少？数据保证第一段音频的长度小于等于第二段音频的长度。
 */
public class Solution13222 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list1.add(scanner.nextInt());
        }
        int m = scanner.nextInt();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list2.add(scanner.nextInt());
        }

        long ans = Integer.MAX_VALUE;
        for (int i = 0; i <= m - n; i++) {
            long difference = 0;
            for (int j = i; j < i + n; j++) {
                difference += Math.pow(list1.get(j - i) - list2.get(j), 2);
            }
            ans = Math.min(ans, difference);
        }

        System.out.println(ans);
    }
}
