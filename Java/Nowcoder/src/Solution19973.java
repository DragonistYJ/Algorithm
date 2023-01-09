import java.util.*;

/**
 * @author 11214
 * @since 2023/1/9 10:43
 */

// 记忆化搜搜，超时
class Search {
    private static final HashMap<String, boolean[]> map = new HashMap<>();
    private static final HashMap<String, boolean[]> memory = new HashMap<>();

    public static void read(Scanner scanner, int n, String origin) {
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            if (!map.containsKey(s)) {
                map.put(s, new boolean[4]);
            }
            map.get(s)[getIndex(origin)] = true;
        }
    }

    public static int getIndex(String s) {
        return switch (s) {
            case "W" -> 0;
            case "I" -> 1;
            case "N" -> 2;
            case "G" -> 3;
            default -> -1;
        };
    }

    public static String getString(int i) {
        if (i == 0) {
            return "W";
        } else if (i == 1) {
            return "I";
        } else if (i == 2) {
            return "N";
        } else if (i == 3) {
            return "G";
        }
        return "";
    }

    public static boolean[] dp(String s) {
        if (memory.containsKey(s)) {
            return memory.get(s);
        }
        if (s.length() == 1) {
            boolean[] mm = new boolean[4];
            mm[getIndex(s)] = true;
            memory.put(s, mm);
            return mm;
        }
        if (s.length() == 2) {
            boolean[] mm = new boolean[4];
            if (map.containsKey(s)) {
                boolean[] memo = map.get(s);
                System.arraycopy(memo, 0, mm, 0, 4);
            }
            memory.put(s, mm);
            return mm;
        }

        boolean[] mm = new boolean[4];
        for (int i = 1; i < s.length(); i++) {
            boolean[] first = dp(s.substring(0, i));
            boolean[] second = dp(s.substring(i));
            for (int j = 0; j < 4; j++) {
                if (!first[j]) {
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    if (!second[k]) {
                        continue;
                    }
                    String ss = getString(j) + getString(k);
                    if (map.containsKey(ss)) {
                        boolean[] memo = map.get(ss);
                        for (int l = 0; l < 4; l++) {
                            if (memo[l]) {
                                mm[l] = true;
                            }
                        }
                    }
                }
            }
        }
        memory.put(s, mm);
        return mm;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W = scanner.nextInt();
        int I = scanner.nextInt();
        int N = scanner.nextInt();
        int G = scanner.nextInt();
        read(scanner, W, "W");
        read(scanner, I, "I");
        read(scanner, N, "N");
        read(scanner, G, "G");
        String s = scanner.next();
        boolean[] result = dp(s);
        boolean flag = false;
        for (int i = 0; i < 4; i++) {
            if (result[i]) {
                System.out.print(getString(i));
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("The name is wrong!");
        }
    }
}

public class Solution19973 {
    private static final HashMap<String, boolean[]> map = new HashMap<>();

    public static int getIndex(char c) {
        if (c == 'W') {
            return 0;
        } else if (c == 'I') {
            return 1;
        } else if (c == 'N') {
            return 2;
        } else if (c == 'G') {
            return 3;
        }
        return -1;
    }

    public static String getString(int i) {
        if (i == 0) {
            return "W";
        } else if (i == 1) {
            return "I";
        } else if (i == 2) {
            return "N";
        } else if (i == 3) {
            return "G";
        }
        return "";
    }

    public static void read(Scanner scanner, int n, char c) {
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            if (!map.containsKey(s)) {
                map.put(s, new boolean[4]);
            }
            map.get(s)[getIndex(c)] = true;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W = scanner.nextInt();
        int I = scanner.nextInt();
        int N = scanner.nextInt();
        int G = scanner.nextInt();
        read(scanner, W, 'W');
        read(scanner, I, 'I');
        read(scanner, N, 'N');
        read(scanner, G, 'G');
        String s = scanner.next();
        int len = s.length();
        boolean[][][] dp = new boolean[len][len][4];
        for (int i = 0; i < len; i++) {
            dp[i][i] = new boolean[4];
            dp[i][i][getIndex(s.charAt(i))] = true;
        }
        for (int l = 2; l <= len; l++) {
            for (int start = 0; start <= len - l; start++) {
                int end = start + l - 1; // include
                boolean[] m = new boolean[4];
                for (int i = start; i < end; i++) {
                    boolean[] first = dp[start][i];
                    boolean[] second = dp[i + 1][end];
                    for (int i1 = 0; i1 < 4; i1++) {
                        if (!first[i1]) {
                            continue;
                        }
                        for (int i2 = 0; i2 < 4; i2++) {
                            if (!second[i2]) {
                                continue;
                            }
                            String ss = getString(i1) + getString(i2);
                            if (map.containsKey(ss)) {
                                boolean[] booleans = map.get(ss);
                                for (int i3 = 0; i3 < booleans.length; i3++) {
                                    if (booleans[i3]) {
                                        m[i3] = true;
                                    }
                                }
                            }
                        }
                    }
                }
                dp[start][end] = m;
            }
        }

        boolean[] result = dp[0][len - 1];
        boolean flag = false;
        for (int i = 0; i < 4; i++) {
            if (result[i]) {
                System.out.print(getString(i));
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("The name is wrong!");
        }
    }
}
