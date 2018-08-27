class Solution {
    public List<String> subdomainVisits(String[] cpdomains) { //分开储存，一个个count，再提取
        List<String> res = new ArrayList<>();
        if (cpdomains == null || cpdomains.length == 0) return res;
        Map<String, Integer> map = new HashMap<>();
        for (String str : cpdomains) {
            String[] parts = str.split(" ");
            int count = Integer.parseInt(parts[0]);
            String link = parts[1];
            map.put(link, map.getOrDefault(link, 0) + count);
            for (int i = 0; i < link.length(); i++) {
                if (link.charAt(i) == '.') {
                    String cur = link.substring(i + 1);
                    map.put(cur, map.getOrDefault(cur, 0) + count);
                }
            }
        }
        for (String s : map.keySet()) res.add(map.get(s) + " " + s);
        return res;
    }
}
