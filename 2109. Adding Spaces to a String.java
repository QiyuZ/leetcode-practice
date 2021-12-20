class Solution {
    public String addSpaces(String s, int[] spaces) {
        int i = 0, curr = 0;
        StringBuilder sb = new StringBuilder();
        while(curr < s.length()){
            if(i < spaces.length && spaces[i] == curr){
                sb.append(" ");
                i++;
            }
            sb.append(s.charAt(curr));
            curr++;
        }
        return sb.toString();
    }
}
