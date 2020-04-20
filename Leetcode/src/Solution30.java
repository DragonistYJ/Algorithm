import java.util.*;

/*
NO30 串联所有单词的子串
给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 */
public class Solution30 {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s.length() == 0 || words.length == 0) return new ArrayList<>();
        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= s.length() - totalLen; i++) {
            if (isOk(s.substring(i, i + totalLen), new ArrayList<>(Arrays.asList(words)), wordLen)) {
                ans.add(i);
            }
        }
        return ans;
    }

    private boolean isOk(String sub, List<String> words, int wordLen) {
        for (int i = 0; i < sub.length(); i += wordLen) {
            String substring = sub.substring(i, i + wordLen);
            if (!words.contains(substring)) return false;
            words.remove(substring);
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"word", "good", "best", "good"};
        System.out.println(new Solution30().findSubstring("wordgoodgoodgoodbestword", words));
    }
}
