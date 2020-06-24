import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName Solutoin187
 * @Author 11214
 * @Date 2020/6/24
 * @Description 重复的DNA
 * 所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 * 编写一个函数来查找目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 */
public class Solution187 {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for (int i =0 ; i<s.length() -9; i++) {
            String subString = s.substring(i, i+10);
            hashMap.put(subString, hashMap.getOrDefault(subString, 0) +1);
            if (hashMap.get(subString) == 2) ans.add(subString);
        }
        return ans;
    }
}
