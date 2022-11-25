/**
 * @author 11214
 * @since 2022/11/25 10:25
 * <p>
 * 列表 arr 由在范围 [1, n] 中的所有整数组成，并按严格递增排序。请你对 arr 应用下述算法：
 * 从左到右，删除第一个数字，然后每隔一个数字删除一个，直到到达列表末尾。
 * 重复上面的步骤，但这次是从右到左。也就是，删除最右侧的数字，然后剩下的数字每隔一个删除一个。
 * 不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
 * 给你整数 n ，返回 arr 最后剩下的数字。
 */
public class Solution390 {
    public int lastRemaining(int n) {
        int start = 1;
        int step = 1;
        int round = 1;
        while (n != 1) {
            if (round % 2 == 1) {
                start = start + step;
            } else {
                if (n % 2 == 1) {
                    start = start + step;
                }
            }

            round += 1;
            step *= 2;
            n /= 2;
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(new Solution390().lastRemaining(9));
    }
}
