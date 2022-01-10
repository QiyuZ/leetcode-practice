/**
 * Definition for a binary tree node.
 * class Node {
 *     char val;
 *     Node left;
 *     Node right;
 *     Node() {this.val = ' ';}
 *     Node(char val) { this.val = val; }
 *     Node(char val, Node left, Node right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public Node expTree(String s) {
        Stack<Node> nodes = new Stack<>(); //nodes for in order tree build
        Stack<Character> ops = new Stack<>();
        for (final char c : s.toCharArray()) {
            if (Character.isDigit(c)) nodes.push(new Node(c));
            else if (c == '(') ops.push(c);
            else if (c == ')') {
                while (!ops.isEmpty() && ops.peek() != '(') nodes.push(buildNode(ops.pop(), nodes.pop(), nodes.pop())); //note first pop is right, the second is left
                ops.pop(); // remove (
            } else { //c is +-*/
                while (!ops.isEmpty() && compare(ops.peek(), c)) nodes.push(buildNode(ops.pop(), nodes.pop(), nodes.pop())); //if the pre ops is higher prority then execute. We need to wait second op here since we need 2 number (nodes)
                ops.push(c); //push the current op
            }
        }
        while (!ops.isEmpty()) nodes.push(buildNode(ops.pop(), nodes.pop(), nodes.pop())); //there could be remaining like 1+2-3, all same leve ops
        return nodes.peek();
    }
    
    private Node buildNode(char op, Node right, Node left) {
        return new Node(op, left, right);
    }
    
      // return true if op1 is a operator and priority(op1) >= priority(op2).
    private boolean compare(char op1, char op2) { 
        if (op1 == '(' || op1 == ')') return false;
        return op1 == '*' || op1 == '/' || op2 == '+' || op2 == '-';
  }
}
