class Solution {
    public boolean differByOne(String[] dict) {
        Set<String> set = new HashSet<>();
        StringBuilder sb = null; //define just one string builder to save memory
        for (String d : dict) {
            sb = new StringBuilder(d);
            for (int i = 0; i < d.length(); i++) {
                char origin = sb.charAt(i);
                sb.setCharAt(i, '*');
                String candidate = sb.toString();
                if (!set.add(candidate)) return true;
                sb.setCharAt(i, origin);
            }
            sb.setLength(0);
        }
        return false;
    }
}
