public class Codec {
    private Map<String, String> map = new HashMap<>();
    private int count = 0;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map.put(count + "", longUrl);
        count++;
        return (count - 1) + "";
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
