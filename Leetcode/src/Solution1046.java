import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
NO 1046 最后一块石头的重量
有一堆石头，每块石头的重量都是正整数。
每一回合，从中选出两块最重的石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
如果 x == y，那么两块石头都会被完全粉碎；
如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 */
public class Solution1046 {
    public int lastStoneWeight(int[] stones) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int stone : stones) {
            arrayList.add(stone);
        }
        while (arrayList.size() > 1) {
            arrayList.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            int x = arrayList.get(arrayList.size() - 1);
            arrayList.remove(arrayList.size() - 1);
            int y = arrayList.get(arrayList.size() - 1);
            arrayList.remove(arrayList.size() - 1);
            int z = Math.abs(x - y);
            if (z != 0) {
                arrayList.add(z);
            }
        }
        if (arrayList.isEmpty()) {
            return 0;
        } else {
            return arrayList.get(0);
        }
    }

    public static void main(String[] args) {
        int[] s = {9, 8, 7, 6, 5, 4, 3, 2};
        System.out.println(new Solution1046().lastStoneWeight(s));
    }
}
