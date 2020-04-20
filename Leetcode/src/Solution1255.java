/*
NO1255 得分最高的单词集合
你将会得到一份单词表 words，一个字母表 letters （可能会有重复字母），以及每个字母对应的得分情况表 score。
请你帮忙计算玩家在单词拼写游戏中所能获得的「最高得分」：能够由 letters 里的字母拼写出的 任意 属于 words 单词子集中，分数最高的单词集合的得分。
单词拼写游戏的规则概述如下：
玩家需要用字母表 letters 里的字母来拼写单词表 words 中的单词。
可以只使用字母表 letters 中的部分字母，但是每个字母最多被使用一次。
单词表 words 中每个单词只能计分（使用）一次。
根据字母得分情况表score，字母 'a', 'b', 'c', ... , 'z' 对应的得分分别为 score[0], score[1], ..., score[25]。
本场游戏的「得分」是指：玩家所拼写出的单词集合里包含的所有字母的得分之和。
 */
public class Solution1255 {
    int[] number = new int[26];
    int[] used = new int[26];
    int[] wordScore;
    int[] visited;
    String[] w;
    int ans = 0;
    int[][] letterCount;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        w = words;
        wordScore = new int[words.length];
        visited = new int[words.length];
        letterCount = new int[words.length][26];
        for (char letter : letters) {
            number[letter - 'a'] += 1;
        }
        for (int i = 0; i < words.length; i++) {
            String tmp = "";
            for (int j = 0; j < words[i].length(); j++) {
                int index = words[i].charAt(j) - 'a';
                letterCount[i][index] += 1;
                if (letterCount[i][index] == 1) {
                    tmp += words[i].charAt(j);
                }
            }
            words[i] = tmp;
        }
        for (int i = 0; i < words.length; i++) {
            int tmp = 0;
            int l = words[i].length();
            for (int j = 0; j < l; j++) {
                int index = words[i].charAt(j) - 'a';
                if (letterCount[i][index] > number[index]) {
                    tmp = -1;
                    break;
                } else {
                    tmp += score[index] * letterCount[i][index];
                }
            }
            wordScore[i] = tmp;
        }
        seek(0);
        return ans;
    }

    public void seek(int score) {
        if (score > ans) ans = score;
        for (int i = 0; i < w.length; i++) {
            if (visited[i] == 0) {
                boolean flag = true;
                for (int j = 0; j < w[i].length(); j++) {
                    int index = w[i].charAt(j) - 'a';
                    if (used[index] + letterCount[i][index] > number[index]) {
                        flag = false;
                        break;
                    }
                }
                if (!flag) continue;
                for (int j = 0; j < w[i].length(); j++) {
                    used[w[i].charAt(j) - 'a'] += letterCount[i][w[i].charAt(j) - 'a'];
                }
                visited[i] = 1;
                seek(score + wordScore[i]);
                visited[i] = 0;
                for (int j = 0; j < w[i].length(); j++) {
                    used[w[i].charAt(j) - 'a'] -= letterCount[i][w[i].charAt(j) - 'a'];
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] w = {"leetcode"};
        char[] letters = {'l', 'e', 't', 'c', 'o', 'd'};
        int[] scores = {0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0};
        System.out.println(new Solution1255().maxScoreWords(w, letters, scores));
    }
}
