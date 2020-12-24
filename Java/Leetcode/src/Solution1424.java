import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName Solution1424
 * @Author 11214
 * @Date 2020/6/5
 * @Description 对角线遍历2
 * 给你一个列表 nums ，里面每一个元素都是一个整数列表。请你依照下面各图的规则，按顺序返回 nums 中对角线上的整数。
 */
public class Solution1424 {
    private class Number {
        private int number;
        private int x;
        private int y;

        public Number(int number, int x, int y) {
            this.number = number;
            this.x = x;
            this.y = y;
        }
    }

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Number> numbers = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            int size = nums.get(i).size();
            for (int j = 0; j < size; j++) {
                numbers.add(new Number(nums.get(i).get(j), i, j));
            }
        }
        int n = numbers.size();
        numbers.sort((o1, o2) -> o1.x + o1.y == o2.x + o2.y ? o1.y - o2.y : o1.x + o1.y - o2.x - o2.y);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = numbers.get(i).number;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
