package competition.week324;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author yujian
 * @since 2022/12/18 10:35
 */
public class Solution6266 {
    public int smallestValue(int n) {
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        primes.add(3);
        primes.add(5);
        for (int i = 7; i <= Math.sqrt(n) + 1; i++) {
            boolean flag = true;
            for (Integer prime : primes) {
                if (i % prime == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                primes.add(i);
            }
        }
        HashSet<Integer> primeSet = new HashSet<>(primes);
        int pre = n;
        while (!primeSet.contains(n) && n != 4) {
            List<Integer> ss = new ArrayList<>();
            for (Integer prime : primes) {
                if (prime >= n) {
                    break;
                }
                while (n % prime == 0) {
                    ss.add(prime);
                    n = n / prime;
                }
            }
            if (n != 1) {
                ss.add(n);
            }
            n = ss.stream().reduce(Integer::sum).get();
            if (n == pre) {
                break;
            }
            pre = n;
        }

        return n;
    }

    public static void main(String[] args) {
        System.out.println(new Solution6266().smallestValue(15));
    }
}
