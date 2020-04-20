import java.util.*;

/*
NO403 青蛙过河
一只青蛙想要过河。 假定河流被等分为 x 个单元格，并且在每一个单元格内都有可能放有一石子（也有可能没有）。 青蛙可以跳上石头，但是不可以跳入水中。
给定石子的位置列表（用单元格序号升序表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一个石子上）。 开始时， 青蛙默认已站在第一个石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格1跳至单元格2）。
如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。

请注意：
石子的数量 ≥ 2 且 < 1100；
每一个石子的位置序号都是一个非负整数，且其 < 231；
第一个石子的位置永远是0。
 */
public class Solution403 {
    public boolean canCross(int[] stones) {
        HashMap<Integer, Set<Integer>> hashMap = new HashMap<>();
        for (int stone : stones) {
            hashMap.put(stone, new HashSet<>());
        }
        hashMap.get(0).add(0);
        for (int i = 1; i < stones.length; i++) {
            for (int j = 0; j < i; j++) {
                Set<Integer> set = hashMap.get(stones[j]);
                for (Integer anInt : set) {
                    if (stones[j] + anInt - 1 == stones[i]) {
                        hashMap.get(stones[i]).add(anInt - 1);
                    } else if (stones[j] + anInt == stones[i]) {
                        hashMap.get(stones[i]).add(anInt);
                    } else if (stones[j] + anInt + 1 == stones[i]) {
                        hashMap.get(stones[i]).add(anInt + 1);
                    }
                }
            }
        }
        return !hashMap.get(stones[stones.length - 1]).isEmpty();
    }

    public static void main(String[] args) {
        int[] x = {0, 1, 2, 3, 4, 8, 9, 11};
        System.out.println(new Solution403().canCross(x));
    }
}

