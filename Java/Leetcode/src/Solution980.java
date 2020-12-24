import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

/*
NO980 不同路径3
在二维网格 grid 上，有 4 种类型的方格：

1 表示起始方格。且只有一个起始方格。
2 表示结束方格，且只有一个结束方格。
0 表示我们可以走过的空方格。
-1 表示我们无法跨越的障碍。
返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目，每一个无障碍方格都要通过一次。
 */
public class Solution980 {
    private int n;
    private int m;
    private HashMap<Memory, Integer> memories;
    private int sr;
    private int sc;
    private int er;
    private int ec;

    private class Memory {
        private int posRow;
        private int posCol;
        private HashSet<Integer> todo;

        public Memory(int posRow, int posCol, HashSet<Integer> todo) {
            this.posRow = posRow;
            this.posCol = posCol;
            this.todo = todo;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Memory memory = (Memory) o;
            return posRow == memory.posRow &&
                    posCol == memory.posCol &&
                    Objects.equals(todo, memory.todo);
        }

        @Override
        public int hashCode() {
            return Objects.hash(posRow, posCol, todo);
        }
    }

    public int uniquePathsIII(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        memories = new HashMap<>();
        HashSet<Integer> todo = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    sr = i;
                    sc = j;
                }
                if (grid[i][j] == 2) {
                    er = i;
                    ec = j;
                }
                if (grid[i][j] != -1) {
                    todo.add(i * m + j);
                }
            }
        }
        todo.remove(sr * m + sc);
        return search(sr, sc, todo);
    }

    private int search(int i, int j, HashSet<Integer> todo) {
        if (memories.containsKey(new Memory(i, j, todo))) {
            return memories.get(new Memory(i, j, todo));
        }

        if (i == er && j == ec) {
            if (todo.isEmpty()) return 1;
            else return 0;
        }

        int ans = 0;
        if (i < n - 1 && todo.contains((i + 1) * m + j)) {
            todo.remove((i + 1) * m + j);
            ans += search(i + 1, j, todo);
            todo.add((i + 1) * m + j);
        }
        if (j < m - 1 && todo.contains(i * m + j + 1)) {
            todo.remove(i * m + j + 1);
            ans += search(i, j + 1, todo);
            todo.add(i * m + j + 1);
        }
        if (i > 0 && todo.contains((i - 1) * m + j)) {
            todo.remove((i - 1) * m + j);
            ans += search(i - 1, j, todo);
            todo.add((i - 1) * m + j);
        }
        if (j > 0 && todo.contains(i * m + j - 1)) {
            todo.remove(i * m + j - 1);
            ans += search(i, j - 1, todo);
            todo.add(i * m + j - 1);
        }
        memories.put(new Memory(i, j, new HashSet<>(todo)), ans);
        return ans;
    }

    public static void main(String[] args) {
        int[][] x = {{0, 1}, {2, 0}};
        System.out.println(new Solution980().uniquePathsIII(x));
    }
}
