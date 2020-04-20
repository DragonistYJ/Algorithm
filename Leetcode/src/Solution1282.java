import java.util.ArrayList;
import java.util.List;

/*
NO1282 用户分组
有 n 位用户参加活动，他们的 ID 从 0 到 n - 1，每位用户都 恰好 属于某一用户组。给你一个长度为 n 的数组 groupSizes，其中包含每位用户所处的用户组的大小，请你返回用户分组情况（存在的用户组以及每个组中用户的 ID）。
你可以任何顺序返回解决方案，ID 的顺序也不受限制。此外，题目给出的数据保证至少存在一种解决方案。
 */
public class Solution1282 {
    private class Group {
        private int maxPeople;
        private int todo;
        private List<Integer> people;

        public Group(int maxPeople, int todo, List<Integer> people) {
            this.maxPeople = maxPeople;
            this.todo = todo;
            this.people = people;
        }
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<Group> groups = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            boolean flag = false;
            for (Group group : groups) {
                if (group.maxPeople == groupSizes[i] && group.todo != 0) {
                    group.todo -= 1;
                    group.people.add(i);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                List<Integer> people = new ArrayList<>();
                people.add(i);
                groups.add(new Group(groupSizes[i], groupSizes[i] - 1, people));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (Group group : groups) {
            ans.add(group.people);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] x = {3, 3, 3, 3, 3, 1, 3};
        System.out.println(new Solution1282().groupThePeople(x));
    }
}
