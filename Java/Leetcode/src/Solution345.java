import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author 11214
 * @since 2022/12/31 11:32
 */
public class Solution345 {
    public String reverseVowels(String s) {
        HashSet<Character> letters = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        List<Integer> reverseIndexes = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (letters.contains(s.charAt(i))) {
                reverseIndexes.add(i);
            }
        }
        StringBuilder builder = new StringBuilder(s);
        for (int i = 0, j = reverseIndexes.size() - 1; i < j; i++, j--) {
            Integer indexI = reverseIndexes.get(i);
            Integer indexJ = reverseIndexes.get(j);
            char c = builder.charAt(indexI);
            builder.setCharAt(indexI, builder.charAt(indexJ));
            builder.setCharAt(indexJ, c);
        }
        return builder.toString();
    }
}
