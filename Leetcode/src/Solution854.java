/*
NO854 相似度为K的字符串
如果可以通过将 A 中的两个小写字母精确地交换位置 K 次得到与 B 相等的字符串，我们称字符串 A 和 B 的相似度为 K（K 为非负整数）。
给定两个字母异位词 A 和 B ，返回 A 和 B 的相似度 K 的最小值。
 */
public class Solution854 {
    int ans;

    public int kSimilarity(String A, String B) {
        ans = Integer.MAX_VALUE;
        dfs(A, B, 0, 0);
        return ans;
    }

    private void dfs(String src, String des, int step, int index) {
        if (step >= ans) return;
        if (src.equals(des)) {
            ans = Math.min(step, ans);
            return;
        }
        if (des.charAt(index) == src.charAt(index)) {
            dfs(src, des, step, index + 1);
        } else {
            for (int i = index; i < des.length(); i++) {
                if (des.charAt(i) == src.charAt(index)) {
                    String tmp = des.substring(0, index) + des.charAt(i) + des.substring(index + 1, i) + des.charAt(index) + des.substring(i + 1);
                    dfs(src, tmp, step + 1, index + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution854().kSimilarity("aabc", "abca"));
    }
}
