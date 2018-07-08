class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) { //same as "Minimum Genetic Mutation"
        Set<String> set= new HashSet<>();
        for(String s : wordList) set.add(s); //此处要用Set因为list里有重复，会使得重复计算无法通过test
        if(!set.contains(endWord)) return 0;
        if (beginWord.equals(endWord)) return 1;
        int count = 1;
        int len = beginWord.length();
        Queue<String> que= new LinkedList<>();
        Set<String> visited = new HashSet<>();
        que.add(beginWord);
        visited.add(beginWord);
        while(que.size()>0) {
            int n = que.size();
            count++;
            while (n-- > 0){
                char[] ca = que.poll().toCharArray();
                for(int idx = 0; idx < len; idx++){
                    char c = ca[idx];
                    for(char newc = 'a'; newc <= 'z'; newc++){
                        ca[idx] = newc;
                        String newString = new String(ca);
                        if(newString.equals(endWord)) return count;
                        if(set.contains(newString) && !visited.contains(newString)){
                            que.add(newString);
                            visited.add(newString);
                        }
                    }
                    ca[idx]=c;
                }
            }
        }
        return 0;
    }
}
