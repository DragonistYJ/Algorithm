import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
NO139 单词拆分
给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
说明：
拆分时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
 */
public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> words = new HashSet<>(wordDict);
        boolean[] flags = new boolean[s.length() + 1];
        flags[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (flags[j] && words.contains(s.substring(j, i))) {
                    flags[i] = true;
                    break;
                }
            }
        }
        return flags[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new Solution139().wordBreak("leetcode", Arrays.asList("leet", "code")));
    }
}
