import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Solution16561
 * @Author 11214
 * @Date 2020/4/25
 * @Description TODO
 */
public class Solution16561 {
    private static class Pair {
        private BigInteger left;
        private BigInteger right;

        public Pair(BigInteger left, BigInteger right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        BigInteger kingLeft = scanner.nextBigInteger();
        BigInteger kingRight = scanner.nextBigInteger();
        List<Pair> pairs = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            pairs.add(new Pair(scanner.nextBigInteger(), scanner.nextBigInteger()));
        }
        pairs.sort((o1, o2) -> {
            BigInteger first = o1.left.multiply(o1.right);
            BigInteger second = o2.left.multiply(o2.right);
            return first.compareTo(second);
        });

        BigInteger max = BigInteger.ZERO;
        BigInteger product = new BigInteger(kingLeft.toString());
        for (int i = 0; i < n; i++) {
            BigInteger temp = product.divide(pairs.get(i).right);
            if (temp.compareTo(max) > 0) max = temp;
            product = product.multiply(pairs.get(i).left);
        }

        System.out.println(max);
    }
}
