import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author 11214
 * @since 2022/11/19 10:12
 * <p>
 * 给你一个下标从 0 开始的整数数组 players ，其中 players[i] 表示第 i 名运动员的 能力 值，同时给你一个下标从 0 开始的整数数组 trainers ，其中 trainers[j] 表示第 j 名训练师的 训练能力值 。
 * 如果第 i 名运动员的能力值 小于等于 第 j 名训练师的能力值，那么第 i 名运动员可以 匹配 第 j 名训练师。除此以外，每名运动员至多可以匹配一位训练师，每位训练师最多可以匹配一位运动员。
 * 请你返回满足上述要求 players 和 trainers 的 最大 匹配数。
 */
public class Solution2410 {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        List<Integer> playerList = new ArrayList<>();
        for (int player : players) {
            playerList.add(player);
        }
        playerList.sort(Comparator.comparingInt(o -> o));
        List<Integer> trainerList = new ArrayList<>();
        for (int trainer : trainers) {
            trainerList.add(trainer);
        }
        trainerList.sort(Comparator.comparingInt(o -> o));

        int i = 0;
        int j = 0;
        int ans = 0;
        while (i < players.length && j < trainers.length) {
            if (playerList.get(i) <= trainerList.get(j)) {
                i += 1;
                ans += 1;
            }
            j += 1;
        }

        return ans;
    }
}
