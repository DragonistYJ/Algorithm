import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName Solution638
 * @Author 11214
 * @Date 2020/4/27
 * @Description TODO
 */
public class Solution638 {
    private HashMap<List<Integer>, Integer> memory;
    private List<Integer> prices;
    private List<List<Integer>> specials;
    private List<Integer> needs;
    private int n;

    private Integer dfs(List<Integer> needs) {
        if (memory.containsKey(needs)) {
            return memory.get(needs);
        }

        int cost = Integer.MAX_VALUE;
        for (List<Integer> special : specials) {
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                if (needs.get(j) - special.get(j) < 0) {
                    flag = true;
                    break;
                }
            }
            if (flag) continue;

            List<Integer> list = new ArrayList<>(n);
            for (int j = 0; j < n; j++) list.add(needs.get(j) - special.get(j));
            cost = Math.min(cost, special.get(n) + dfs(list));
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += needs.get(i) * prices.get(i);
        }
        cost = Math.min(cost, sum);

        memory.put(new ArrayList<>(needs), cost);
        return cost;
    }

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        n = price.size();
        memory = new HashMap<>();
        List<Integer> init = new ArrayList<>();
        for (int i = 0; i < n; i++) init.add(0);
        memory.put(init, 0);
        prices = price;
        specials = special;
        this.needs = needs;
        dfs(needs);
        return memory.get(needs);
    }

    public static void main(String[] args) {
        Integer[] p = {2, 3, 4};
        List<Integer> price = new ArrayList<>(Arrays.asList(p));
        Integer[][] s = {{1, 1, 0, 4}, {2, 2, 1, 9}};
        List<List<Integer>> special = new ArrayList<>();
        special.add(new ArrayList<>(Arrays.asList(s[0])));
        special.add(new ArrayList<>(Arrays.asList(s[1])));
        Integer[] n = {1, 2, 1};
        List<Integer> needs = new ArrayList<>(Arrays.asList(n));
        System.out.println(new Solution638().shoppingOffers(price, special, needs));
    }
}
