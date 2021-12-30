//For this sort, it should be O(n * m * logn) m is the len of the string
//Also the startsWith will cost O(m) every time. So overall, it's O(n * m * (logn + 1)) = O(n * m * logn)
class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> res = new ArrayList<>();
        if (folder == null || folder.length == 0) return res;
        Arrays.sort(folder);
        for (String f : folder) {
            if (res.isEmpty() || !f.startsWith(res.get(res.size() - 1) + "/")) res.add(f); 
            //note we need / to avodi partly duplicate name, like ["/a/b/c","/a/b/ca"]
        }
        return res;
    }
}
