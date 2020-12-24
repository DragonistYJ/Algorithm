import java.util.*;

public class Solution721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, Integer> mails = new HashMap<>();
        while (!accounts.isEmpty()) {
            List<String> account = accounts.get(accounts.size() - 1);
            accounts.remove(accounts.size() - 1);

            int index = -1;
            for (int i = 1; i < account.size(); i++) {
                if (mails.containsKey(account.get(i))) {
                    index = mails.get(account.get(i));
                    break;
                }
            }
            if (index == -1) {
                ArrayList<String> list = new ArrayList<>();
                list.add(account.get(0));
                ans.add(list);
                for (int i = 1; i < account.size(); i++) {
                    mails.put(account.get(i), ans.size() - 1);
                }
            } else {
                for (int i = 1; i < account.size(); i++) {
                    if (!mails.containsKey(account.get(i))) {
                        mails.put(account.get(i), index);
                    }
                }
            }
        }
        Set<String> keySet = mails.keySet();
        for (String key : keySet) {
            Integer index = mails.get(key);
            ans.get(index).add(key);
        }
        for (List<String> an : ans) {
            an.sort((o1, o2) -> o1.compareTo(o2));
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> a = Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com", "john00@mail.com");
        List<String> b = Arrays.asList("John", "johnnybravo@mail.com");
        List<String> c = Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com");
        List<String> d = Arrays.asList("Mary", "mary@mail.com");
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(a);
        accounts.add(b);
        accounts.add(c);
        accounts.add(d);
        System.out.println(new Solution721().accountsMerge(accounts));
    }
}
