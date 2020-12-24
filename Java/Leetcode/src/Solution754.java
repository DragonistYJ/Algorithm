/**
 * @ClassName Solution754
 * @Author 11214
 * @Date 2020/6/26
 * @Description 到达终点数字
 * 在一根无限长的数轴上，你站在0的位置。终点在target的位置。
 * 每次你可以选择向左或向右移动。第 n 次移动（从 1 开始），可以走 n 步。
 * 返回到达终点需要的最小移动次数。
 */
public class Solution754 {
    public int reachNumber(int target) {
        long t = Math.abs(target);
        long index = 0;
        long sum = 0;
        while (true) {
            index += 1;
            sum += index;
            if (sum >= t && sum % 2 == t % 2) return (int) index;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution754().reachNumber(-1));
    }
}
