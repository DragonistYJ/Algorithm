import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
NO472 连接词
给定一个不含重复单词的列表，编写一个程序，返回给定单词列表中所有的连接词。
连接词的定义为：一个字符串完全是由至少两个给定数组中的单词组成的。
 */
public class Solution472 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<>();
        HashSet<String> wordDict = new HashSet<>(Arrays.asList(words));
        int minLen = 1000000;
        for (String word : words) {
            minLen = Math.min(minLen, word.length());
        }
        for (String word : words) {
            int l = word.length();
            if (l < minLen * 2) continue;
            wordDict.remove(word);
            boolean[] flags = new boolean[l + 1];
            flags[0] = true;
            for (int i = 1; i <= l; i++) {
                for (int j = 0; j < i; j++) {
                    if (flags[j] && wordDict.contains(word.substring(j, i))) {
                        flags[i] = true;
                        break;
                    }
                }
            }
            if (flags[l]) ans.add(word);
            wordDict.add(word);
        }
        ans.remove("");
        return ans;
    }

    public static void main(String[] args) {
        String[] s = {""};
        System.out.println(new Solution472().findAllConcatenatedWordsInADict(s));
    }
}
