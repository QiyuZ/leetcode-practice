/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node inorderSuccessor(Node node) {
        if (node == null) return node;
        Node cand1 = getLeftOnRight(node);//option 1 右子树的最左边
        if(cand1 != null) return cand1;//parent > 左子树的右子树，所以如果右子树有合适的值直接返回
        Node cand2 = getParent(node);//option 2 parent,第一个作为左子树的
        if (cand2 == null) return null; 
        return cand2;
    }
    
    private Node getLeftOnRight(Node node) {
        Node copy = node;
        if (copy.right == null) return null;
        copy = copy.right;
        while (copy.left != null) copy = copy.left;
        return copy;
    }
    
    private Node getParent(Node node) {
        Node copy = node;
        Node parent = copy.parent;
        while (parent != null && parent.right == copy) {
            copy = parent;
            parent = copy.parent;
        }
        return parent;
    }
}
