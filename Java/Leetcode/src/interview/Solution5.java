package interview;

/**
 * @ClassName Solution5
 * @Author 11214
 * @Date 2020/4/11
 * @Description TODO
 */
public class Solution5 {
    public String replaceSpace(String s) {
        return s.replaceAll(" ","%20");
    }

    public static void main(String[] args) {
        System.out.println(new Solution5().replaceSpace("We are happy."));
    }
}
