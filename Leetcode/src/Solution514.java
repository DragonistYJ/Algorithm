import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
NO512 自由之路
视频游戏“辐射4”中，任务“通向自由”要求玩家到达名为“Freedom Trail Ring”的金属表盘，并使用表盘拼写特定关键词才能开门。
给定一个字符串 ring，表示刻在外环上的编码；给定另一个字符串 key，表示需要拼写的关键词。您需要算出能够拼写关键词中所有字符的最少步数。
最初，ring 的第一个字符与12:00方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00 方向对齐，然后按下中心按钮，以此逐个拼写完 key 中的所有字符。
旋转 ring 拼出 key 字符 key[i] 的阶段中：
您可以将 ring 顺时针或逆时针旋转一个位置，计为1步。旋转的最终目的是将字符串 ring 的一个字符与 12:00 方向对齐，并且这个字符必须等于字符 key[i] 。
如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作 1 步。按完之后，您可以开始拼写 key 的下一个字符（下一阶段）, 直至完成所有拼写。
 */
public class Solution514 {
    int ans = Integer.MAX_VALUE;

    public int findRotateSteps(String ring, String key) {
        HashMap<Character, List<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < ring.length(); i++) {
            if (hashMap.containsKey(ring.charAt(i))) {
                hashMap.get(ring.charAt(i)).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                hashMap.put(ring.charAt(i), list);
            }
        }
        int n = ring.length();
        int m = key.length();
        int[][] dp = new int[m + 1][n];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 100000000;
            }
        }
        dp[0][0] = 0;
        for (int i = 0; i < m; i++) {
            char c = key.charAt(i);
            List<Integer> positions = hashMap.get(c);
            for (Integer position : positions) {
                for (int j = 0; j < n; j++) {
                    dp[i + 1][position] = Math.min(dp[i + 1][position], 1 + dp[i][j] + Math.min(Math.abs(position - j), n - Math.abs(position - j)));
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[m][i]);
        }
        return ans;
    }

    public int findRotateSteps_DFS(String ring, String key) {
        HashMap<Character, List<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < ring.length(); i++) {
            if (hashMap.containsKey(ring.charAt(i))) {
                hashMap.get(ring.charAt(i)).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                hashMap.put(ring.charAt(i), list);
            }
        }
        dfs(0, 0, 0, key, ring.length(), hashMap);
        return ans;
    }

    private void dfs(int index, int lastPos, int steps, String key, int ringLen, HashMap<Character, List<Integer>> hashMap) {
        if (steps >= ans) return;
        if (index == key.length()) {
            ans = steps;
            return;
        }
        char c = key.charAt(index);
        List<Integer> charList = hashMap.get(c);
        for (Integer pos : charList) {
            int step = Math.min(Math.abs(pos - lastPos), ringLen - Math.abs(pos - lastPos)) + 1;
            dfs(index + 1, pos, steps + step, key, ringLen, hashMap);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution514().findRotateSteps("aaaaa", "aaaaa"));
    }
}
