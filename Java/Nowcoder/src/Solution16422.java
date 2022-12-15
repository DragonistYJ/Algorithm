import java.util.*;

/**
 * @author yujian
 * @since 2022/12/15 11:39
 * <p>
 * 图书馆中每本书都有一个图书编码，可以用于快速检索图书，这个图书编码是一个正整数。
 * 每位借书的读者手中有一个需求码，这个需求码也是一个正整数。如果一本书的图书编码恰好以读者的需求码结尾，那么这本书就是这位读者所需要的。
 * 小 D 刚刚当上图书馆的管理员，她知道图书馆里所有书的图书编码，她请你帮她写一个程序，对于每一位读者，求出他所需要的书中图书编码最小的那本书，如果没有他需要的书，请输出-1。
 */
public class Solution16422 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int book = scanner.nextInt();
            int x = 10;
            while (true) {
                int suffix = book % x;
                if (!hashMap.containsKey(suffix)) {
                    hashMap.put(suffix, new ArrayList<>());
                }
                hashMap.get(suffix).add(book);
                x *= 10;
                if (suffix == book) {
                    break;
                }
            }
        }
        for (Map.Entry<Integer, List<Integer>> kv : hashMap.entrySet()) {
            List<Integer> value = kv.getValue();
            value.sort(Comparator.comparingInt(o -> o));
        }
        List<Integer> requires = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            scanner.nextInt();
            requires.add(scanner.nextInt());
        }
        for (Integer require : requires) {
            if (!hashMap.containsKey(require)) {
                System.out.println(-1);
            } else {
                System.out.println(hashMap.get(require).get(0));
            }
        }
    }
}
