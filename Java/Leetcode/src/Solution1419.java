/**
 * 数青蛙
 * 给你一个字符串 croakOfFrogs，它表示不同青蛙发出的蛙鸣声（字符串 "croak" ）的组合。由于同一时间可以有多只青蛙呱呱作响，所以 croakOfFrogs 中会混合多个 “croak” 。请你返回模拟字符串中所有蛙鸣所需不同青蛙的最少数目。
 * 注意：要想发出蛙鸣 "croak"，青蛙必须 依序 输出 ‘c’, ’r’, ’o’, ’a’, ’k’ 这 5 个字母。如果没有输出全部五个字母，那么它就不会发出声音。
 * 如果字符串 croakOfFrogs 不是由若干有效的 "croak" 字符混合而成，请返回 -1 。
 */
public class Solution1419 {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] states = new int[4];
        int ans = 0;
        int n = croakOfFrogs.length();
        for (int i = 0; i < n; i++) {
            char c = croakOfFrogs.charAt(i);
            if (c == 'c') {
                states[0] += 1;
            } else if (c == 'r') {
                states[0] -= 1;
                states[1] += 1;
            } else if (c == 'o') {
                states[1] -= 1;
                states[2] += 1;
            } else if (c == 'a') {
                states[2] -= 1;
                states[3] += 1;
            } else if (c == 'k') {
                states[3] -= 1;
            }
            for (int j = 0; j < 4; j++) {
                if (states[j] < 0) return -1;
            }
            ans = Math.max(ans, states[0] + states[1] + states[2] + states[3]);
        }

        for (int i = 0; i < 4; i++) {
            if (states[i] != 0) return -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1419().minNumberOfFrogs("aoocrrackk"));
    }
}
