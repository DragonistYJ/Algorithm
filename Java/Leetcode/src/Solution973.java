import java.util.ArrayList;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;

/*
NO973 最接近原点的K个点
我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
（这里，平面上两点之间的距离是欧几里德距离。）
你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 */
public class Solution973 {
    public int[][] kClosest(int[][] points, int K) {
        int[][] ans = new int[K][2];
        List<SimpleEntry<Integer, Integer>> pointList = new ArrayList<>();
        for (int[] point : points) {
            pointList.add(new SimpleEntry<>(point[0], point[1]));
        }
        pointList.sort((o1, o2) -> o1.getKey() * o1.getKey() + o1.getValue() * o1.getValue() - o2.getKey() * o2.getKey() - o2.getValue() * o2.getValue());
        for (int i = 0; i < K; i++) {
            ans[i][0] = pointList.get(i).getKey();
            ans[i][1] = pointList.get(i).getValue();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] x = {{3, 3}, {5, -1}, {-2, 4}};
        int[][] ints = new Solution973().kClosest(x, 2);
        for (int[] anInt : ints) {
            System.out.println(anInt[0] + " " + anInt[1]);
        }
    }
}
