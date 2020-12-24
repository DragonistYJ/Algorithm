import java.util.HashMap;
import java.util.Scanner;

/**
 * @ClassName Solution16690
 * @Author 11214
 * @Date 2020/4/20
 * @Description TODO
 */
public class Solution16690 {
    private static int count(int n, HashMap<Integer, Integer> hashMap) {
        if (n == 1) return 1;
        if (hashMap.containsKey(n)) return hashMap.get(n);
        int ans = 1;
        for (int i = 1; i <= n / 2; i++) {
            ans += count(i, hashMap);
        }
        hashMap.put(n, ans);
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        System.out.println(count(n, hashMap));
    }
}
