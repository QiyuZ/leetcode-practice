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
