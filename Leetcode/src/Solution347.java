import java.util.*;

/*
NO347 前K个高频元素
给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 */
public class Solution347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if (hashMap.containsKey(num)) {
                hashMap.put(num, hashMap.get(num) + 1);
            } else {
                hashMap.put(num, 1);
            }
        }
        Set<Integer> keySet = hashMap.keySet();
        List<Pair> pairs = new ArrayList<>();
        for (Integer key : keySet) {
            pairs.add(new Pair(key, hashMap.get(key)));
        }
        pairs.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.times - o1.times;
            }
        });
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(pairs.get(i).num);
        }
        return ans;
    }

    private class Pair {
        private int num;
        private int times;

        public Pair(int num, int times) {
            this.num = num;
            this.times = times;
        }
    }

    public static void main(String[] args) {
        int[] x = {1};
        System.out.println(new Solution347().topKFrequent(x, 1));
    }
}
