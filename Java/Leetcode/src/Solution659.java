import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author 11214
 * @since 2022/11/23 10:00
 * <p>
 * 给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个长度至少为 3 的子序列，其中每个子序列都由连续整数组成。
 * 如果可以完成上述分割，则返回 true ；否则，返回 false 。
 */
public class Solution659 {
    private static class Struct {
        public int num;
        public int length;
        public int max;

        public Struct(int num, int length, int max) {
            this.num = num;
            this.length = length;
            this.max = max;
        }

        @Override
        public String toString() {
            return "Struct{" +
                    "num=" + num +
                    ", length=" + length +
                    ", max=" + max +
                    '}';
        }
    }

    public boolean isPossible(int[] nums) {
        int min = nums[0];
        int max = nums[nums.length - 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Struct> structs = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (!map.containsKey(i)) {
                for (Struct struct : structs) {
                    if (struct.length < 3) {
                        return false;
                    }
                }
                continue;
            }
            int total = map.get(i);
            int finalI = i;
            structs.removeIf(struct -> struct.length >= 3 && struct.max != finalI - 1);
            for (int j = structs.size() - 1; j >= 0; j--) {
                if (total == 0) {
                    break;
                }

                Struct struct = structs.get(j);
                if (total >= struct.num) {
                    struct.length += 1;
                    struct.max += 1;
                    total -= struct.num;
                } else {
                    if (struct.length < 3) {
                        return false;
                    }
                    struct.num = total;
                    struct.max += 1;
                    struct.length += 1;
                    total = 0;
                }
            }
            if (total != 0) {
                Struct struct = new Struct(total, 1, i);
                structs.add(struct);
            }
        }

        for (Struct struct : structs) {
            if (struct.length < 3) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 5, 5, 6, 6, 7, 8, 8, 9};
        System.out.println(new Solution659().isPossible(nums));
    }
}
