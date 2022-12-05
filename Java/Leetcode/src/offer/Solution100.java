package offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author 11214
 * @since 2022/12/5 19:26
 * <p>
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 */
public class Solution100 {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> pre = new ArrayList<>(triangle.get(0));
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> next = new ArrayList<>();
            List<Integer> integers = triangle.get(i);
            next.add(pre.get(0) + integers.get(0));
            for (int j = 1; j < integers.size() - 1; j++) {
                next.add(integers.get(j) + Math.min(pre.get(j), pre.get(j - 1)));
            }
            next.add(pre.get(integers.size() - 2) + integers.get(integers.size() - 1));
            pre = next;
        }

        return pre.stream().min(Comparator.comparingInt(o -> o)).orElse(0);
    }
}
