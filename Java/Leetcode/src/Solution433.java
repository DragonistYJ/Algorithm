import java.util.*;

/**
 * @author yujian
 * @since 2023/7/26 16:40
 * <p>
 * 基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。
 * 假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。
 * 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
 * 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。（变化后的基因必须位于基因库 bank 中）
 * 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。如果无法完成此基因变化，返回 -1 。
 * 注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。
 */
public class Solution433 {
    static class State {
        StringBuilder sb;
        int step;

        public State(StringBuilder sb, int step) {
            this.sb = sb;
            this.step = step;
        }
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> available = new HashSet<>(Arrays.asList(bank));
        char[] bits = new char[]{'A', 'C', 'T', 'G'};

        HashSet<String> set = new HashSet<>();
        ArrayDeque<State> deque = new ArrayDeque<>();
        deque.offerLast(new State(new StringBuilder(startGene), 0));
        while (!deque.isEmpty()) {
            State state = deque.pollFirst();
            if (state.sb.toString().equals(endGene)) {
                return state.step;
            }
            if (set.contains(state.sb.toString())) {
                continue;
            }
            set.add(state.sb.toString());

            for (int i = 0; i < 8; i++) {
                char c = state.sb.charAt(i);
                for (char bit : bits) {
                    state.sb.setCharAt(i, bit);
                    if (available.contains(state.sb.toString())) {
                        deque.offerLast(new State(new StringBuilder(state.sb.toString()), state.step + 1));
                    }
                }
                state.sb.setCharAt(i, c);
            }
        }

        return -1;
    }
}
