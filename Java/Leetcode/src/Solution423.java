import java.util.*;

/**
 * @author yujian
 * @since 2022/9/13 10:42
 * 给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。
 */
public class Solution423 {
    public String originalDigits(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        int x = map.getOrDefault('x', 0);
        for (int i = 0; i < x; i++) {
            ans.add(6);
        }
        int z = map.getOrDefault('z', 0);
        for (int i = 0; i < z; i++) {
            ans.add(0);
        }
        int w = map.getOrDefault('w', 0);
        for (int i = 0; i < w; i++) {
            ans.add(2);
        }
        int g = map.getOrDefault('g', 0);
        for (int i = 0; i < g; i++) {
            ans.add(8);
        }
        int h = map.getOrDefault('h', 0);
        for (int i = 0; i < h - g; i++) {
            ans.add(3);
        }
        int u = map.getOrDefault('u', 0);
        for (int i = 0; i < u; i++) {
            ans.add(4);
        }
        int f = map.getOrDefault('f', 0);
        for (int i = 0; i < f - u; i++) {
            ans.add(5);
        }
        int s_ = map.getOrDefault('s', 0);
        for (int i = 0; i < s_ - x; i++) {
            ans.add(7);
        }
        int i_ = map.getOrDefault('i', 0);
        for (int i = 0; i < i_ - (f - u) - x - g; i++) {
            ans.add(9);
        }
        int o = map.getOrDefault('o', 0);
        for (int i = 0; i < o - z - w - u; i++) {
            ans.add(1);
        }
        ans.sort(Comparator.comparingInt(o2 -> o2));
        StringBuilder builder = new StringBuilder();
        for (Integer i : ans) {
            builder.append(i);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution423().originalDigits("zerozero"));
    }
}
