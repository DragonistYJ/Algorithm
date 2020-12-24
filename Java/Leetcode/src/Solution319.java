/**
 * @ClassName Solution319
 * @Author 11214
 * @Date 2020/6/16
 * @Description 初始时有 n 个灯泡关闭。 第 1 轮，你打开所有的灯泡。 第 2 轮，每两个灯泡你关闭一次。 第 3 轮，每三个灯泡切换一次开关（如果关闭则开启，如果开启则关闭）。第 i 轮，每 i 个灯泡切换一次开关。 对于第 n 轮，你只切换最后一个灯泡的开关。 找出 n 轮后有多少个亮着的灯泡。
 */
public class Solution319 {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}
