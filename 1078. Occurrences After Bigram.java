class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] texts = text.split(" ");
        List<String> res = new ArrayList<>();
        for (int i = 2; i < texts.length; i++) {
            if (texts[i - 2].equals(first) && texts[i - 1].equals(second)) res.add(texts[i]);
        }
        return res.toArray(new String[0]);
    }
}
