/**
 * @author 11214
 * @since 2022/8/31 9:49
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 */
public class Solution168 {
    public String convertToTitle(int columnNumber) {
        StringBuilder builder = new StringBuilder();
        while (columnNumber != 0) {
            int a = (columnNumber - 1) % 26;
            builder.append((char) (a + 65));
            columnNumber = (columnNumber - 1) / 26;
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        Solution168 solution168 = new Solution168();
        System.out.println(solution168.convertToTitle(2147483647));
    }
}
