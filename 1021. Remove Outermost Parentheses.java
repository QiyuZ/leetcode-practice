class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int sum = 0, left = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') sum++;
            else sum--;
            if (sum == 0 && i != 0) {
                String added = left == i - 1 ? "" : S.substring(left + 1, i);
                sb.append(added);
                left = i + 1;
            }
        }
        return sb.toString();
    }
}

class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int outer = 0;
        char[] cArr = S.toCharArray();
        for(char c : cArr){
            if(c == '('){
                outer++;
                if(outer != 1){
                    sb.append('(');
                }
            }else{
                outer--;
                if(outer != 0){
                    sb.append(')');
                }
            }
        }
        return sb.toString();
    }
}
