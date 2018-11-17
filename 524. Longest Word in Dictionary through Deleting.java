//不用sort
class Solution {
    public String findLongestWord(String s, List<String> d) {
        String longest = "";
        for (String dictWord : d) {
            if (dictWord.length() < longest.length()) continue;
            int i = 0;
            for (char c : s.toCharArray()) 
                if (i < dictWord.length() && c == dictWord.charAt(i)) i++;
            if (i == dictWord.length()) 
                if (dictWord.length() > longest.length() || (dictWord.length() == longest.length() && dictWord.compareTo(longest) < 0)) 
                    longest = dictWord;
        }
        return longest;
    }
}

//sort
class Solution {
    public String findLongestWord(String s, List<String> d) {
        String res = "";
        if (s == null || d.size() == 0) return "";
        Collections.sort(d);
        for (int i = 0; i < d.size(); i++) {
            if (d.get(i).length() <= res.length()) continue;
            if (canChange(s, d.get(i))) res = d.get(i);
        }
        return res;
    }
    public boolean canChange(String a, String b) {
        int inda = 0, indb = 0;
        while (inda < a.length() && indb < b.length()) {
            if (a.charAt(inda) == b.charAt(indb)) {
                inda++;
                indb++;
            } else inda++;
        }
        if (indb == b.length()) return true;
        else return false;
    }
}
