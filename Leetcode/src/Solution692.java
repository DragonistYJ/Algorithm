import java.util.*;

/**
 * @ClassName Solution692
 * @Author 11214
 * @Date 2020/6/2
 * @Description TODO
 */
public class Solution692 {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String word : words) {
            hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (hashMap.get(o1).equals(hashMap.get(o2))) {
                    return o1.compareTo(o2);
                } else return hashMap.get(o2) - hashMap.get(o1);
            }
        });

        Set<String> keySet = hashMap.keySet();
        for (String key : keySet) {
            queue.offer(key);
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(queue.poll());
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] strings = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        System.out.println(new Solution692().topKFrequent(strings, 4));
    }
}
