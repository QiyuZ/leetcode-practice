/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        getSortedElements(root1, list1);
        getSortedElements(root2, list2);
        return mergeSort(list1, list2);
    }
    
    private void getSortedElements(TreeNode root, List<Integer> list) {
        if (root == null) return;
        getSortedElements(root.left, list);
        list.add(root.val);
        getSortedElements(root.right, list);
    }
    
    private List<Integer> mergeSort(List<Integer> list1, List<Integer> list2) {
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < list1.size() || j < list2.size()) {
            if (i == list1.size()) res.add(list2.get(j++));
            else if (j == list2.size()) res.add(list1.get(i++));
            else {
                if (list1.get(i) > list2.get(j)) res.add(list2.get(j++));
                else if (list1.get(i) < list2.get(j)) res.add(list1.get(i++));
                else {
                    res.add(list1.get(i++));
                    res.add(list2.get(j++));
                }
            }
        }
        return res;
    }
}


class Solution {
  public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    ArrayDeque<TreeNode> stack1 = new ArrayDeque(), stack2 = new ArrayDeque();
    List<Integer> output = new ArrayList();

    while (root1 != null || root2 != null || !stack1.isEmpty() || !stack2.isEmpty()) {
      // update both stacks
      // by going left till possible
      while (root1 != null) {
        stack1.push(root1);
        root1 = root1.left;
      }
      while (root2 != null) {
        stack2.push(root2);
        root2 = root2.left;
      }

      // Add the smallest value into output,
      // pop it from the stack,
      // and then do one step right
      if (stack2.isEmpty() || !stack1.isEmpty() && stack1.getFirst().val <= stack2.getFirst().val) {
        root1 = stack1.pop();
        output.add(root1.val);
        root1 = root1.right;
      }
      else {
        root2 = stack2.pop();
        output.add(root2.val);
        root2 = root2.right;
      }
    }
    return output;
  }
}
