import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
NO126 单词接龙2
给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。

说明:
如果不存在这样的转换序列，返回一个空列表。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 */
public class Solution126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return ans;
        List<String> ladder = new ArrayList<>();
        ladder.add(beginWord);
        dfs(ans, ladder, wordSet, endWord);
        return ans;
    }

    private void dfs(List<List<String>> ans, List<String> ladder, HashSet<String> wordSet, String endWord) {
        if (!ans.isEmpty() && ladder.size() > ans.get(0).size()) return;
        if (ladder.get(ladder.size() - 1).equals(endWord)) {
            if (ans.isEmpty()) ans.add(new ArrayList<>(ladder));
            else if (ladder.size() == ans.get(0).size()) ans.add(new ArrayList<>(ladder));
            else if (ladder.size() < ans.get(0).size()) {
                ans.clear();
                ans.add(new ArrayList<>(ladder));
            }
        }
        HashSet<String> tmp = new HashSet<>(wordSet);
        for (String s : wordSet) {
            if (connectable(ladder.get(ladder.size() - 1), s)) {
                tmp.remove(s);
                ladder.add(s);
                dfs(ans, ladder, tmp, endWord);
                ladder.remove(ladder.size() - 1);
                tmp.add(s);
            }
        }
    }

    private boolean connectable(String s1, String s2) {
        int flag = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) flag += 1;
            if (flag == 2) return false;
        }
        return flag == 1;
    }

    public static void main(String[] args) {
        List<String> s = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
        System.out.println(new Solution126().findLadders("hit", "cog", s));
    }
}
