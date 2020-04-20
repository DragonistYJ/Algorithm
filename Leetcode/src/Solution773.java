import javafx.util.Pair;

import java.util.*;

/*
NO773 滑动谜题
在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示.
一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换.
最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1
 */
public class Solution773 {
    public int slidingPuzzle(int[][] board) {
        Set<String> set = new HashSet<>();
        List<Pair<String, Integer>> queue = new LinkedList<>();
        int x = 0;
        String s = "";
        for (int[] ints : board) {
            for (int anInt : ints) {
                x = x * 10 + anInt;
            }
        }
        if (board[0][0] == 0) s = "0" + x;
        else s = String.valueOf(x);
        queue.add(new Pair<>(s, 0));
        set.add(s);

        while (!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.get(0);
            queue.remove(0);
            String key = pair.getKey();
            Integer step = pair.getValue();
            if (key.equals("123450")) return step;
            List<String> moves = move(key);
            for (String move : moves) {
                if (set.contains(move)) continue;
                queue.add(new Pair<>(move, step + 1));
                set.add(move);
            }
        }

        return -1;
    }

    private List<String> move(String s) {
        List<String> list = new ArrayList<>();
        int index = s.indexOf("0");
        if (index == 0) {
            list.add(s.charAt(1) + "0" + s.substring(2));
            list.add(s.charAt(3) + s.substring(1, 3) + "0" + s.substring(4));
        } else if (index == 5) {
            list.add(s.substring(0, 4) + "0" + s.charAt(4));
            list.add(s.substring(0, 2) + "0" + s.substring(3, 5) + s.charAt(2));
        } else if (index == 2) {
            list.add(s.charAt(0) + "0" + s.charAt(1) + s.substring(3));
            list.add(s.substring(0, 2) + s.charAt(5) + s.substring(3, 5) + "0");
        } else if (index == 3) {
            list.add("0" + s.substring(1, 3) + s.charAt(0) + s.substring(4));
            list.add(s.substring(0, 3) + s.charAt(4) + "0" + s.charAt(5));
        } else if (index == 1) {
            list.add("0" + s.charAt(0) + s.substring(2));
            list.add(s.charAt(0) + "" + s.charAt(2) + "0" + s.substring(3));
            list.add(s.charAt(0) + "" + s.charAt(4) + s.substring(2, 4) + "0" + s.charAt(5));
        } else {
            list.add(s.substring(0, 4) + s.charAt(5) + "0");
            list.add(s.substring(0, 3) + "0" + s.charAt(3) + "" + s.charAt(5));
            list.add(s.charAt(0) + "0" + s.substring(2, 4) + s.charAt(1) + "" + s.charAt(5));
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] x = {{3, 2, 4}, {1, 5, 0}};
        System.out.println(new Solution773().slidingPuzzle(x));
    }
}
