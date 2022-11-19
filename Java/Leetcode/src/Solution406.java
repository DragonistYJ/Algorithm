import java.util.Arrays;

/**
 * @ClassName Solution406
 * @Author 11214
 * @Date 2020/6/5
 * @Description 根据身高重建队列
 */
public class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        if (n == 0) return people;
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        int[][] ans = new int[n][2];
        ans[0][0] = people[0][0];
        ans[0][1] = people[0][1];

        for (int i = 1; i < n; i++) {
            int t = 0;
            boolean flag = true;
            for (int j = 0; j < i; j++) {
                if (ans[j][0] >= people[i][0]) t += 1;
                if (t > people[i][1]) {
                    for (int k = i - 1; k >= j; k--) {
                        ans[k + 1][0] = ans[k][0];
                        ans[k + 1][1] = ans[k][1];
                    }
                    ans[j][0] = people[i][0];
                    ans[j][1] = people[i][1];
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans[i][0] = people[i][0];
                ans[i][1] = people[i][1];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] people = {{9, 0}, {7, 0}, {1, 9}, {3, 0}, {2, 7}, {5, 3}, {6, 0}, {3, 4}, {6, 2}, {5, 2}};
        int[][] queue = new Solution406().reconstructQueue(people);
        for (int[] ints : queue) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
