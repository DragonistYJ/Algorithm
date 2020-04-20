import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @problem 手机号码
 * @category 暴力枚举
 * @author 11214
 * @description 给你一个整数n表示手机号码的位数 再给你m个字符串表示保留的号码,比如911 110 120等
 *              问你一共有多少的手机号码不以保留号码开头
 */
public class Solution21297 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();

		List<String> prefixList = new ArrayList<String>();
		for (int i = 0; i < m; i++) {
			String line = scanner.next();
			int index = 0;
			boolean flag = true;
			while (index < prefixList.size()) {
				if (prefixList.get(index).startsWith(line)) {
					prefixList.remove(index);
				} else if (line.startsWith(prefixList.get(index))) {
					flag = false;
					break;
				} else {
					index += 1;
				}
			}
			if (flag)
				prefixList.add(line);
		}

		BigInteger ans = BigInteger.TEN.pow(n);
		for (String prefix : prefixList) {
			BigInteger number = BigInteger.TEN.pow(n - prefix.length());
			ans = ans.subtract(number);
		}
		System.out.println(ans.longValue());
	}
}
