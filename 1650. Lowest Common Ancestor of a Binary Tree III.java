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
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Integer> set = new HashSet<>();
        while (p != null) {
            set.add(p.val);
            p = p.parent;
        }
        while (q != null) {
            if (set.contains(q.val)) return q;
            q = q.parent;
        }
        return null;
    }
}

//detect the intersection
class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node runner1 = p, runner2 = q;
        
        while (runner1 != runner2) { // Guaranteed to complete since both nodes belong to same tree
            // We are simulating a cycle when any of the conditions below is satisfied 
            // by pointing runner to the head of the other "list"  to make sure 
            // intersection is found before either of the below conditions are satisfied again
            runner1 = (runner1 == null)?q:runner1.parent;
            runner2 = (runner2 == null)?p:runner2.parent;
        }
        
        return runner1;
    }
}
