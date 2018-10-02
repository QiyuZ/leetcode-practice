public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) sb.append(s.length()).append("*").append(s); 
        //因为str里可能含有各种稀奇古怪的字符，所以加上len作为标识有多长，*来分割，这样即使字符串中有*也不会影响，因为会前找到前面分割的*
        //比如3,2*5 -> 1*33*2*5,第三个*不会被找
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int pos = 0;
        while (pos < s.length()) {
            int index = s.indexOf("*", pos);
            int size = Integer.parseInt(s.substring(pos, index)); //知道长度
            res.add(s.substring(index + 1, index + size + 1)); //截取string
            pos = index + size + 1; //更新为上次结束的地方（不包括）
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
