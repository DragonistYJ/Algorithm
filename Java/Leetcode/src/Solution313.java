import java.util.HashSet;

/**
 * @ClassName Solution313
 * @Author 11214
 * @Date 2020/6/2
 * @Description TODO
 */
public class Solution313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int k = primes.length;
        HashSet<Integer> hashSet = new HashSet<>();
        int[] base = new int[k];
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            int index = 0;
            int product = primes[0] * ans[base[0]];
            for (int j = 1; j < k; j++) {
                int temp = primes[j] * ans[base[j]];
                if (temp < product) {
                    index = j;
                    product = temp;
                }
            }
            if (hashSet.contains(product)) {
                base[index] += 1;
                i -= 1;
            } else {
                hashSet.add(product);
                ans[i] = product;
            }
        }
        return ans[n - 1];
    }

    public static void main(String[] args) {
        int[] primes = {2, 7, 13, 19};
        System.out.println(new Solution313().nthSuperUglyNumber(11, primes));
    }
}
