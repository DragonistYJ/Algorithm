import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName Solution990
 * @Author 11214
 * @Date 2020/6/9
 * @Description 等式方程的可满足性
 * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
 * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。 
 */
public class Solution990 {
    private void union(int[] parent, int a, int b) {
        parent[find(parent, a)] = find(parent, b);
    }

    private int find(int[] parent, int i) {
        if (parent[i] == i) return i;
        else return parent[i] = find(parent, parent[i]);
    }

    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        for (String equation : equations) {
            if (equation.charAt(1) == '!') continue;
            union(parent, equation.charAt(0) - 'a', equation.charAt(3) - 'a');
        }

        for (String equation : equations) {
            if (equation.charAt(1) == '=') continue;
            if (find(parent, equation.charAt(0) - 'a') == find(parent, equation.charAt(3) - 'a')) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String[] equations = {"a==b", "b==c", "a!=c"};
        System.out.println(new Solution990().equationsPossible(equations));
    }
}
