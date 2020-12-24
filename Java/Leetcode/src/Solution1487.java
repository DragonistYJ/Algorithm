import java.util.Arrays;
import java.util.HashMap;

/**
 * 保证文件名唯一
 * 给你一个长度为 n 的字符串数组 names 。你将会在文件系统中创建 n 个文件夹：在第 i 分钟，新建名为 names[i] 的文件夹。
 * 由于两个文件 不能 共享相同的文件名，因此如果新建文件夹使用的文件名已经被占用，系统会以 (k) 的形式为新文件夹的文件名添加后缀，其中 k 是能保证文件名唯一的 最小正整数 。
 * 返回长度为 n 的字符串数组，其中 ans[i] 是创建第 i 个文件夹时系统分配给该文件夹的实际名称。
 */
public class Solution1487 {
    public String[] getFolderNames(String[] names) {
        int n = names.length;
        String[] ans = new String[n];
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!hashMap.containsKey(names[i])) {
                ans[i] = names[i];
                hashMap.put(names[i], 1);
            } else {
                int index = hashMap.get(names[i]);
                String s;
                do {
                    s = names[i] + "(" + index + ")";
                    index += 1;
                } while (hashMap.containsKey(s));
                ans[i] = s;
                hashMap.put(s, 1);
                hashMap.put(names[i], index);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] names = {"kaido", "kaido(1)", "kaido", "kaido(1)", "kaido(2)"};
        System.out.println(Arrays.toString(new Solution1487().getFolderNames(names)));
    }
}
