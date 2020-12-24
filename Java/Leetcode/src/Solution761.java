import java.util.*;

/*
NO761 特殊的二进制序列
特殊的二进制序列是具有以下两个性质的二进制序列：
0 的数量与 1 的数量相等。
二进制序列的每一个前缀码中 1 的数量要大于等于 0 的数量。
给定一个特殊的二进制序列 S，以字符串形式表示。定义一个操作 为首先选择 S 的两个连续且非空的特殊的子串，然后将它们交换。（两个子串为连续的当且仅当第一个子串的最后一个字符恰好为第二个子串的第一个字符的前一个字符。)
在任意次数的操作之后，交换后的字符串按照字典序排列的最大的结果是什么？
 */
public class Solution761 {
    public String makeLargestSpecial(String S) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        int start = 0;
        int one = 0;
        for (int i = 0; i < S.length(); ++i) {
            one += S.charAt(i) == '1' ? 1 : -1;
            if (one == 0) {
                String str = S.substring(start + 1, i);
                list.add("1" + makeLargestSpecial(str) + "0");
                start = i + 1;
            }
        }
        list.sort(Comparator.reverseOrder());
        for (String s : list) {
            sb.append(s);
        }
        return sb.toString();
    }

    public String makeLargestSpecial_2(String S) {
        int len = S.length();
        String ans = S;
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add(S);
        List<String> queue = new LinkedList<>();
        queue.add(S);
        while (!queue.isEmpty()) {
            String s = queue.get(0);
            queue.remove(0);
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) == '1') {
                    List<String> searches = search(s, i);
                    for (String search : searches) {
                        ans = ans.compareTo(search) > 0 ? ans : search;
                        if (!hashSet.contains(search)) {
                            hashSet.add(search);
                            queue.add(search);
                        }
                    }
                }
            }
        }

        return ans;
    }

    private List<String> search(String s, int start) {
        List<String> ans = new ArrayList<>();
        int preOne = 0;
        int preZero = 0;
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == '1') preOne += 1;
            else preZero += 1;
            if (preOne < preZero) break;
            if (preOne != preZero) continue;

            int nextOne = 0;
            int nextZero = 0;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == '1') nextOne += 1;
                else nextZero += 1;
                if (nextOne < nextZero) break;
                if (nextOne != nextZero) continue;
                String builder = s.substring(0, start) +
                        s.substring(i + 1, j + 1) +
                        s.substring(start, i + 1) +
                        s.substring(j + 1);
                ans.add(builder);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution761().makeLargestSpecial("101100101100"));
    }
}
