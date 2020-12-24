import java.util.*;

/**
 * @ClassName Solution451
 * @Author 11214
 * @Date 2020/6/3
 * @Description TODO
 */
public class Solution451 {
    public String frequencySort(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1);
        }
//        排序更快
//        List<Character> list = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            list.add(s.charAt(i));
//        }
//        list.sort(new Comparator<Character>() {
//            @Override
//            public int compare(Character o1, Character o2) {
//                int n2 = hashMap.get(o2);
//                int n1 = hashMap.get(o1);
//                if (n1 == n2) return Character.compare(o1, o2);
//                else return n2 - n1;
//            }
//        });

        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                int n2 = hashMap.get(o2);
                int n1 = hashMap.get(o1);
                if (n1 == n2) return Character.compare(o1, o2);
                else return n2 - n1;
            }
        });
        for (int i = 0; i < n; i++) {
            queue.offer(s.charAt(i));
        }

        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            builder.append(queue.poll());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(new Solution451().frequencySort(s));
    }
}
