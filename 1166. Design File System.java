class FileSystem {
    FileNode root;
    public FileSystem() {
        root = new FileNode("/");
    }
    
    public boolean createPath(String path, int value) {
        FileNode cur = root;
        String[] paths = path.split("/");
        for (int i = 0; i < paths.length; i++) {
            if (paths[i].isEmpty()) continue;
            if (i != paths.length - 1 && !cur.children.containsKey(paths[i])) return false;
            if (i == paths.length - 1) {
                if (cur.children.containsKey(paths[i])) return false; 
                cur.children.put(paths[i], new FileNode(paths[i]));
            }
            cur = cur.children.get(paths[i]);
        }
        cur.setVal(value);
        return true;
    }
    
    public int get(String path) {
        FileNode cur = root;
        String[] paths = path.split("/");
        for (String p : paths) {
            if (p.isEmpty()) continue;
            if (!cur.children.containsKey(p)) return -1;
            cur = cur.children.get(p);
        }
        return cur.getVal();
    }
    
    
    class FileNode {
        
        private String name;
        private int val;
        private Map<String, FileNode> children;
        
        public FileNode (String name) {
            this.name = name;
            this.val = -1;
            children = new HashMap<>();
        }
        
        public void setVal(int val) {
            this.val = val;
        }
        
        public int getVal() {
            return this.val;
        }
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */
