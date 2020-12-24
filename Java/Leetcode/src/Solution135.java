import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;

/*
NO135 分发糖果
老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
你需要按照以下要求，帮助老师给这些孩子分发糖果：
每个孩子至少分配到 1 个糖果。
相邻的孩子中，评分高的孩子必须获得更多的糖果。
那么这样下来，老师至少需要准备多少颗糖果呢？
 */
public class Solution135 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 1) return 1;
        ArrayList<Pair<Integer, Integer>> arrayList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            arrayList.add(new Pair<>(ratings[i], i));
        }
        arrayList.sort(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.getKey() - o2.getKey();
            }
        });
        int[] candies = new int[n];
        for (Pair<Integer, Integer> pair : arrayList) {
            int index = pair.getValue();
            if (index == 0) {
                if (ratings[0] > ratings[1]) {
                    candies[0] = candies[1] + 1;
                } else {
                    candies[0] = 1;
                }
            } else if (index == n - 1) {
                if (ratings[n - 1] > ratings[n - 2]) {
                    candies[n - 1] = candies[n - 2] + 1;
                } else {
                    candies[n - 1] = 1;
                }
            } else {
                if (ratings[index] == ratings[index - 1] && ratings[index] == ratings[index + 1]) {
                    candies[index] = 1;
                } else if (ratings[index] == ratings[index - 1]) {
                    candies[index] = candies[index + 1] + 1;
                } else if (ratings[index] == ratings[index + 1]) {
                    candies[index] = candies[index - 1] + 1;
                } else {
                    candies[index] = Math.max(candies[index - 1], candies[index + 1]) + 1;
                }
            }
        }
        int ans = 0;
        for (int candy : candies) {
            ans += candy;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] c = new int[]{12, 4, 3, 11, 34, 34, 1, 67};
        System.out.println(new Solution135().candy(c));
    }
}
