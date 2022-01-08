class FileSystem {
    private FileNode root;
    public FileSystem() {
        root = new FileNode("/");
    }
    
    public List<String> ls(String path) {
        return getOrCreateFile(path).getList();
    }
    
    public void mkdir(String path) {
        getOrCreateFile(path);
    }
    
    public void addContentToFile(String filePath, String content) {
        getOrCreateFile(filePath).writeContent(content);
    }
    
    public String readContentFromFile(String filePath) {
        return getOrCreateFile(filePath).getContent();
    }
    
    private FileNode getOrCreateFile(String path) {
        String[] names = path.split("/");
        FileNode cur = root;
        for (String name : names) {
            if (name.isEmpty()) continue; // 比如空格或者/
            if (!cur.children.containsKey(name)) cur.children.put(name, new FileNode(name));
            cur = cur.children.get(name);
            if (cur.isFileType()) break; // not a dire, stop there
        }
        return cur;
    }
    
    class FileNode {
        private String name;
        private TreeMap<String, FileNode> children;
        private StringBuilder content;
        private boolean isFile;
        
        public FileNode (String path) {
            this.name = path;
            this.children = new TreeMap<>();
            this.content = new StringBuilder();
            this.isFile = false;
        }
        
        public String getContent() {
            return this.content.toString();
        }
        
        public void writeContent(String newContent) {
            content.append(newContent);
            if (!isFile) isFile = true;
        }
        
        public boolean isFileType() {
            return this.isFile;
        }
        
        public String getName() {
            return this.name;
        }
        
        public List<String> getList() {
            List<String> res = new ArrayList<>();
            if (isFileType()) res.add(name);
            else res.addAll(children.keySet());
            return res;
        }
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
