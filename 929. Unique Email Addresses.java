class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String e : emails) {
            String pre = e.split("@")[0].split("\\+")[0].replace(".", "");
            String post = e.split("@")[1];
            set.add(pre + "@" + post);
        }
        return set.size();
    }
}
