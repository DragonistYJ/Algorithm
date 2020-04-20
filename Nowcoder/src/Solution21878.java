import java.util.Scanner;

/**
 * @problem 字符串旋转与追加
 * @category 暴力枚举
 * @author 11214
 * @description 给你两个字符串S,T，只由字符'A', 'B'构成 请问S是否能通过0或者多次如下两种操作变成T 1：在当前字符串结尾追加一个A
 *              2：反转字符串之后在结尾追加一个B
 */
public class Solution21878 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		String t = scanner.next();
		StringBuilder builder = new StringBuilder(t);
		while (builder.length() != 0) {
			if (builder.toString().equals(s)) {
				System.out.println("Possible");
				return;
			}
			if (builder.charAt(builder.length() - 1) == 'A') {
				builder.deleteCharAt(builder.length() - 1);
			} else {
				builder.deleteCharAt(builder.length() - 1);
				builder.reverse();
			}
		}
		System.out.println("Impossible");
	}
}
