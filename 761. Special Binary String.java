class Solution {
    public String makeLargestSpecial(String S) {
        int i = 0, count = 0;
        List<String> res = new ArrayList<>();
        for (int j = 0; j < S.length(); j++) {
            if (S.charAt(j) == '0') count--; //因为S 就是Special Binary String所以不有count小于0情况
            else count++;
            if (count == 0) {
                res.add("1" + makeLargestSpecial(S.substring(i + 1, j)) + "0"); //找到的肯定是Special Binary String，根据性质，中间的也是
                i = j + 1;
            }
            
        }
        Collections.sort(res, Collections.reverseOrder());
        return String.join("", res);
    }
}
