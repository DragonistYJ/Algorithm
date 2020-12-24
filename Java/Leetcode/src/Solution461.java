/**
 * @ClassName Solution461
 * @Author 11214
 * @Date 2020/6/5
 * @Description 汉明距离
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 */
public class Solution461 {
    public int hammingDistance(int x, int y) {
        int ans = 0;
        while (x != 0 || y != 0) {
            int a = x & 1;
            int b = y & 1;
            if (a != b) ans += 1;
            x = x >> 1;
            y = y >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution461().hammingDistance(1, 4));
    }
}
