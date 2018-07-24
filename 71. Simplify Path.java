class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return path;
        Stack<String> stack = new Stack<>();
        String[] ps = path.split("\\/+"); //分割多个/
        for (String p : ps) {
            if (!stack.isEmpty() && p.equals("..")) stack.pop();
            else if (!p.equals(".") && !p.equals("") && !p.equals("..")) stack.push(p);
        }
        List<String> res = new ArrayList<>(stack); //注意直接用stack顺序是反的
        return "/" + String.join("/", res);
    }
}
