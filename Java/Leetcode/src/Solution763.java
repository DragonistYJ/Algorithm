import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
NO763 划分字母区间
字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
输入: S = "ababcbacadefegdehijhklij"
输出: [9,7,8]
解释:
划分结果为 "ababcbaca", "defegde", "hijhklij"。
每个字母最多出现在一个片段中。
像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 */
public class Solution763 {
    public List<Integer> partitionLabels(String S) {
        ArrayList<Set<Character>> arrayList = new ArrayList<>(26);
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            int j;
            boolean flag = false;
            for (j = 0; j < arrayList.size(); j++) {
                if (arrayList.get(j).contains(S.charAt(i))) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                for (int k = j + 1; k < arrayList.size(); k++) {
                    arrayList.get(j).addAll(arrayList.get(k));
                }
                ans.set(j, i);
                int k = arrayList.size() - 1;
                while (k > j) {
                    arrayList.remove(k);
                    ans.remove(k);
                    k--;
                }
            } else {
                Set<Character> set = new HashSet<>();
                set.add(S.charAt(i));
                arrayList.add(set);
                ans.add(i);
            }
        }
        for (int i = ans.size() - 1; i > 0; i--) {
            ans.set(i, ans.get(i) - ans.get(i - 1));
        }
        ans.set(0, ans.get(0) + 1);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution763().partitionLabels("vhaagbqkaq"));
    }
}
