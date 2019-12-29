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

class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        if (startUrl == null || startUrl.length() == 0) return new ArrayList<>();
        String hostName = getHostName(startUrl);
        Set<String> visited = new HashSet<>();
        dfs(startUrl, htmlParser, visited, hostName);
        return new ArrayList<>(visited);
    }
    
    private void dfs(String url, HtmlParser htmlParser, Set<String> visited, String host) {
        if (visited.contains(url)) return;
        visited.add(url);
        for (String next : htmlParser.getUrls(url)) {
            if (host.equals(getHostName(next))) dfs(next, htmlParser, visited, host);
        }
    }
    
    private String getHostName(String url) {
        return url.split("/")[2];
    }
}
