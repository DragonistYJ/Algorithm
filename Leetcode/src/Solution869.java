import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
NO869 重新排序得到2的幂
给定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
 */
public class Solution869 {
    public boolean reorderedPowerOf2(int N) {
        if (N == 0) return false;
        int len = String.valueOf(N).length();
        int n = N;
        List<Integer> nums = new ArrayList<>();
        while (n != 0) {
            nums.add(n % 10);
            n /= 10;
        }
        nums.sort(Comparator.comparingInt(o -> o));

        int t = 1;
        String tmp = "1";
        while (tmp.length() <= len) {
            if (tmp.length() == len) {
                List<Integer> list = new ArrayList<>();
                int k = t;
                while (k != 0) {
                    list.add(k % 10);
                    k /= 10;
                }
                list.sort(Comparator.comparingInt(o -> o));
                if (list.equals(nums)) {
                    return true;
                }
            }
            t *= 2;
            tmp = String.valueOf(t);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution869().reorderedPowerOf2(886));
    }
}
