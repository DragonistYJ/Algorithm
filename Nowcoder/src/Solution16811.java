import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Solution16811
 * @Author 11214
 * @Date 2020/4/25
 * @Description TODO
 */
public class Solution16811 {
    private static boolean check(List<Character> number) {
        int i = 0;
        int j = number.size() - 1;
        while (i < j) {
            if (number.get(i) != number.get(j)) return false;
            i += 1;
            j -= 1;
        }
        return true;
    }

    private static List<Character> add(List<Character> number, int n) {
        int len = number.size();
        List<Character> A = new ArrayList<>(number);
        List<Character> B = new ArrayList<>(number);
        Collections.reverse(B);
        List<Character> C = new ArrayList<>();
        int carry = 0;
        for (int i = 0; i < len; i++) {
            int t = A.get(i) - '0' + B.get(i) - '0' + carry;
            C.add((char) (t % n + '0'));
            carry = t / n;
        }
        if (carry != 0) C.add((char) (carry + '0'));
        return C;
    }

    private static List<Character> addHex(List<Character> number) {
        int len = number.size();
        List<Character> A = new ArrayList<>(number);
        List<Character> B = new ArrayList<>(number);
        Collections.reverse(B);
        List<Character> C = new ArrayList<>();
        int carry = 0;
        for (int i = 0; i < len; i++) {
            int a;
            if (Character.isDigit(A.get(i))) a = A.get(i) - '0';
            else if (Character.isLowerCase(A.get(i))) a = A.get(i) - 'a' + 10;
            else a = A.get(i) - 'A' + 10;
            int b;
            if (Character.isDigit(B.get(i))) b = B.get(i) - '0';
            else if (Character.isLowerCase(B.get(i))) b = B.get(i) - 'a' + 10;
            else b = B.get(i) - 'A' + 10;
            int c = a + b + carry;
            carry = c / 16;
            c = c % 16;
            if (c > 10) C.add((char) (c - 10 + 'A'));
            else C.add((char) (c + '0'));
        }
        return C;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<Character> number = new ArrayList<>();
        String string = scanner.nextLine();
        for (int i = 0; i < string.length(); i++) {
            number.add(string.charAt(i));
        }
        for (int i = 0; i < 30; i++) {
            if (check(number)) {
                System.out.println("STEP=" + i);
                return;
            }
            if (n != 16) number = add(number, n);
            else number = addHex(number);
        }
        System.out.println("Impossible!");
    }
}
