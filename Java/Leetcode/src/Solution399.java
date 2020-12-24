import java.util.*;

/*
NO399 除法求值
给出方程式 A / B = k, 其中 A 和 B 均为代表字符串的变量， k 是一个浮点型数字。根据已知方程式求解问题，并返回计算结果。如果结果不存在，则返回 -1.0。
示例 :
给定 a / b = 2.0, b / c = 3.0
问题: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? 
返回 [6.0, 0.5, -1.0, 1.0, -1.0 ]
 */
public class Solution399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, Integer> variables = new HashMap<>();
        int n = 0;
        for (List<String> equation : equations) {
            String s = equation.get(0);
            if (!variables.containsKey(s)) {
                variables.put(s, n);
                n += 1;
            }
            s = equation.get(1);
            if (!variables.containsKey(s)) {
                variables.put(s, n);
                n += 1;
            }
        }
        double[][] roads = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                roads[i][j] = -1.0;
            }
        }
        for (int i = 0; i < n; i++) {
            roads[i][i] = 1.0;
        }
        for (int i = 0; i < equations.size(); i++) {
            int x = variables.get(equations.get(i).get(0));
            int y = variables.get(equations.get(i).get(1));
            roads[x][y] = values[i];
            roads[y][x] = 1 / values[i];
        }
        for (int t = 0; t < n; t++) {
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j || roads[i][j] != -1.0) continue;
                    for (int k = 0; k < n; k++) {
                        if (i == k || j == k || roads[i][k] == -1.0) continue;
                        if (roads[i][k] != -1.0 && roads[k][j] != -1.0) {
                            roads[i][j] = roads[i][k] * roads[k][j];
                            flag = false;
                        }
                    }
                }
            }
            if (flag) break;
        }
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            if (!variables.containsKey(query.get(0)) || !variables.containsKey(query.get(1))) {
                ans[i] = -1.0;
                continue;
            }
            Integer x = variables.get(query.get(0));
            Integer y = variables.get(query.get(1));
            ans[i] = roads[x][y];
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("c", "d"));
        double[] values = {1.0, 1.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "d"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("d", "c"));
        double[] doubles = new Solution399().calcEquation(equations, values, queries);
        for (double aDouble : doubles) {
            System.out.println(aDouble);
        }
    }
}
