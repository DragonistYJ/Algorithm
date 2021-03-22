/**
 * @author YuJian
 * @since 2021/3/22
 * 累加数是一个字符串，组成它的数字可以形成累加序列。
 * 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 * 给定一个只包含数字'0'-'9'的字符串，编写一个算法来判断给定输入是否是累加数。
 * 说明:累加序列里的数不会以 0 开头，所以不会出现1, 2, 03 或者1, 02, 3的情况。
 */
public class Solution306 {
    private boolean check(long one, long two, String num) {
        if (num.isEmpty()) {
            return true;
        }

        long three = one + two;
        String threeString = String.valueOf(three);
        if (!num.startsWith(threeString)) {
            return false;
        }
        return check(two, three, num.substring(threeString.length()));
    }

    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        for (int i = 1; i < len - 1; i++) {
            String oneString = num.substring(0, i);
            if (oneString.startsWith("0") && !"0".equals(oneString)) {
                continue;
            }
            long one = Long.parseLong(oneString);
            for (int j = i + 1; j < len; j++) {
                String twoString = num.substring(i, j);
                if (twoString.startsWith("0") && !"0".equals(twoString)) {
                    continue;
                }
                long two = Long.parseLong(twoString);

                if (check(one, two, num.substring(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution306 solution = new Solution306();
        System.out.println(solution.isAdditiveNumber("123"));
    }
}
