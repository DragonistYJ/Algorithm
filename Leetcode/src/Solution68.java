import java.util.ArrayList;
import java.util.List;

/*
NO68 文本左右对齐
给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
文本的最后一行应为左对齐，且单词之间不插入额外的空格。

说明:
单词是指由非空格字符组成的字符序列。
每个单词的长度大于 0，小于等于 maxWidth。
输入单词数组 words 至少包含一个单词。
 */
public class Solution68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int start = 0;
        while (start < words.length) {
            int end = start + 1;
            int len = words[start].length();
            while (end < words.length && len + end - start + words[end].length() <= maxWidth) {
                len += words[end].length();
                end += 1;
            }
            end -= 1;
            if (start != end) ans.add(lineOfMore(start, end, len, words, maxWidth));
            else ans.add(lineOfOne(words[start], maxWidth));
            start = end + 1;
        }
        ans.set(ans.size() - 1, lastLine(ans.get(ans.size() - 1), maxWidth));
        return ans;
    }

    private String lastLine(String word, int maxWidth) {
        String[] splits = word.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < splits.length - 1; i++) {
            if (splits[i].equals("")) continue;
            builder.append(splits[i]);
            builder.append(" ");
        }
        builder.append(splits[splits.length - 1]);
        for (int i = builder.length(); i < maxWidth; i++) {
            builder.append(" ");
        }
        return builder.toString();
    }

    private String lineOfOne(String word, int maxWidth) {
        StringBuilder builder = new StringBuilder();
        builder.append(word);
        for (int i = 0; i < maxWidth - word.length(); i++) {
            builder.append(" ");
        }
        return builder.toString();
    }

    private String lineOfMore(int start, int end, int len, String[] words, int maxWidth) {
        int p = (maxWidth - len) / (end - start);
        int r = (maxWidth - len) % (end - start);
        StringBuilder space = new StringBuilder();
        for (int i = 0; i < p; i++) {
            space.append(" ");
        }
        StringBuilder tmp = new StringBuilder();
        for (int i = start; i < end; i++) {
            tmp.append(words[i]);
            tmp.append(space);
            if (r != 0) {
                tmp.append(" ");
                r -= 1;
            }
        }
        tmp.append(words[end]);
        return tmp.toString();
    }

    public static void main(String[] args) {
        String[] x = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        System.out.println(new Solution68().fullJustify(x, 20));
    }
}
