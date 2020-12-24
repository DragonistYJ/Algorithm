/*
NO547 朋友圈
班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。
如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。
你必须输出所有学生中的已知的朋友圈总数。
 */
public class Solution547 {
    private int find(int[] friend, int student) {
        if (friend[student] == student) {
            return student;
        } else {
            return friend[student] = find(friend, friend[student]);
        }
    }

    public int findCircleNum(int[][] M) {
        int n = M.length;
        int[] friend = new int[n];
        for (int i = 0; i < friend.length; i++) {
            friend[i] = i;
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) {
                    friend[find(friend, j)] = find(friend, friend[i]);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < friend.length; i++) {
            if (friend[i] == i) ans += 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] m = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(new Solution547().findCircleNum(m));
    }
}
