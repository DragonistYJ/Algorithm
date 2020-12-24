import java.util.HashMap;
import java.util.HashSet;

/**
 * @ClassName Solution983
 * @Author 11214
 * @Date 2020/4/23
 * @Description TODO
 */
public class Solution983 {
    private int dfs(int index, int[] costs, HashMap<Integer, Integer> memory, HashSet<Integer> days) {
        if (index > 365) return 0;
        if (memory.containsKey(index)) return memory.get(index);

        int ans = 0;
        if (days.contains(index)) {
            ans = Math.min(dfs(index + 1, costs, memory, days) + costs[0],
                    Math.min(dfs(index + 7, costs, memory, days) + costs[1],
                            dfs(index + 30, costs, memory, days) + costs[2]));
        } else {
            ans = dfs(index + 1, costs, memory, days);
        }
        memory.put(index, ans);
        return ans;
    }

    public int mincostTickets(int[] days, int[] costs) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int day : days) {
            hashSet.add(day);
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        return dfs(1, costs, hashMap, hashSet);
    }

    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        System.out.println(new Solution983().mincostTickets(days, costs));
    }
}
