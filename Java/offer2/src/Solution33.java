import java.util.*;

/**
 * @author 11214
 * @since 2023/3/31 11:52
 */
public class Solution33 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<String[]> list = new ArrayList<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            list.add(new String[]{s, str});
        }
        list.sort(Comparator.comparing(s -> s[0]));

        List<List<String>> ans = new ArrayList<>();
        int i = 0;
        while (i < strs.length) {
            int j = i + 1;
            String s = list.get(i)[0];
            while (j < strs.length && list.get(j)[0].equals(s)) {
                j += 1;
            }
            List<String> ss = new ArrayList<>();
            for (int k = i; k < j; k++) {
                ss.add(list.get(k)[1]);
            }
            ans.add(ss);

            i = j;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(26, 26));
        System.out.println(Long.MAX_VALUE);
    }
}
