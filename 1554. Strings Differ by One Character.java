class Solution {
    public boolean differByOne(String[] dict) {
        Set<String> set = new HashSet<>();
        for (String d : dict) {
            for (int i = 0; i < d.length(); i++) {
                StringBuilder sb = new StringBuilder(d);
                sb.setCharAt(i, '*');
                String candidate = sb.toString();
                if (!set.add(candidate)) return true;
            }
        }
        return false;
    }
}
