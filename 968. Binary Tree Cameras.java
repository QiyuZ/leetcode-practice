class Solution {
    private int camera = 0;
    public int minCameraCover(TreeNode root) {
        if (root == null) return 0;
        return cover(root) == Status.needed ? camera + 1 : camera; //don't forget check the root
    }
    
    private Status cover(TreeNode root) { //from bottom to top
        if (root == null) return Status.covered; //treated as covered 
        Status left = cover(root.left), right = cover(root.right);
        if (left == Status.needed || right == Status.needed) { //note use or here as even one needed, we need to install camera here
            camera++;
            return Status.installed;
        }
        if (left == Status.installed || right == Status.installed) return Status.covered; //if either one installed, this will be covered
        return Status.needed; //this is for left and right are covered, but the current level will be needed
    }
    
    public enum Status {
        covered,
        installed,
        needed
    }
}
