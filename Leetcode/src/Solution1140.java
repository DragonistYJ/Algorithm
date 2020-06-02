import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName Solution1140
 * @Author 11214
 * @Date 2020/4/28
 * @Description TODO
 */
public class Solution1140 {
    private int n;

    private int dfs(HashMap<List<Integer>, Integer> memory, int index, int m) {
        List<Integer> key = new ArrayList<>();
        key.add(index);
        key.add(m);
        if (memory.containsKey(key)) return memory.get(key);
        if (index + m * 2 >= n) {

        }
        return 1;
    }

    public int stoneGameII(int[] piles) {
        n = piles.length;
        HashMap<List<Integer>, Integer> memory = new HashMap<>();
        return dfs(memory, 0, 1);
    }
}
