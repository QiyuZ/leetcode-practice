/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        int[] count = new int[26];
        for (String s : wordlist) {
            for (char ch : s.toCharArray()) count[ch - 'a']++;
        }
        Set<String> set = new HashSet<>();
        for (String s : wordlist) set.add(s);
        int i = 0;
        while (i++ < 10) {
            String best = getBest(set, count); //先找词频最多的
            int match = master.guess(best);
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {  //注意for循环set不能做add/remove操作，只能iterator
                if (match(it.next(), best) != match) it.remove(); 
                //首先知道best字符有match个位置，那么不等于match的肯定不对，比如best match了3位，best肯定不对，就缩小范围从match3位中再次挑选
            }
        }
    }
    public String getBest(Set<String> set, int[] count) {
        int max = 0;
        String best = "";
        for (String s : set) {
            int num = 0;
            for (char ch : s.toCharArray()) num += count[ch - 'a'];
            if (num > max) {
                max = num;
                best = s;
            }
        }
        return best;
    }
    public int match(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) count++;
        }
        return count;
    }
}



class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        Random rand = new Random();
        List<String> words = new ArrayList<>();
        for (String w : wordlist) words.add(w);
        for (int i = 0; i < 10; i++) {
            String chosen = words.get(rand.nextInt(words.size()));
            int res = master.guess(chosen);
            if (res == 6) return;
            List<String> next = new ArrayList<>();
            for (String w : words) {
                if (!w.equals(chosen) && res == countMatches(w, chosen)) next.add(w); //choose the one has same matches with target, ignore others
            }
            words = next;
        }
    }
    
    private int countMatches(String a, String b) {
        int matches = 0, i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i++) == b.charAt(j++)) matches++;
        }
        return matches;
    }
}
