/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        buildString(sb, root);
        sb.setLength(sb.length() - 1); //注意17， 18 行分开写因为setLength 是void
        return sb.toString();
    }
    
    private void buildString(StringBuilder sb, TreeNode root) {
        if (root == null) return;
        sb.append(root.val);
        sb.append(",");
        buildString(sb, root.left);
        buildString(sb, root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return buildTree(queue, Integer.MAX_VALUE, Integer.MIN_VALUE); //use largest and smallest as init value 
    }
    
    private TreeNode buildTree(Queue<String> queue, int max, int min) {
        if (queue.isEmpty()) return null;
        int peek = Integer.parseInt(queue.peek()); //note, it should poll here as we don't know if it's null or valid
        if (peek >= max || peek <= min) return null; //has to be in the range, if not then it means the current one is null (end of the dfs)
        queue.poll();
        TreeNode root = new TreeNode(peek);
        root.left = buildTree(queue, peek, min); //use current one as largest one
        root.right = buildTree(queue, max, peek); //use current one as smallest one
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
