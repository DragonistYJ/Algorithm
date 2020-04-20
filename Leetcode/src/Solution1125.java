import java.util.*;

/*
NO1125 最小的必要团队
作为项目经理，你规划了一份需求的技能清单 req_skills，并打算从备选人员名单 people 中选出些人组成一个「必要团队」（ 编号为 i 的备选人员 people[i] 含有一份该备选人员掌握的技能列表）。
所谓「必要团队」，就是在这个团队中，对于所需求的技能列表 req_skills 中列出的每项技能，团队中至少有一名成员已经掌握。
我们可以用每个人的编号来表示团队中的成员：例如，团队 team = [0, 1, 3] 表示掌握技能分别为 people[0]，people[1]，和 people[3] 的备选人员。
请你返回 任一 规模最小的必要团队，团队成员用人员编号表示。你可以按任意顺序返回答案，本题保证答案存在。
 */
public class Solution1125 {
    List<Integer> ans = new ArrayList<>();
    int[] peopleSkill;
    int[] employed;
    int aim;

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        peopleSkill = new int[people.size()];
        employed = new int[people.size()];
        aim = (int) Math.pow(2, req_skills.length) - 1;
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < req_skills.length; i++) {
            hashMap.put(req_skills[i], i);
        }
        // 构建每个人的技能值
        for (int i = 0; i < people.size(); i++) {
            List<String> skills = people.get(i);
            for (String skill : skills) {
                if (hashMap.containsKey(skill)) {
                    peopleSkill[i] = peopleSkill[i] | (1 << hashMap.get(skill));
                }
            }
        }
        for (int i = 0; i < people.size() - 1; i++) {
            for (int j = i + 1; j < people.size(); j++) {
                if (people.get(i).containsAll(people.get(j))) {
                    peopleSkill[j] = 0;
                } else if (people.get(j).containsAll(people.get(i))) {
                    peopleSkill[i] = 0;
                }
            }
        }
        int x = 0;
        int y = 0;
        for (String req_skill : req_skills) {
            int index = -1;
            boolean flag = true;
            for (int j = 0; j < people.size(); j++) {
                if (people.get(j).contains(req_skill) && peopleSkill[j] != 0) {
                    if (index == -1) index = j;
                    else {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag && employed[index] == 0) {
                employed[index] = 1;
                y += 1;
                for (String s : people.get(index)) {
                    x = x | (1 << hashMap.get(s));
                }
            }
        }
        for (int i = 0; i < people.size(); i++) {
            if (peopleSkill[i] != 0) ans.add(i);
        }
        if (x != aim) seek(x, y);
        int[] ret = new int[ans.size()];
        ans.sort((o1, o2) -> o1 - o2);
        for (int i = 0; i < ans.size(); i++) {
            ret[i] = ans.get(i);
        }
        return ret;
    }

    public void seek(int sum, int peopleNum) {
        if (peopleNum >= ans.size()) return;
        if (sum == aim) {
            ans.clear();
            for (int i = 0; i < employed.length; i++) {
                if (employed[i] == 1) ans.add(i);
            }
            return;
        }
        for (int i = 0; i < peopleSkill.length; i++) {
            if (employed[i] == 0 && peopleSkill[i] != 0 && peopleNum < ans.size()) {
                employed[i] = 1;
                seek(sum | peopleSkill[i], peopleNum + 1);
                employed[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        String[] req = new String[]{"gvp", "jgpzzicdvgxlfix", "kqcrfwerywbwi", "jzukdzrfgvdbrunw", "k"};
        List<String> p1 = Arrays.asList();
        List<String> p2 = Arrays.asList();
        List<String> p3 = Arrays.asList();
        List<String> p4 = Arrays.asList();
        List<String> p5 = Arrays.asList("jgpzzicdvgxlfix");
        List<String> p6 = Arrays.asList("jgpzzicdvgxlfix", "k");
        List<String> p7 = Arrays.asList("jgpzzicdvgxlfix", "kqcrfwerywbwi");
        List<String> p8 = Arrays.asList("gvp");
        List<String> p9 = Arrays.asList("jzukdzrfgvdbrunw");
        List<String> p10 = Arrays.asList("gvp", "kqcrfwerywbwi");
        List<List<String>> people = new ArrayList<>();
        people.add(p1);
        people.add(p2);
        people.add(p3);
        people.add(p4);
        people.add(p5);
        people.add(p6);
        people.add(p7);
        people.add(p8);
        people.add(p9);
        people.add(p10);
        int[] ints = new Solution1125().smallestSufficientTeam(req, people);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}