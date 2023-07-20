import java.util.Arrays;

/**
 * @author yujian
 * @since 2023/7/20 11:31
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
 * 根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，并且每篇论文 至少 被引用 h 次。
 * 如果 h 有多种可能的值，h 指数 是其中最大的那个。
 */
public class Solution274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        int i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }

    public static void main(String[] args) {
        Solution274 solution = new Solution274();
        System.out.println(solution.hIndex(new int[]{1, 2}));
    }
}
