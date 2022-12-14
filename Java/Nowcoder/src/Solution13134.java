import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 11214
 * @since 2022/12/14 12:15
 */
public class Solution13134 {
    public static boolean canMerge(List<Integer> preList, List<Integer> nextList) {
        if (preList.size() == 1 || nextList.size() == 1) {
            return true;
        }
        if (nextList.get(1) - preList.get(preList.size() - 1) >= 2) {
            return true;
        }
        if (nextList.get(0) - preList.get(preList.size() - 2) >= 2) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        List<List<Integer>> segments = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int anInt = in.nextInt();
            if (list.size() != 0 && anInt <= list.get(list.size() - 1)) {
                segments.add(list);
                list = new ArrayList<>();
            }
            list.add(anInt);
        }
        segments.add(list);

        if (segments.size() == 1) {
            System.out.println(segments.get(0).size());
            return;
        }

        int ans = 0;
        // 第1个
        if (canMerge(segments.get(0), segments.get(1))) {
            ans = Math.max(ans, segments.get(0).size() + segments.get(1).size());
        } else {
            ans = Math.max(ans, segments.get(0).size() + 1);
        }
        // 最后一个
        if (canMerge(segments.get(segments.size() - 2), segments.get(segments.size() - 1))) {
            ans = Math.max(ans, segments.get(segments.size() - 2).size() + segments.get(segments.size() - 1).size());
        } else {
            ans = Math.max(ans, segments.get(segments.size() - 1).size() + 1);
        }

        for (int i = 1; i < segments.size() - 1; i++) {
            int len = segments.get(i).size();
            if (canMerge(segments.get(i - 1), segments.get(i))) {
                ans = Math.max(ans, len + segments.get(i - 1).size());
            } else if (canMerge(segments.get(i), segments.get(i + 1))) {
                ans = Math.max(ans, len + segments.get(i + 1).size());
            } else {
                ans = Math.max(ans, len + 1);
            }
        }
        System.out.println(ans);
    }
}
