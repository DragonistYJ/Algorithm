import java.util.ArrayList;
import java.util.List;

/*
NO77 组合
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class Solution77 {
    List<List<Integer>> ans;
    List<Integer> path;
    boolean[] used;
    int num;

    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        used = new boolean[n + 1];
        num = n;
        dfs(k);
        return ans;
    }

    private void dfs(int k) {
        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }

        int start = 1;
        if (path.size() != 0) start = path.get(path.size() - 1);
        for (int i = start; i <= num; i++) {
            if (!used[i]) {
                used[i] = true;
                path.add(i);
                dfs(k);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution77().combine(4, 2);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
