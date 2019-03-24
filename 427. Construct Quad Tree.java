class Solution {
    public Node construct(int[][] grid) {
        return fun(grid,0,grid[0].length,0,grid.length);
    }
    public Node fun(int[][] grid,int left,int right,int top,int bottom){
        Node root = null;
        int key = grid[top][left];
        for(int i=top;i<bottom;i++){
            for(int j=left;j<right;j++){
                if(grid[i][j]!=key){
                    Node topLeft = fun(grid,left,(left+right)/2,top,(top+bottom)/2);
                    Node topRight = fun(grid,(left+right)/2,right,top,(top+bottom)/2);
                    Node bottomLeft = fun(grid,left,(left+right)/2,(top+bottom)/2,bottom);
                    Node bottomRight = fun(grid,(left+right)/2,right,(top+bottom)/2,bottom);
                    root = new Node(false,false,topLeft,topRight,bottomLeft,bottomRight);
                    return root;
                }
            }
        }
        root = new Node();
        root.val = key==1?true:false;
        root.isLeaf = true;
        return root;
    }
}
