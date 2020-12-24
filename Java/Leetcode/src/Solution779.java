/**
 * @ClassName Solution779
 * @Author 11214
 * @Date 2020/4/20
 * @Description TODO
 */
public class Solution779 {
    public int kthGrammar(int N, int K) {
        if (N == 1) return 0;
        int t = kthGrammar(N - 1, (K + 1) / 2);
        if (K % 2 == 1) {
            if (t == 0) return 0;
            else return 1;
        } else {
            if (t == 0) return 1;
            else return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution779().kthGrammar(2, 1));
    }
}
