class Solution {
    
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int n = username.length;
        List<String[]> combo = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            combo.add(new String[] {timestamp[i] + "", username[i], website[i]});
        }
        Collections.sort(combo, (a, b) -> Integer.parseInt(a[0]) - Integer.parseInt(b[0]));
        Map<String, List<String>> visited = new HashMap<>();
        for (String[] c : combo) {
            if (!visited.containsKey(c[1])) visited.put(c[1], new ArrayList<>());
            visited.get(c[1]).add(c[2]);
        }
        Map<String, Integer> count = new HashMap<>();
        int max = 0;
        String target = "";
        for (String user : visited.keySet()) {
            List<String> pages = visited.get(user);
            if (pages.size() < 3) continue;
            Set<String> path = getAllPath(pages);
            for (String p : path) {
                count.put(p, count.getOrDefault(p, 0) + 1);
                if (count.get(p) > max) {
                    max = count.get(p);
                    target = p;
                } else if (count.get(p) == max && p.compareTo(target) < 0) target = p;
            }
        }
        if ("".equals(target)) return new ArrayList<>();
        String[] strs = target.split("-");
        return Arrays.asList(strs);
    }
    
    private Set<String> getAllPath(List<String> pages) {
        int n = pages.size();
        String split = "-";
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    set.add(pages.get(i) + split + pages.get(j) + split + pages.get(k));
                }
            }
        }
        return set;
    }
}
