class FileSystem {

    private FileNode root;
    
    public FileSystem() {
        root = new FileNode("");
    }
    
    public List<String> ls(String path) {
        return createFileNode(path).getList();
    }
    
    public void mkdir(String path) {
        createFileNode(path);
    }
    
    public void addContentToFile(String filePath, String content) {
        createFileNode(filePath).addContent(content);
    }
    
    public String readContentFromFile(String filePath) {
        return createFileNode(filePath).getContent();
    }
    
    public FileNode createFileNode(String path) {
        String[] files = path.split("/");
        FileNode cur = root;
        for (String f : files) {
            if (f.length() == 0) continue; // 说明是//等价/
            if (!cur.children.containsKey(f)) cur.children.put(f, new FileNode(f));
            cur = cur.children.get(f);
            if (cur.isFileType()) break;
        }
        return cur;
    }
    
    private class FileNode {
        private TreeMap<String, FileNode> children;
        private StringBuilder file;
        private String name;
        private boolean isFile;
        
        public FileNode(String path) {
            children = new TreeMap<>();
            file = new StringBuilder();
            this.name = path;
            isFile = false;
        }
        
        public String getContent(){
            return file.toString();
        }

        public String getName(){
            return name;
        }

        public void addContent(String content){
            isFile = true;
            file.append(content);
        }

        public boolean isFileType(){
            return isFile;
        }
        
        public List<String> getList(){
            List<String> list = new ArrayList<>();
            if(isFileType()) list.add(getName());
            else list.addAll(children.keySet());
            return list;
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
