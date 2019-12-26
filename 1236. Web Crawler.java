/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */
class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        if (startUrl == null || startUrl.length() == 0) return new ArrayList<>();
        String hostName = getHostName(startUrl);
        Queue<String> queue = new LinkedList<>();
        queue.offer(startUrl);
        Set<String> visited = new HashSet<>();
        visited.add(startUrl);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            for (String url : htmlParser.getUrls(cur)) {
                if (!visited.contains(url) && getHostName(url).equals(hostName)) {
                    queue.offer(url);
                    visited.add(url);
                }
            }
        }
        return new ArrayList<>(visited);
    }
    
    private String getHostName(String url) {
        return url.split("/")[2];
    }
}
