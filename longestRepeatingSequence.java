import java.util.Arrays;

public class longestRepeatingSequence {
    public static String getLong(String str) {
        if (str == null || str.length() == 0) return "";
        String[] suffix = new String[str.length()];
        for (int i = 0; i < suffix.length; i++) {
            suffix[i] = str.substring(i);
        }
        Arrays.sort(suffix);
        String res = "";
        for (int i = 0; i < suffix.length - 1; i++) {
            String cur = suffix[i], next = suffix[i + 1];
            int len = Math.min(cur.length(), next.length());
            int a = 0, b = 0;
            while (a < len && b < len) {
                if (cur.charAt(a) != next.charAt(b)) break;
                else {
                    a++;
                    b++;
                }
            }
            if (res.length() < a + 1) res = cur.substring(0, a);
        }
        return res;
    }

    public static void main(String[] args) {
        String test = "abcbca";
        System.out.println(longestRepeatingSequence.getLong(test));
    }
}
