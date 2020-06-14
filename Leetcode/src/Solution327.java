import java.util.TreeMap;

/**
 * @ClassName Solution327
 * @Author 11214
 * @Date 2020/6/14
 * @Description 区间和个数
 * 给定一个整数数组 nums，返回区间和在 [lower, upper] 之间的个数，包含 lower 和 upper。
 * 区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
 */
public class Solution327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums ==  null || nums.length == 0){
            return 0;
        }
        //键值为区间和和这个区间和出现的次数
        TreeMap<Long, Integer> tree = new TreeMap<>();
        tree.put(0L, 1);

        int count = 0;
        long sum = 0L;
        for(int num : nums){
            sum += num;
            //subMap()返回一个值在sum - upper 和sum - lower 之间的子集合，values()方法获得这个映射的值得视图
            for(int cnt : tree.subMap(sum - upper, true, sum - lower, true).values()){
                count += cnt; //统计满足条件的区间和个数
            }
            tree.put(sum, tree.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
