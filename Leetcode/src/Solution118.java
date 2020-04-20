import java.util.ArrayList;
import java.util.List;

/*
NO118 杨辉三角
给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 */
public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 0) return ans;
        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        ans.add(tmp);
        if (numRows == 1) return ans;
        tmp = new ArrayList<>();
        tmp.add(1);
        tmp.add(1);
        ans.add(tmp);
        if (numRows == 2) return ans;

        for (int i = 3; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i - 1; j++) {
                list.add(ans.get(i - 2).get(j - 1) + ans.get(i - 2).get(j));
            }
            list.add(1);
            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> generate = new Solution118().generate(5);
        for (List<Integer> list : generate) {
            System.out.println(list);
        }
    }
}
