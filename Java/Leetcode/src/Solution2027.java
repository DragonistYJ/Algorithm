/**
 * @author 11214
 * @since 2022/12/27 10:44
 * <p>
 * 给你一个字符串 s ，由 n 个字符组成，每个字符不是 'X' 就是 'O' 。
 * 一次 操作 定义为从 s 中选出 三个连续字符 并将选中的每个字符都转换为 'O' 。注意，如果字符已经是 'O' ，只需要保持 不变 。
 * 返回将 s 中所有字符均转换为 'O' 需要执行的 最少 操作次数。
 */
public class Solution2027 {
    public int minimumMoves(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); ) {
            if (s.charAt(i) == 'O') {
                i += 1;
            } else {
                ans += 1;
                i += 3;
            }
        }
        return ans;
    }
}
