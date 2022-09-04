import java.util.*;
import java.util.AbstractMap.SimpleEntry;

/*
NO127 单词接龙
给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。
说明:
如果不存在这样的转换序列，返回 0。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 */
public class Solution127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        while (wordList.contains(beginWord)) {
            wordList.remove(beginWord);
        }
        List<SimpleEntry<String, Integer>> queue = new LinkedList<>();
        queue.add(new SimpleEntry<>(beginWord, 1));
        while (!queue.isEmpty()) {
            SimpleEntry<String, Integer> pair = queue.get(0);
            queue.remove(0);
            String word = pair.getKey();
            Integer length = pair.getValue();
            if (word.equals(endWord)) return length;

            int index = 0;
            while (index < wordList.size()) {
                if (connectable(word, wordList.get(index))) {
                    queue.add(new SimpleEntry<>(wordList.get(index), length + 1));
                    wordList.remove(index);
                } else {
                    index += 1;
                }
            }
        }

        return 0;
    }

    private boolean connectable(String s1, String s2) {
        int n = s1.length();
        int diff = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff += 1;
                if (diff > 1) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution127().ladderLength("hit", "cog", new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))));
    }
}
