package interview;

/**
 * @ClassName Solution64
 * @Author 11214
 * @Date 2020/4/11
 * @Description TODO
 */
public class Solution64 {
    public int sumNums(int n) {
        int sum = n;
        boolean b = (n > 0) && ((sum = sumNums(n - 1) + n )>0);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution64().sumNums(10));
    }
}
