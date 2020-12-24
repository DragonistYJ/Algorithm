import java.util.ArrayList;
import java.util.List;

/*
NO119 杨辉三角形
给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 */
public class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        ans.add(tmp);
        if (rowIndex == 0) return tmp;
        tmp = new ArrayList<>();
        tmp.add(1);
        tmp.add(1);
        ans.add(tmp);
        if (rowIndex == 1) return tmp;

        for (int i = 2; i <= rowIndex; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i; j++) {
                list.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
            }
            list.add(1);
            ans.add(list);
        }
        return ans.get(rowIndex);
    }

    public static void main(String[] args) {
        System.out.println(new Solution119().getRow(2));
    }
}
