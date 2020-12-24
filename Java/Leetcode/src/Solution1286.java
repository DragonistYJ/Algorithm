/**
 * @ClassName Solution1357
 * @Author 11214
 * @Date 2020/6/11
 * @Description 字母组合迭代器
 * 请你设计一个迭代器类，包括以下内容：
 * 一个构造函数，输入参数包括：一个 有序且字符唯一 的字符串 characters（该字符串只包含小写英文字母）和一个数字 combinationLength 。
 * 函数 next() ，按 字典序 返回长度为 combinationLength 的下一个字母组合。
 * 函数 hasNext() ，只有存在长度为 combinationLength 的下一个字母组合时，才返回 True；否则，返回 False。
 */
public class Solution1286 {
    private static class CombinationIterator {
        private int[] indexes;
        private String characters;
        private int combinationLength;
        private int n;
        private boolean hasNext;

        public CombinationIterator(String characters, int combinationLength) {
            this.n = characters.length();
            this.combinationLength = combinationLength;
            this.characters = characters;
            this.indexes = new int[combinationLength];
            for (int i = 0; i < combinationLength; i++) {
                indexes[i] = i;
            }
            this.hasNext = true;
        }

        public String next() {
            if (!hasNext) return null;

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < combinationLength; i++) {
                builder.append(characters.charAt(indexes[i]));
            }

            int k = combinationLength - 1;
            while (k >= 0 && indexes[k] == n - combinationLength + k) k -= 1;
            if (k < 0) {
                hasNext = false;
            } else {
                indexes[k] += 1;
                for (int i = k + 1; i < combinationLength; i++) {
                    indexes[i] = indexes[i - 1] + 1;
                }
            }

            return builder.toString();
        }

        public boolean hasNext() {
            return hasNext;
        }
    }

    public static void main(String[] args) {
        CombinationIterator abcde = new CombinationIterator("abcde", 1);
        while (abcde.hasNext()) {
            System.out.println(abcde.next());
        }
    }
}
