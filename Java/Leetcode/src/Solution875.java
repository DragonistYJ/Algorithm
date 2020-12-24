/**
 * 爱吃香蕉的珂珂
 * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
 * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 */
public class Solution875 {
    public int minEatingSpeed(int[] piles, int H) {
        int min = 1;
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        int ans = max;
        while (min <= max) {
            int k = (min + max) / 2;
            int sum = 0;
            for (int pile : piles) {
                sum += pile / k;
                if (pile % k != 0) sum += 1;
            }
            if (sum <= H) {
                ans = Math.min(ans, k);
                max = k - 1;
            } else {
                min = k + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] piles = {312884470};
        System.out.println(new Solution875().minEatingSpeed(piles, 312884469));
    }
}
