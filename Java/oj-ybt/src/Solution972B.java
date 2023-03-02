import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 11214
 * @since 2023/3/2 9:45
 */
public class Solution972B {
    private static int[][] dp;

    private static class Course {
        private final int idx;
        private int score;
        private final List<Course> kids = new ArrayList<>();
        private int total;

        public Course(int idx) {
            this.idx = idx;
        }

        @Override
        public String toString() {
            return "Course{" +
                    "idx=" + idx +
                    ", score=" + score +
                    '}';
        }
    }

    private static int calculateKids(Course course) {
        int sum = 1;
        for (Course kid : course.kids) {
            sum += calculateKids(kid);
        }
        course.total = sum;
        return sum;
    }

    private static void dfs(Course course, int m) {
        dp[course.idx][1] = course.score;
        if (course.kids.size() == 0) {
            return;
        }

        for (Course kid : course.kids) {
            dfs(kid, m);
        }
        int total = Math.min(m, course.total) - (course.idx == 0 ? 0 : 1);
        int[] bags = new int[total + 1];
        Arrays.fill(bags, -1);
        bags[0] = 0;
        for (int i = 0; i < course.kids.size(); i++) { // 枚举物品
            Course kid = course.kids.get(i);
            for (int j = total - 1; j >= 0; j--) {
                if (bags[j] == -1) {
                    continue;
                }
                for (int k = 1; k <= kid.total && k + j <= total; k++) {
                    bags[j + k] = Math.max(bags[j + k], bags[j] + dp[kid.idx][k]);
                }
            }
        }
        if (course.idx == 0) {
            for (int i = 1; i <= total; i++) {
                dp[course.idx][i] = course.score + bags[i];
            }
        } else {
            for (int i = 2; i <= total + 1; i++) {
                dp[course.idx][i] = course.score + bags[i - 1];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        st.nextToken();
        int n = (int) st.nval;
        st.nextToken();
        int m = (int) st.nval;
        dp = new int[n + 1][m + 1];
        Course[] courses = new Course[n + 1];
        for (int i = 0; i <= n; i++) {
            courses[i] = new Course(i);
        }
        for (int i = 0; i < n; i++) {
            st.nextToken();
            int pre = (int) st.nval;
            courses[pre].kids.add(courses[i + 1]);
            st.nextToken();
            courses[i + 1].score = (int) st.nval;
        }
        calculateKids(courses[0]);
        dfs(courses[0], m);
        System.out.println(dp[0][m]);
    }
}