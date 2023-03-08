/**
 * @author 11214
 * @since 2023/3/8 17:47
 */
public class Solution6 {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                return new int[]{i, j};
            } else if (numbers[i] + numbers[j] < target) {
                i += 1;
            } else {
                j -= 1;
            }
        }
        return null;
    }
}
