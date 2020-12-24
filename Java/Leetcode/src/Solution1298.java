import sun.rmi.runtime.Log;

import java.text.SimpleDateFormat;
import java.util.*;

/*
NO1298 你能从盒子里获得的最大糖果数
给你 n 个盒子，每个盒子的格式为 [status, candies, keys, containedBoxes] ，其中：

状态字 status[i]：整数，如果 box[i] 是开的，那么是 1 ，否则是 0 。
糖果数 candies[i]: 整数，表示 box[i] 中糖果的数目。
钥匙 keys[i]：数组，表示你打开 box[i] 后，可以得到一些盒子的钥匙，每个元素分别为该钥匙对应盒子的下标。
内含的盒子 containedBoxes[i]：整数，表示放在 box[i] 里的盒子所对应的下标。
给你一个 initialBoxes 数组，表示你现在得到的盒子，你可以获得里面的糖果，也可以用盒子里的钥匙打开新的盒子，还可以继续探索从这个盒子里找到的其他盒子。

请你按照上述规则，返回可以获得糖果的 最大数目 。
 */
public class Solution1298 {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        List<Integer> canOpenBoxes = new LinkedList<>();
        List<Integer> cantOpenBoxes = new ArrayList<>();
        for (int initialBox : initialBoxes) {
            if (status[initialBox] == 1) canOpenBoxes.add(initialBox);
            else cantOpenBoxes.add(initialBox);
        }
        HashSet<Integer> haveKeys = new HashSet<>();

        int ans = 0;
        while (!canOpenBoxes.isEmpty()) {
            Integer box = canOpenBoxes.get(0);
            canOpenBoxes.remove(0);
            ans += candies[box];
            for (int containedBox : containedBoxes[box]) {
                cantOpenBoxes.add(containedBox);
            }
            for (int key : keys[box]) {
                haveKeys.add(key);
            }
            int index = 0;
            while (index < cantOpenBoxes.size()) {
                Integer cantOpenBox = cantOpenBoxes.get(index);
                if (status[cantOpenBox] == 1 || haveKeys.contains(cantOpenBox)) {
                    cantOpenBoxes.remove(cantOpenBox);
                    canOpenBoxes.add(cantOpenBox);
                } else {
                    index += 1;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] status = {1, 1, 1};
        int[] candies = {2, 3, 2};
        int[][] keys = {{}, {}, {}};
        int[][] containBoxed = {{}, {}, {}};
        int[] init = {2, 1, 0};
        System.out.println(new Solution1298().maxCandies(status, candies, keys, containBoxed, init));
    }
}
