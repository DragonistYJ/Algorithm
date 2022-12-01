import java.util.*;

/**
 * @author 11214
 * @since 2022/12/1 10:07
 * <p>
 * 给定一组 n 人（编号为 1, 2, ..., n）， 我们想把每个人分进任意大小的两组。每个人都可能不喜欢其他人，那么他们不应该属于同一组。
 * 给定整数 n 和数组 dislikes ，其中 dislikes[i] = [ai, bi] ，表示不允许将编号为 ai 和  bi的人归入同一组。
 * 当可以用这种方法将所有人分进两组时，返回 true；否则返回 false。
 */
public class Solution886 {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        if (dislikes.length == 0) {
            return true;
        }

        List<Set<Integer>> dislikeList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            dislikeList.add(new HashSet<>());
        }
        for (int[] dislike : dislikes) {
            dislikeList.get(dislike[0]).add(dislike[1]);
            dislikeList.get(dislike[1]).add(dislike[0]);
        }

        Set<Integer> partition1 = new HashSet<>();
        Set<Integer> partition2 = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (partition1.contains(i) || partition2.contains(i) || dislikeList.get(i).isEmpty()) {
                continue;
            }
            Queue<Integer> queue = new ArrayDeque<>();
            queue.addAll(dislikeList.get(i));
            partition1.add(i);
            partition2.addAll(dislikeList.get(i));

            while (!queue.isEmpty()) {
                Integer person = queue.poll();
                Set<Integer> dislikeSet = dislikeList.get(person);
                Set<Integer> partition = partition1.contains(person) ? partition1 : partition2;
                Set<Integer> opPartition = partition1.contains(person) ? partition2 : partition1;
                for (Integer dislike : dislikeSet) {
                    if (partition.contains(dislike)) {
                        return false;
                    }
                    if (!partition.contains(dislike) && !opPartition.contains(dislike)) {
                        queue.offer(dislike);
                    }
                    opPartition.add(dislike);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] dislikes = new int[][]{{1, 2}, {2, 3}, {4, 5}, {3, 5}};
        System.out.println(new Solution886().possibleBipartition(5, dislikes));
    }
}
