import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
NO950 按递增顺序显示卡牌
牌组中的每张卡牌都对应有一个唯一的整数。你可以按你想要的顺序对这套卡片进行排序。
最初，这些卡牌在牌组里是正面朝下的（即，未显示状态）。

现在，重复执行以下步骤，直到显示所有卡牌为止：
从牌组顶部抽一张牌，显示它，然后将其从牌组中移出。
如果牌组中仍有牌，则将下一张处于牌组顶部的牌放在牌组的底部。
如果仍有未显示的牌，那么返回步骤 1。否则，停止行动。
返回能以递增顺序显示卡牌的牌组顺序。
答案中的第一张牌被认为处于牌堆顶部。
 */
public class Solution950 {
    public int[] deckRevealedIncreasing(int[] deck) {
        int len = deck.length;
        Arrays.sort(deck);
        List<Integer> positions = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            positions.add(i);
        }
        int[] ans = new int[len];
        int k = 0;
        int index = 0;
        while (!positions.isEmpty()) {
            Integer position = positions.get(index);
            positions.remove(index);
            ans[position] = deck[k];
            k += 1;
            if (!positions.isEmpty()) {
                index = (index + 1) % positions.size();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {17, 13, 11, 2, 3, 5, 7};
        System.out.println(Arrays.toString(new Solution950().deckRevealedIncreasing(nums)));
    }
}
