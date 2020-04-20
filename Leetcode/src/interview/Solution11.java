package interview;

/**
 * @ClassName Solution11
 * @Author 11214
 * @Date 2020/4/11
 * @Description TODO
 */
public class Solution11 {
    public int minArray(int[] numbers) {
        int index = 0;
        for (int i =0; i<numbers.length -1; i++) {
            if (numbers[i] > numbers[i+1]) {
                index = i+1;
                break;
            }
        }
        return numbers[index];
    }

    public static void main(String[] args) {
        int[] numbers = {2,2,2,2,1};
        System.out.println(new Solution11().minArray(numbers));
    }
}
