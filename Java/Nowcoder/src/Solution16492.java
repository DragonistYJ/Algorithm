import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author yujian
 * @since 2022/12/15 11:13
 * <p>
 * 一条狭长的纸带被均匀划分出了 n 个格子，格子编号从 1 到 n 。每个格子上都染了一种颜色 colori 用 [1,m] 当中的一个整数表示），并且写了一个数字 numberi 。
 * 定义一种特殊的三元组： (x,y,z) ，其中 x,y,z 都代表纸带上格子的编号，这里的三元组要求满足以下两个条件：
 * 1.x,y,z 是整数, x<y<z,y-x=z-y
 * 2.colorx=colorz
 * 满足上述条件的三元组的分数规定为 (x+z) x (numberx+numberz) 。
 * 整个纸带的分数规定为所有满足条件的三元组的分数的和。
 * 这个分数可能会很大，你只要输出整个纸带的分数除以 10,007 所得的余数即可。
 */
public class Solution16492 {
    private static class Node {
        private final int index;
        private final long number;

        public Node(int index, long number) {
            this.index = index;
            this.number = number;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", number=" + number +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long[] numbers = new long[n];
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextLong();
        }
        for (int i = 0; i < n; i++) {
            colors[i] = scanner.nextInt();
        }

        List<List<Node>> nodesList = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            nodesList.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            nodesList.get(colors[i] - 1).add(new Node(i + 1, numbers[i]));
        }
        long ans = 0;
        for (List<Node> nodes : nodesList) {
            int size = nodes.size();
            for (int i = 0; i < size - 1; i++) {
                Node node1 = nodes.get(i);
                for (int j = i + 1; j < size; j++) {
                    Node node2 = nodes.get(j);
                    if ((node2.index - node1.index) % 2 == 0) {
                        ans += (node1.index + node2.index) * (node1.number + node2.number);
                        ans %= 10007;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
