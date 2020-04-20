/**
 * @ClassName Solution11
 * @Author 11214
 * @Date 2020/4/18
 * @Description TODO
 */
public class Solution11 {
    public int maxArea(int[] height) {
        int ans = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            ans = Math.max(Math.min(height[i], height[j]) * (j - 1), ans);
            if (height[i] < height[j]) {
                i += 1;
            } else {
                j -= 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
