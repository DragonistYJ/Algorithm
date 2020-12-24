import java.util.*;

/*
NO1079 活字印刷
你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
 */
public class Solution1079 {
    public int numTilePossibilities(String tiles) {
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        StringBuilder newTiles = new StringBuilder();
        for (char aChar : chars) {
            newTiles.append(aChar);
        }
        int[] factorials = new int[9];
        factorials[1] = 1;
        for (int i = 2; i < 9; i++) {
            factorials[i] = factorials[i - 1] * i;
        }
        HashSet<String> combinations = new HashSet<>();
        int len = tiles.length();
        int ans = 0;
        for (int i = 1; i <= len; i++) {
            combinations.clear();
            getCombination(combinations, "", i, newTiles.toString());
            for (String combination : combinations) {
                ans += calCombination(combination, factorials);
            }
        }
        return ans;
    }

    private void getCombination(HashSet<String> combinations, String tmp, int len, String tiles) {
        if (tmp.length() == len) {
            combinations.add(tmp);
            return;
        }
        for (int i = 0; i < tiles.length(); i++) {
            if (i > 0 && tiles.charAt(i) == tiles.charAt(i - 1)) continue;
            getCombination(combinations, tmp + tiles.charAt(i), len, tiles.substring(i + 1));
        }
    }

    private int calCombination(String s, int[] factorials) {
        int num = factorials[s.length()];
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hashMap.containsKey(c)) {
                hashMap.put(c, hashMap.get(c) + 1);
            } else {
                hashMap.put(c, 1);
            }
        }
        Set<Character> characters = hashMap.keySet();
        for (Character character : characters) {
            num /= factorials[hashMap.get(character)];
        }
        return num;
    }


    public static void main(String[] args) {
        System.out.println(new Solution1079().numTilePossibilities("AAAAAAA"));
    }
}
