class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        char[] input = S.toCharArray();
        for(int i=0; i<input.length; i++){
            if(!stack.isEmpty() && input[i] == stack.peek()){
                stack.pop();
            }else{
                stack.push(input[i]);
            }
        }
        StringBuilder builder = new StringBuilder();
        for(char c : stack){
            builder.append(c);
        }
        return builder.toString();
    }
}


class Solution {
    public String removeDuplicates(String S) {
        char[] chars = S.toCharArray();
        int i = -1;
        for (int j = 0; j < chars.length; j++) {
            if (i != -1 && chars[i] == chars[j]) i--;
            else chars[++i] = chars[j];
        }
        return new String(chars, 0, i + 1);
    }
}
